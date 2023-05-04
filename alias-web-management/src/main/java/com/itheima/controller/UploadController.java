package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.OssUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @Autowired
    private OssUtils ossUtils;

    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("username:{}, age:{}, image: {}", username, age, image);
        String fileName = image.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        int extIndex = fileName.lastIndexOf(".");
        String extName = fileName.substring(extIndex);
        image.transferTo(new File(getClass().getResource("/").
                getPath() + "../../src/main/resources/static/" + uuid + extName));
        return Result.success();
    }

    @PostMapping("/upload2")
    public Result uploadToOss(MultipartFile image) throws IOException {
        String url = ossUtils.Upload(image);
        return Result.success(url);
    }
}
