package com.feng;

import com.feng.util.ApplicationContextInfoUtils;
import com.feng.util.IpUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.net.Inet4Address;
import java.net.SocketException;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@MapperScan("com.feng.dao")
@EnableCaching
public class AssociationRestApplication {

    public static void main(String[] args) throws SocketException {
       ApplicationContext applicationContext = SpringApplication.run(AssociationRestApplication.class, args);
        ApplicationContextInfoUtils.printSystemInfo(applicationContext);
        Optional<Inet4Address> list = IpUtils.getIpBySocket();
        System.out.println("IP地址为");
        System.out.println("http:/" + list.get() + ":8081");

//        System.out.println("http://"+ IpUtils.getLocalIp4Address());
    }

}
