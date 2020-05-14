package net.techenable;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Consumer {
	
	@RabbitListener(queues="${my.rabbitmq.queue}", containerFactory="myFactory")
    public void recievedMessage(Product product) {
        System.out.println("Recieved Message..: " + product.toString());
    }
}