package com.feng;

import com.feng.util.ApplicationContextInfoUtils;
import com.feng.util.IpUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.SocketException;
import java.util.Optional;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
@RestController
public class AssociationAdminApplication {

	public static void main(String[] args) throws SocketException {
		ApplicationContext applicationContext =SpringApplication.run(AssociationAdminApplication.class, args);
		//打印系统访问信息
		ApplicationContextInfoUtils.printSystemInfo(applicationContext);
		Optional<Inet4Address> list = IpUtils.getIpBySocket();
		System.out.println("IP地址为");
		System.out.println("http:/" + list.get() + ":8081");
	}

}
