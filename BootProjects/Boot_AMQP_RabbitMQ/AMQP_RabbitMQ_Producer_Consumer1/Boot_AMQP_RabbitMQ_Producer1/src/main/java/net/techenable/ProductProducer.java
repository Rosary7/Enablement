package net.techenable;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductProducer {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${my.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${my.rabbitmq.routingkey}")
	private String routingkey;

	public void produce(Product product){
		amqpTemplate.convertAndSend(exchange, routingkey, product);
		System.out.println("Sent message .. = " + product.toString());
	}
}