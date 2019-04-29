package br.com.brasilfiscal.nfe.client;

import br.com.brasilfiscal.nfe.client.messages.request.*;
import br.com.brasilfiscal.nfe.client.messages.response.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface NfeClientAPI {
    @RequestLine("POST /v1/nfe/venda")
    @Headers("Content-Type: application/json")
    ResponseEnviaNotaVendaMessage enviarNotaVenda
            (RequestEnviaNotaVendaMessage requestEnviaNotaVendaMessage);

    @RequestLine("POST /v1/nfe/devolucao")
    @Headers("Content-Type: application/json")
    ResponseEnviaNotaDevolucaoMessage enviarNotaDevolucao
            (RequestEnviaNotaDevolucaoMessage requestEnviaNotaDevolucaoMessage);


    @RequestLine("POST /v1/nfe/venda/xml")
    @Headers("Content-Type: application/json")
    ResponseVisualizarXmlNotaVendaMessage
    visualizarXmlVenda(RequestVisualizarXmlNotaVendaMessage requestVisualizarXmlNotaVendaMessage);

    @RequestLine("POST /v1/nfe/devolucao/xml")
    @Headers("Content-Type: application/json")
    ResponseVisualizarXmlNotaDevolucaoMessage
    visualizarXmlDevolucao(RequestVisualizarXmlNotaDevolucaoMessage requestVisualizarXmlNotaDevolucaoMessage);

    @RequestLine("GET /v1/nfe/{chave}")
    ResponseConsultaNotaMessage consultarNota(@Param("chave") String chave);

    @RequestLine("POST /v1/nfe/cancelamento")
    @Headers("Content-Type: application/json")
    ResponseCancelaNotaMessage cancelarNota
            (RequestCancelaNotaMessage requestCancelaNotaMessage);
}
