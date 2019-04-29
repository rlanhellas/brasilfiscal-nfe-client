package br.com.brasilfiscal.nfe.client.messages.response;

import lombok.Data;

@Data
public class ResponseVisualizarXmlNotaDevolucaoMessage {
    private String erro;
    private String xml;
}
