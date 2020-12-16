package org.rockyang.shardingjdbc.dbt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"org.rockyang.shardingjdbc.common",
		"org.rockyang.shardingjdbc.dbt"
})
@MapperScan("org.rockyang.shardingjdbc.common.mapper")
public class DBTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(DBTableApplication.class, args);
	}

}
