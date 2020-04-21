package com.ticket.app.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TicketUserSeriviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketUserSeriviceApplication.class, args);
	}

}
