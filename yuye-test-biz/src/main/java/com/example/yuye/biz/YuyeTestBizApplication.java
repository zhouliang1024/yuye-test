package com.example.yuye.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableKstry(bpmnPath = "./bpmn/*.bpmn")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableConfigurationProperties
//@EnableJpaRepositories(basePackages = {"com.example.yuye.dal"})
//@EntityScan(basePackages = { "com.example.yuye.dal.model" })
@MapperScan(value = {"com.example.yuye.dal.mapper","com.example.yuye.dal.dao"})
public class YuyeTestBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(YuyeTestBizApplication.class, args);
    }

}
