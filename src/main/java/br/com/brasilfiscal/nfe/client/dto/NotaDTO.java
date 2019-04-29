package br.com.brasilfiscal.nfe.client.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NotaDTO {
    private Long numero;
    private String idEmpresa;
    private String chave;
    private Date dataHora;
    private String xml;
    private Boolean producao;
    private Boolean cancelada;
}
