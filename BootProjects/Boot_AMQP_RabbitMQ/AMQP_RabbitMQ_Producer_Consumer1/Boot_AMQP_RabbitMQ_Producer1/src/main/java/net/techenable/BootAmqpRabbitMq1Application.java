package net.techenable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootAmqpRabbitMq1Application implements CommandLineRunner{

	@Autowired
	private ProductProducer productProducer;
	
	public static void main(String[] args) {
		SpringApplication.run(BootAmqpRabbitMq1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Product product = new Product(10L,"ipod");
		productProducer.produce(product);
	}

}
