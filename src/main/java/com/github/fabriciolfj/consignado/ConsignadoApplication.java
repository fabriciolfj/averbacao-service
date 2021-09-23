package com.github.fabriciolfj.consignado;

import com.github.fabriciolfj.consignado.gateway.repositories.ConsignadoRepository;
import com.github.fabriciolfj.consignado.gateway.repositories.entities.ConsignadoEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients(basePackages = "com.github.fabriciolfj.consignado.gateway.provider.http")
@EnableJpaRepositories(basePackageClasses = ConsignadoRepository.class)
@EntityScan(basePackageClasses = ConsignadoEntity.class)
@SpringBootApplication
public class ConsignadoApplication {

	public static void main(final String[] args) {
		SpringApplication.run(ConsignadoApplication.class, args);
	}

}
