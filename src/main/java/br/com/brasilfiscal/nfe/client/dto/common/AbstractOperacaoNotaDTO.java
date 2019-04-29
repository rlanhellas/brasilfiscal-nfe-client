package br.com.brasilfiscal.nfe.client.dto.common;

import com.fincatto.documentofiscal.nfe400.classes.nota.NFIdentificadorLocalDestinoOperacao;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Data
public abstract class AbstractOperacaoNotaDTO implements Serializable {
    private String numeroPedido;
    private String idEmpresa;
    private EmitenteDTO emitente;
    private DestinatarioDTO destinatario;
    private NFIdentificadorLocalDestinoOperacao destinoOperacao;
    private List<ItemNotaDTO> itens = new ArrayList<>();
    private String informacoesComplementares;
    private List<PagamentoDTO> pagamentos = new ArrayList<>();
    private String naturezaOperacao;
    private String serieNota;
    private TransportadoraDTO transportadora;

    public Boolean isCfopEntrada() {
        if (itens.isEmpty()) {
            log.error("Não foi encontrado nenhum item para capturar o tipo do CFOP");
            return null;
        }

        String primeiroCfop = itens.get(0).getCfop();
        return primeiroCfop.startsWith("1") || primeiroCfop.startsWith("2") || primeiroCfop.startsWith("3");
    }
}
