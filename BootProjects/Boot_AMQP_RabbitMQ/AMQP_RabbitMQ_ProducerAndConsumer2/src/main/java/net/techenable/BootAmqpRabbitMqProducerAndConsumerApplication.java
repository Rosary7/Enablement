package net.techenable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootAmqpRabbitMqProducerAndConsumerApplication implements CommandLineRunner {

	@Autowired
	ProducerConsumer producerConsumer;
	
	public static void main(String[] args) {
		SpringApplication.run(BootAmqpRabbitMqProducerAndConsumerApplication.class, args);
	}

	public void run(String... args) throws Exception{
		// Send message
		producerConsumer.sendMessege("helo");
	}
}
