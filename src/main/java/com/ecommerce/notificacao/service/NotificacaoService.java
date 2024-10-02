package com.ecommerce.notificacao.service;

import com.ecommerce.notificacao.model.NotificacaoPedido;
import com.ecommerce.notificacao.rabbitmq.NotificacaoProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoProducer notificacaoProducer;

    public void enviarNotificacao(NotificacaoPedido notificacaoPedido) {
        notificacaoProducer.send(notificacaoPedido);
    }
}
