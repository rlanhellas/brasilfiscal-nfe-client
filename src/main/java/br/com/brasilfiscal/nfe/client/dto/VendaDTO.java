package br.com.brasilfiscal.nfe.client.dto;

import br.com.brasilfiscal.nfe.client.dto.common.AbstractOperacaoNotaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class VendaDTO extends AbstractOperacaoNotaDTO {
    private boolean clienteNaLoja;
}
