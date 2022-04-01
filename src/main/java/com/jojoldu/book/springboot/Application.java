package com.jojoldu.book.springboot;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationDataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;


//해당 어노테이션이 있는 클래스 위치 부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야함.
// @EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        //내장 WAS를 실행, 이 내장WAS를 사용하면 Once Write할 수 있음.
    }

    @Bean
    public IntegrationDataSourceScriptDatabaseInitializer customIntegrationDataSourceInitializer(DataSource dataSource) {
        return new IntegrationDataSourceScriptDatabaseInitializer(dataSource, new DatabaseInitializationSettings());
    }
}
