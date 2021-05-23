package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AtmBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmBackendServiceApplication.class, args);
	}

//	@Bean
//	public static JdbcTemplate getJdbcTemplate() {
//		return new JdbcTemplate(getDataSource());
//	}
//
//	private static EmbeddedDatabase getDataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//
//		EmbeddedDatabase db = builder.setType(EmbeddedDatabaseType.DERBY).addScript("sql/createschema.sql")
//				.addScript("sql/insertdata.sql").build();
//		return db;
//	}
}
