package br.com.brasilfiscal.nfe.client.dto.common;

import lombok.Data;

@Data
public class EnderecoDTO {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private Integer codigoMunicipio;
    private String nomeMunicipio;
    private String uf;
    private String cep;
    private String telefone;
}
