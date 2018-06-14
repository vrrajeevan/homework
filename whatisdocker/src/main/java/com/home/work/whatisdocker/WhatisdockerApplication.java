package com.home.work.whatisdocker;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;

@SpringBootApplication
@ComponentScan(value = {"com.home.work.whatisdocker"})
public class WhatisdockerApplication {

	public static void main(String[] args) {
	
		ConfigurableApplicationContext ctx=SpringApplication.run(WhatisdockerApplication.class, args);
		
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
}
