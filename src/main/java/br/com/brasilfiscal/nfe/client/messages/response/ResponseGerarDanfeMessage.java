package br.com.brasilfiscal.nfe.client.messages.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseGerarDanfeMessage {
    private String pdfBase64;
    private String erro;
}
