package br.com.brasilfiscal.nfe.client.messages.response;

import lombok.Data;

@Data
public class ResponseEnviaNotaDevolucaoMessage {
    private String erro;
    private String chaveNota;
}
