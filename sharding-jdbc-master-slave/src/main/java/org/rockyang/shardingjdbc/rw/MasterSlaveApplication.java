package org.rockyang.shardingjdbc.rw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
		"org.rockyang.shardingjdbc.common",
		"org.rockyang.shardingjdbc.rw"
})
@MapperScan("org.rockyang.shardingjdbc.common.mapper")
public class MasterSlaveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterSlaveApplication.class, args);
	}

}
