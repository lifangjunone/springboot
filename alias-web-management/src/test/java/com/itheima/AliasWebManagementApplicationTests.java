package com.itheima;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.dom4j.io.SAXReader;

@SpringBootTest
class AliasWebManagementApplicationTests {

	@Autowired
	private SAXReader saxReader;


	@Test
	void contextLoads() {
	}

	@Test
	void ossTest() throws Exception {
		// Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
		String endpoint = "xxx";
		// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
		String accessKeyId = "xxx";
		String accessKeySecret = "xxx";
		// 填写Bucket名称，例如examplebucket。
		String bucketName = "java-usage";
		// 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
		String objectName = "test/53e4e5c5-3692-497d-9272-e7d300935a32.png";
		// 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
		// 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
		String filePath= "/home/lifangjun/java_projects/springboot/alias-web-management/src/main/resources/static/53e4e5c5-3692-497d-9272-e7d300935a32.png";

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		try {
			InputStream inputStream = new FileInputStream(filePath);
			// 创建PutObjectRequest对象。
			PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
			// 设置该属性可以返回response。如果不设置，则返回的response为空。
			putObjectRequest.setProcess("true");
			// 创建PutObject请求。
			PutObjectResult result = ossClient.putObject(putObjectRequest);
			// 如果上传成功，则返回200。
			System.out.println(result.getResponse().getStatusCode());
		} catch (OSSException oe) {
			System.out.println("Caught an OSSException, which means your request made it to OSS, "
					+ "but was rejected with an error response for some reason.");
			System.out.println("Error Message:" + oe.getErrorMessage());
			System.out.println("Error Code:" + oe.getErrorCode());
			System.out.println("Request ID:" + oe.getRequestId());
			System.out.println("Host ID:" + oe.getHostId());
		} catch (ClientException ce) {
			System.out.println("Caught an ClientException, which means the client encountered "
					+ "a serious internal problem while trying to communicate with OSS, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message:" + ce.getMessage());
		} finally {
			if (ossClient != null) {
				ossClient.shutdown();
			}
		}
	}

	@Test
	void genJWTTest() {

		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1);
		claims.put("name", "god");
		String jwtStr = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, "god is girl") // 签名算法，　秘钥字符串
				.setClaims(claims) // 用户自定义负载信息
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 有效期为一小时
				.compact();
		System.out.println(jwtStr);
	}

	@Test
	void parseJWTTest() {
		Claims claims = Jwts.parser()
				.setSigningKey("god is girl")
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiZ29kIiwiaWQiOjEsImV4cCI6MTY4MzI2Njc1NX0.azOS0SqChHpcwTOJMAHUJy-YDF7At9BMcjMiGmNdmNM")
				.getBody();
		System.out.println(claims);
	}

	@Test
	void parseXML() throws Exception {
		Document doc = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
		Element rootElement = doc.getRootElement();
		String name = rootElement.element("name").getText();
		String age = rootElement.element("age").getText();
		System.out.println(name + ":" + age);
	}
}
