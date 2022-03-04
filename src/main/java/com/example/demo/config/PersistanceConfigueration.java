package com.example.demo.config;



import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistanceConfigueration {

	
	@Bean
	public DataSource dataSource() {
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url("jdbc:mysql://localhost/contactsdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		builder.password("");
		builder.driverClassName("com.mysql.cj.jdbc.Driver");
		builder.username("root");
		System.out.println("My custom data source has been initialized and set");
		return builder.build();
	}
}
