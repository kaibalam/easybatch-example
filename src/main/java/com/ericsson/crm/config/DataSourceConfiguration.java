package com.ericsson.crm.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.util.StringUtils;

@Configuration
public class DataSourceConfiguration {
	
	@Value("${spring.datasource.jndi-name}")
	private String springDatasourceName;
	
	@Value("${security.datasource.jndi-name}")
	private String securityDatasourceName;

	@Primary
	@Bean(name = "primaryDataSource", destroyMethod = "")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource primaryDataSource() throws NamingException {
		if(StringUtils.hasText(springDatasourceName)) {
			return (DataSource) new JndiTemplate().getContext().lookup(springDatasourceName);	
		}
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean
	public JdbcTemplate jdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "sec", destroyMethod = "")
	@ConfigurationProperties(prefix = "security.datasource")
	public DataSource securityDataSource() throws NamingException {
		if(StringUtils.hasText(securityDatasourceName)) {
			return (DataSource) new JndiTemplate().getContext().lookup(securityDatasourceName);
		}
		return DataSourceBuilder.create().build();
	}
}
