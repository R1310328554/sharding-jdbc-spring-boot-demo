package org.rockyang.shardingjdbc.cusalgo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"org.rockyang.shardingjdbc.common",
		"org.rockyang.shardingjdbc.cusalgo"
})
@MapperScan("org.rockyang.shardingjdbc.common.mapper")
public class CustomAlgorithmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomAlgorithmApplication.class, args);
	}

}
