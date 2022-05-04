package com.springjdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.springjdbc.dao"})
public class JdbcConfig {

	@Bean
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		dm.setUsername("root");
		dm.setPassword("root");
		return dm;
	}
	
	@Bean(name= {"jTemplet"})
	public JdbcTemplate getJTemplate() {
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(getDataSource());
		return jt;
	}
	

}
