package com.ecommerce.notificacao.controller;

import com.ecommerce.notificacao.model.NotificacaoPedido;
import com.ecommerce.notificacao.service.NotificacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @PostMapping("/notificacao-pedido")
    public ResponseEntity<String> enviaStatusDoPedido(@RequestBody NotificacaoPedido notificacaoPedido) {
        log.info("Enviando status do pedido: {}", notificacaoPedido);
        try {
            notificacaoService.enviarNotificacao(notificacaoPedido);
            return ResponseEntity.ok("Notificação enviada com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao enviar notificação");
        }
    }
}
