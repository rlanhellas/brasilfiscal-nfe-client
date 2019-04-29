package br.com.brasilfiscal.nfe.client.messages.request;

import br.com.brasilfiscal.nfe.client.dto.InfoGeraNotaDevolucaoDTO;
import lombok.Data;

@Data
public class RequestEnviaNotaDevolucaoMessage {
    private InfoGeraNotaDevolucaoDTO infoGeraNotaDevolucaoDTO;
}
