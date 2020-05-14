c.package net.techenable;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * AmqpTemplate is an interface. RabbitTemplate is an implementation of the AmqpTemplate interface. 
 */
@Component
public class ProducerConsumer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Value("${my.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${my.rabbitmq.routingkey}")
	private String routingkey;

	// Producer
	public void sendMessege(String msg){
		// Send an event
		rabbitTemplate.convertAndSend(exchange, routingkey, msg);
		System.out.println("Sent message........: " + msg);
	}
	
	// Consumer
	@RabbitListener(queues="${my.rabbitmq.queue}", containerFactory="myFactory")
    public void recievedMessage(String msg) {
        System.out.println("Recieved Message........: " + msg);
    }
}
