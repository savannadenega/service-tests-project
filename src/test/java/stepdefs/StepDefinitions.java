package stepdefs;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitions {

    String id = "";
    String nome = "";
    String descricao = "";
    String prioridade = "";
    String status = "";
    String dataComecoRealizacao = "";
    String dataEstimadaEntrega = "";
    String usuario = "";
    String material = "";
    String anexo = "";

    RequestSpecification httpRequest;

    @Dado("^que eu quero adicionar uma nova tarefa com as informacoes seguintes$")
    public void que_eu_quero_adicionar_uma_nova_tarefa_com_as_informacoes_seguintes(DataTable arg1) throws Throwable {

        String id = arg1.raw().get(1).get(0);
        String nome = arg1.raw().get(1).get(1);
        String descricao = arg1.raw().get(1).get(2);
        String prioridade = arg1.raw().get(1).get(3);
        String status = arg1.raw().get(1).get(4);
        String dataComecoRealizacao = arg1.raw().get(1).get(5);
        String dataEstimadaEntrega = arg1.raw().get(1).get(6);
        String usuario = arg1.raw().get(1).get(7);
        String material = arg1.raw().get(1).get(8);
        String anexo = arg1.raw().get(1).get(9);

    }

    @Quando("^eu realizar a requisição no metodo na url (.*?)$")
    public void eu_realizar_a_requisição_no_metodo_na_url_http_localhost_tarefas(String arg1) throws Throwable {

        Map<String, String> source = new HashMap<String, String>();
        source.put("id", this.id);
        source.put("nome", this.nome);
        source.put("descricao", this.descricao);
        source.put("prioridade", this.prioridade);
        source.put("status", this.status);
        source.put("dataComecoRealizacao", this.dataComecoRealizacao);
        source.put("dataEstimadaEntrega", this.dataEstimadaEntrega);
        source.put("usuario", this.usuario);
        source.put("material", this.material);
        source.put("anexo", this.anexo);

        RestAssured.baseURI = arg1;
        httpRequest = RestAssured.given().contentType(ContentType.JSON).body(source);
        httpRequest.get();

    }

    @Então("^o código de status retornado deverá ser (\\d+)$")
    public void então_o_código_de_status_retornado_deverá_ser(int arg1) throws Throwable {

        httpRequest.then().statusCode(arg1);

    }

}
