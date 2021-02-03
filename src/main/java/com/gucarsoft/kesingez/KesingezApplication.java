package com.gucarsoft.kesingez;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.gucarsoft.kesingez.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableMethodCache(basePackages = "com.gucarsoft.kesingez")
@EnableConfigurationProperties({FileStorageProperties.class})
public class KesingezApplication {

	public static void main(String[] args) {
		SpringApplication.run(KesingezApplication.class, args);
	}

}
