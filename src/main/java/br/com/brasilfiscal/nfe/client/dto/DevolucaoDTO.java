package br.com.brasilfiscal.nfe.client.dto;

import br.com.brasilfiscal.nfe.client.dto.common.AbstractOperacaoNotaDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class DevolucaoDTO extends AbstractOperacaoNotaDTO {
    private List<String> chavesNotasReferenciadas = new ArrayList<>();
}
