package com.minhaempresa.meuecommerce.orquestrador.configuracao;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {

    @Bean
    public Queue montarFila(){
        return new Queue("vendaCriada", true);
    }

    @Bean
    public TopicExchange montarExchange(){
        return new TopicExchange("vendaCriadaExchange");
    }

    @Bean
    public Binding montarBinding(Queue fila, TopicExchange exchange){
        return BindingBuilder.bind(fila).to(exchange).with("vendaCriada");
    }

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses("localhost:5672");
        connectionFactory.setUsername("myuser");
        connectionFactory.setPassword("mypassword");
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
     var rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
     return new Jackson2JsonMessageConverter();
    }

}
