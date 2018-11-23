package de.postbank.springsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@EnableBinding(Sink.class)
//@IntegrationComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class CustomerserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerserviceApplication.class, args);
	}

}

@RestController
class CustomerService {
//	@Autowired
//	private Sink sink;
	private String[] customers = new String[] {"Jane", "John"};

	public CustomerService() {
	}

	@RequestMapping("/customers")
	public List<String> getCustomers() {
		return Arrays.asList(customers);
	}
}

//@MessageEndpoint
//class MessageProcessor {
//	@ServiceActivator(inputChannel = Sink.INPUT)
//	public void acceptMessage(String name) {
//		System.out.println("Got " + name);
//	}
//}

class Customer {
	private String name;

	public Customer() {
	}

	public Customer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
