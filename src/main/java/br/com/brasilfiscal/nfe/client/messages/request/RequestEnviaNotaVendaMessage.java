package br.com.brasilfiscal.nfe.client.messages.request;

import br.com.brasilfiscal.nfe.client.dto.InfoGeraNotaVendaDTO;
import lombok.Data;

@Data
public class RequestEnviaNotaVendaMessage {
    private InfoGeraNotaVendaDTO infoGeraNotaVendaDTO;
}
