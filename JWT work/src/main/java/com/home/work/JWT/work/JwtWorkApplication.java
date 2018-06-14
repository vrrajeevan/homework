package com.home.work.JWT.work;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories // This annotation will enable JPA repositories. This will scan for Spring Data repositories in the annotated configuration class by default.
public class JwtWorkApplication {

	
		public static void main(String[] args) {
			
			ConfigurableApplicationContext ctx=SpringApplication.run(JwtWorkApplication.class, args);
			
			System.out.println("######## Active Profoiles"+Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
			
			System.out.println("########### System Properties################");
			
			Properties props=System.getProperties();
			props.list(System.out);
			System.out.println("########### System Properties END################");
			
			
			  ConfigurableEnvironment env = ctx.getEnvironment();
		        printSources(env);
		        System.out.println("---- System properties -----");
		        printMap(env.getSystemProperties());
		        System.out.println("---- System Env properties -----");
		        printMap(env.getSystemEnvironment());
			
		}
		
		
		private static void printSources (ConfigurableEnvironment env) {
	        System.out.println("---- property sources ----");
	        for (PropertySource<?> propertySource : env.getPropertySources()) {
	            System.out.println("name =  " + propertySource.getName() + "\nsource = " + propertySource
	                                .getSource().getClass()+"\n");
	        }
	    }

	    private static void printMap (Map<?, ?> map) {
	        map.entrySet()
	           .stream()
	           .forEach(e -> System.out.println(e.getKey() + " = " + e.getValue()));

	    }
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
