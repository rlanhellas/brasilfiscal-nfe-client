package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.NFIndicadorFormaPagamento;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFMeioPagamento;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PagamentoDTO {
    private NFIndicadorFormaPagamento indicadorFormaPagamento;
    private NFMeioPagamento moeda;
    private BigDecimal valorPago = BigDecimal.ZERO;;

    //informacoes do cartão
    private CartaoCreditoDTO cartaoCredito;
}
