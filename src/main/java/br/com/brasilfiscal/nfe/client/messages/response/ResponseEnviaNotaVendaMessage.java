package br.com.brasilfiscal.nfe.client.messages.response;

import lombok.Data;

@Data
public class ResponseEnviaNotaVendaMessage {
    private String erro;
    private String chaveNota;
}
