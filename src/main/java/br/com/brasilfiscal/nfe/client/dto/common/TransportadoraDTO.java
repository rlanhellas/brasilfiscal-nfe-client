package br.com.brasilfiscal.nfe.client.dto.common;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class TransportadoraDTO implements Serializable {
    private BigDecimal pesoLiquido;
    private BigDecimal pesoBruto;
}
