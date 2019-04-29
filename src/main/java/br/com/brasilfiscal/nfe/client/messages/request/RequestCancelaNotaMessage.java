package br.com.brasilfiscal.nfe.client.messages.request;

import br.com.brasilfiscal.nfe.client.dto.InfoCancelaNotaDTO;
import lombok.Builder;
import lombok.Data;

@Data
public class RequestCancelaNotaMessage {
    private InfoCancelaNotaDTO infoCancelaNotaDTO;
}
