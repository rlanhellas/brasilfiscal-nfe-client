package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.*;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

@Data
public class ItemNotaDTO {
    private Integer codigoItemNaVenda;
    private String codigoProduto;
    private String gtin;//codigoBarras
    private String descricao;
    private String ncm;
    private String cest;
    private boolean escalaNaoRelevante;
    private String cnpjFabricante;
    private String codigoBeneficioFiscal;
    private String codigoExDaTIPI;
    private String cfop;
    private String unidade;
    private BigDecimal quantidade = BigDecimal.ZERO;
    private BigDecimal valorUnitario = BigDecimal.ZERO;
    private BigDecimal valorDescontoTotal = BigDecimal.ZERO;
    private BigDecimal valorFrete = BigDecimal.ZERO;
    private String cnpjProdutor;
    private String codigoSelo;
    private BigInteger quantidadeSelo = BigInteger.ZERO;
    private String codigoEnquadramentoLegalIPI;

    //impostos
    private NFOrigem origemMercadoria;
    private NFNotaInfoImpostoTributacaoICMS cstICMS;
    private NFNotaInfoSituacaoTributariaIPI cstIPI;
    private NFNotaInfoSituacaoTributariaPIS cstPIS;
    private NFNotaInfoSituacaoTributariaCOFINS cstCOFINS;
    private BigDecimal aliquotaIcms = BigDecimal.ZERO;
    private BigDecimal aliquotaIcmsST = BigDecimal.ZERO;
    private BigDecimal aliquotaIPI = BigDecimal.ZERO;
    private BigDecimal aliquotaPIS = BigDecimal.ZERO;
    private BigDecimal aliquotaCOFINS = BigDecimal.ZERO;

    //quando for isento
    private NFNotaMotivoDesoneracaoICMS motivoDesoneracaoICMS;
    private BigDecimal aliquotaDesoneracaoICMS;

    //substituicao tributaria
    private BigDecimal aliquotaMVA = BigDecimal.ZERO;//margem valor agregado

    //credito presumido
    private BigDecimal creditoPresumidoICMSST = BigDecimal.ZERO;

    /**
     * Valor Unitário - Desconto Por Unidade
     */
    public BigDecimal getValorUnitarioTributavel() {
        return getValorUnitario()
                .add(valorFrete.divide(getQuantidade(), 2, RoundingMode.HALF_UP))
                .subtract(getValorDescontoTotal().divide(getQuantidade(), 2, RoundingMode.HALF_UP));
    }

    /**
     * (ValorUnitário - Desconto) * Quantidade
     */
    public BigDecimal getValorLiquidoTotal() {
        return getValorUnitarioTributavel().multiply(getQuantidade()).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * (Aliquota Icms * Valor Liquido do Item) - (Credito Presumido, se houver)
     */
    public BigDecimal getValorIcms() {
        return getValorLiquidoTotal().multiply(aliquotaIcms.divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Valor Liquido Total * (1+(%MVA/100))
     * <p>
     * v_liquido 			:= r_get_venda_prod_12.vl_liquido;
     * v_desconto			:= r_get_venda_prod_12.vl_desconto;
     * v_base_icms_item  	:= r_get_venda_prod_12.vl_liquido;
     * v_aliq_icms_item  	:= resultGet_Aliq_Icms.V_ICMS_CONTRIB;
     * perc_cred_presumido := resultado2.V_DESCONTO_REG_ESPECIAL * 0.01;
     * perc_icms			:= resultGet_Aliq_Icms.V_ICMS_CONTRIB * 0.01;
     * v_valor_icms_item 	:= (r_get_venda_prod_12.vl_liquido * perc_icms);
     * v_credito_presumido := (r_get_venda_prod_12.vl_liquido * perc_cred_presumido);
     * v_base_st_item  	:= (r_get_venda_prod_12.vl_liquido + r_get_venda_prod_12.vl_rateio_frete + r_get_venda_prod_12.vl_ipi);
     * v_base_st_tmp   	:= (v_base_st_item * (resultGet_Aliq_Icms.V_MVA * 0.01));
     * v_base_st_item  	:= v_base_st_item + v_base_st_tmp;
     */
    public BigDecimal getValorBaseICMSST() {
        BigDecimal baseSTSemMVA = getValorLiquidoTotal().add(getValorIPI());
        BigDecimal valorMVA = baseSTSemMVA.multiply(aliquotaMVA.multiply(new BigDecimal(0.01)));
        return baseSTSemMVA.add(valorMVA).setScale(2, BigDecimal.ROUND_HALF_UP);

    }

    /**
     * v_aliq_st_item  	:= resultGet_Aliq_Icms.V_ICMS_CONTRIB;
     * * v_valor_st_tmp  	:= (v_base_st_item * (resultGet_Aliq_Icms.V_ICMS_CONTRIB * 0.01));
     * * v_valor_st_item 	:= v_valor_st_tmp - v_credito_presumido;
     */
    public BigDecimal getValorICMSST() {
        BigDecimal valorIcmsSTTemp = aliquotaIcmsST.equals(BigDecimal.ZERO) ?
                BigDecimal.ZERO :
                getValorBaseICMSST().multiply(aliquotaIcmsST.multiply(new BigDecimal(0.01)));
        if (creditoPresumidoICMSST.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal credito = getValorLiquidoTotal().multiply(creditoPresumidoICMSST.divide(new BigDecimal(100)));
            return valorIcmsSTTemp.subtract(credito).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            return valorIcmsSTTemp.subtract(getValorIcms()).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
    }

    /**
     * Aliquota IPI * Valor Liquido do Item
     */
    public BigDecimal getValorIPI() {
        return getValorLiquidoTotal().multiply(aliquotaIPI.divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Aliquota PIS * Valor Liquido do Item
     */
    public BigDecimal getValorPIS() {
        return getValorLiquidoTotal().multiply(aliquotaPIS.divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Aliquota COFINS * Valor Liquido do Item
     */
    public BigDecimal getValorCofins() {
        return getValorLiquidoTotal().multiply(aliquotaCOFINS.divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Aliquota Desoneração * Valor Liquido do Item
     */
    public BigDecimal getValorDesoneracao() {
        if (aliquotaDesoneracaoICMS != null) {
            return getValorLiquidoTotal().multiply(aliquotaDesoneracaoICMS.divide(new BigDecimal(100))).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.ZERO;
        }
    }
}

