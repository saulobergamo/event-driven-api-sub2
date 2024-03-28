package com.example.sub1.listener

import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitHandler
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
@RabbitListener(queues = ["\${spring.rabbitmq.name.queue1}"])
class RabbitMQListener {
    private val logger = KotlinLogging.logger {}

    @RabbitHandler
    fun readFromQueue(message: String) {
        logger.info { "readFromQueue: message read from queue1 - message=$message" }
    }
}
