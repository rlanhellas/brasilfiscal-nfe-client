package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFOperadoraCartao;
import com.fincatto.documentofiscal.nfe400.classes.nota.NFTipoIntegracaoPagamento;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoCreditoDTO {
    /*
        Tipo de Integração do processo de pagamento com o
        sistema de automação da empresa:
        1=Pagamento integrado com o sistema de automação da
        empresa (Ex.: equipamento TEF, Comércio Eletrônico);
        2= Pagamento não integrado com o sistema de automação
        da empresa (Ex.: equipamento POS);
    * */
    private NFTipoIntegracaoPagamento tipoIntegracao;
    private String cnpjCredenciadora;
    private NFOperadoraCartao bandeira;
    private String numeroAutorizacaoOperacaoCartao;
    private BigDecimal valorTroco = BigDecimal.ZERO;
}
