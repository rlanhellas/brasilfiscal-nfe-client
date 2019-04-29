package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.DFAmbiente;
import com.fincatto.documentofiscal.DFUnidadeFederativa;
import lombok.Data;

//informações para gerar a nota
@Data
public class AbstractInfoGeraNotaDTO {
    private String certificadoSenha;
    private String caminhoCertificadoPFX;

    //TODO: remover necessidade de passar a cadeia de certificados
    private String cadeiaCertificadosSenha;
    private String caminhoCadeiaCertificados;

    private DFUnidadeFederativa uf;
    private DFAmbiente ambienteNFE;
}
