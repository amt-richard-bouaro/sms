package com.amalitech.sms;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class SmsApplication {

//	private final DataSource dataSource;
//
//	public SmsApplication(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}


	public static void main(String[] args) {
		SpringApplication.run(SmsApplication.class, args);
	}
//
//public void run(final String... args){
//		log.info("####### Datasource infomation: " + dataSource.toString());
//	JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
//	restTemplate.execute("SELECT 1");
//}

}
