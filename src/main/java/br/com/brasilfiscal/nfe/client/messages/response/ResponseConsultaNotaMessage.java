package br.com.brasilfiscal.nfe.client.messages.response;

import br.com.brasilfiscal.nfe.client.dto.NotaDTO;
import lombok.Data;

@Data
public class ResponseConsultaNotaMessage {
    private String erro;
    private NotaDTO notaDTO;
}
