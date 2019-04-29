package br.com.brasilfiscal.nfe.client.dto;

import br.com.brasilfiscal.nfe.client.dto.common.AbstractInfoGeraNotaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InfoGeraNotaDevolucaoDTO extends AbstractInfoGeraNotaDTO {
    private DevolucaoDTO devolucaoDTO;
}
