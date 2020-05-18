package io.techenable.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

   /*
	A Topic is a category/feed name to which records are stored and published. 
	All Kafka records are organized into topics. 
	Producer applications write data to topics and consumer applications read from topics.
	*/
	private static final String TOPIC = "user_names";

	/* 
	   The @KafkaListener annotation creates a ConcurrentMessageListenerContainer message 
	   listener container internally.
	 */
	@KafkaListener(topics = TOPIC, groupId = "group-id-test")
	public void consume(String message){
		System.out.println("The Consumed Message : " + message);
	}
}
