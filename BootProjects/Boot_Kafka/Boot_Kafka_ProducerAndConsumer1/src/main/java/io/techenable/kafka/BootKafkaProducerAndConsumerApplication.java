package io.techenable.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootKafkaProducerAndConsumerApplication implements CommandLineRunner{

	@Autowired
	private Producer producer;
	
	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProducerAndConsumerApplication.class, args);
	}
	
	public void run(String...strings)throws Exception{
		System.out.println("Produe Message...");
		String str = "Helo Kafka";
		producer.sendMessage(str);
	}

}
