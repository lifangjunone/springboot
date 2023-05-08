package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     * @return
     */

    @GetMapping
    public Result list() {
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 通过　id 查询部门数据
     * @param id
     * @return
     */
    @Log
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        Dept dept = deptService.get(id);
        if (dept == null) {
            return Result.error("id不存在");
        }
        return Result.success(dept);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        Boolean res = deptService.delete(id);
        if (res) {
            return Result.success();
        }else {
            return Result.error("id不存在");
        }
    }

    @Log
    @PostMapping
    public Result create(@RequestBody Dept dept) {
        log.info(String.valueOf(dept));
        Dept res =deptService.create(dept);
        if (res != null) {
            return Result.success(res);
        }else {
            return Result.error("创建部门失败");
        }

    }
}
