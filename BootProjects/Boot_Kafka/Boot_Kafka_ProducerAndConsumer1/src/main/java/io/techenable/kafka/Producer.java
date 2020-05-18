	package io.techenable.kafka;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.beans.factory.annotation.Value;
	import org.springframework.kafka.core.KafkaTemplate;
	import org.springframework.stereotype.Service;
	
	@Service
	public class Producer {
	
		/*
		A Topic is a category/feed name to which records are stored and published. 
		All Kafka records are organized into topics. 
		Producer applications write data to topics and consumer applications read from topics.
		Each record in the topic is stored with a key, value, and timestamp.
		*/	
		@Value("${my.topic}")
		private String topic;
		
		@Autowired
		private KafkaTemplate<String,String> kafkaTemplate;
		
		public void sendMessage(String message){
		System.out.println("The Produced message : " + message);
		kafkaTemplate.send(topic,message);
		}
		
	}
