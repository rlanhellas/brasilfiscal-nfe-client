package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.NFRegimeTributario;
import lombok.Data;

import java.io.Serializable;

@Data
public class EmitenteDTO implements Serializable {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private NFRegimeTributario regimeTributario;
    private EnderecoDTO endereco;
}
