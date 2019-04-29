package br.com.brasilfiscal.nfe.client.messages.request;

import lombok.Data;

@Data
public class RequestGerarDanfeMessage {
    private String urlLogmarca;
    private String xml;
}
