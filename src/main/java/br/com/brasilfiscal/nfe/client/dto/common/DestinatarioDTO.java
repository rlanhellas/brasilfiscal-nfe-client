package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIndicadorIEDestinatario;
import lombok.Data;

import java.io.Serializable;

@Data
public class DestinatarioDTO implements Serializable {
    private String cpf;
    private String cnpj;
    private String razaoSocialOuNome;
    private EnderecoDTO endereco;
    private NFIndicadorIEDestinatario indicadorIEDestinatario;
    private String inscricaoEstadual;
    private String inscricaoSuframa;
    private String inscricaoMunicipal;
    private String email;
}
