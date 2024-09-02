package com.millenium.etl.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.millenium.etl.common.dto.CommandLineArgumentsDTO;
import com.millenium.etl.common.repository.GenericEtlRepository;
import com.millenium.etl.common.service.CommandArgumentsLineServiceImpl;
import com.millenium.etl.common.service.DataModelService;
import com.millenium.etl.common.service.EtlPropertiesFactoryService;

@Configuration
@EnableJpaRepositories(basePackages = "com.millenium.etl.common.repository")
@EntityScan(basePackages = "com.millenium.etl.common.model")
public class SpringBootEtlCommonAutoConfiguration {
	
	@Bean
	@ConditionalOnMissingBean
	EtlPropertiesFactoryService<CommandLineArgumentsDTO> commandLineService(){
		return new CommandArgumentsLineServiceImpl();
	}
	
	@Bean
	@ConditionalOnMissingBean
	DataModelService dataModelService() {
		return new DataModelService();
	}
	
	@Bean
	@ConditionalOnMissingBean
	GenericEtlRepository genericEtlRepository() {
		return new GenericEtlRepository();
	}
	
}