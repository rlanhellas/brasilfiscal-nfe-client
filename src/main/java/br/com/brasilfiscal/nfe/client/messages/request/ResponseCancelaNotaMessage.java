package br.com.brasilfiscal.nfe.client.messages.request;

import lombok.Data;

@Data
public class ResponseCancelaNotaMessage {
    private String erro;
    private String chaveNotaCancelada;
    private String mensagemRetorno;
}
