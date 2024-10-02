package com.ecommerce.notificacao.rabbitmq;

import com.ecommerce.notificacao.model.NotificacaoPedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoProducer {

    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void send(NotificacaoPedido notificacaoPedido) {
        try {
            String json = objectMapper.writeValueAsString(notificacaoPedido);
            amqpTemplate.convertAndSend("notificacao-exchange", "notificacao-rk", json);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter/enviar notificação");
        }
    }
}
