package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import data.DataProvider;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.*;

/**
 * @author Savanna Denega | savannad@br.ibm.com
 */
public class ServiceTestsApiTarefas{

    String id = "0";
    String nome = "";
    String descricao = "";
    String prioridade = "";
    String status = "";
    String dataComecoRealizacao = "";
    String dataEstimadaEntrega = "";
    String usuario = "";
    String material = "";
    String anexo = "";

    List<String> listIds;

    //testes positivos

    @Test(priority = 1)
    public void testarGetAllTarefas() {

        String uriBase = "http://localhost:8080/tarefas";

        RestAssured.baseURI = uriBase;
        RequestSpecification httpRequest = RestAssured.given().contentType(ContentType.JSON);
        Response response = httpRequest.get();
        httpRequest.then().statusCode(200);

        ResponseBody body = response.getBody();
        String bodyString =  body.asString();
        listIds = gerarListaIdsCadastrados(bodyString);

    }

    @Test(priority = 2, dataProviderClass = DataProvider.class, dataProvider = "informacoesTarefas")
    public void testarInsertTarefa(String nome, String descricao, String prioridade, String status, String dataComecoRealizacao,
                                   String dataEstimadaEntrega, String usuario, String material, String anexo) {

        String uriBase = "http://localhost:8080/tarefas/";

        this.id = DataProvider.gerarIdNaoCadastrado(listIds);
        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataComecoRealizacao = dataComecoRealizacao;
        this.dataEstimadaEntrega = dataEstimadaEntrega;
        this.usuario = usuario;
        this.material = material;
        this.anexo = anexo;

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

        given()
                .contentType(ContentType.JSON)
                .body(source)
                .when()
                .post(uriBase)
                .then()
                .statusCode(200);

    }

    @Test(priority = 3, dataProviderClass = DataProvider.class ,dataProvider = "informacoesTarefas")
    public void testarUpdateTarefa(String nome, String descricao, String prioridade, String status, String dataComecoRealizacao,
                                   String dataEstimadaEntrega, String usuario, String material, String anexo) {

        String uriBase = "http://localhost:8080/tarefas/";

        this.nome = nome;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
        this.dataComecoRealizacao = dataComecoRealizacao;
        this.dataEstimadaEntrega = dataEstimadaEntrega;
        this.usuario = usuario;
        this.material = material;
        this.anexo = anexo;

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

        given()
                .contentType(ContentType.JSON)
                .body(source)
                .when()
                .put(uriBase)
                .then()
                .statusCode(200);

    }
    @Test(priority = 4)
    public void testarGetTarefaById() {

        String uriBase = "http://localhost:8080/tarefas/{id}";

        given()
                .when()
                .pathParam("id", this.id)
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("id", equalTo(Integer.parseInt(this.id)))
                .body("nome", equalTo(this.nome))
                .body("descricao", equalTo(this.descricao))
                .body("prioridade", equalTo(this.prioridade))
                .body("status", equalTo(this.status))
                .body("dataComecoRealizacao", equalTo(this.dataComecoRealizacao))
                .body("dataEstimadaEntrega", equalTo(this.dataEstimadaEntrega))
                .body("usuario", equalTo(this.usuario))
                .body("material", equalTo(this.material))
                .body("anexo", equalTo(this.anexo));

    }

    @Test(priority = 5)
    public void testarDeleteTarefaById() {

        String uriBase = "http://localhost:8080/tarefas/{id}";

        given()
                .contentType(ContentType.JSON)
                .when()
                .pathParam("id", this.id)
                .delete(uriBase)
                .then()
                .statusCode(200);

    }

    //testes negativos

    @Test(priority = 6, expectedExceptions = AssertionError.class)
    public void testarGetTarefaByIdNegativo() {

        String uriBase = "http://localhost:8080/tarefas/{id}";

        given()
                .when()
                .pathParam("id", DataProvider.gerarIdNaoCadastrado(listIds))
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);

    }

    @Test(priority = 7, expectedExceptions = AssertionError.class)
    public void testarInsertTarefaNegativo() {

        String uriBase = "http://localhost:8080/tarefas/";

        this.id = DataProvider.gerarIdNaoCadastrado(listIds);

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

        given()
                .contentType(ContentType.JSON)
//                .body(source)
                .when()
                .post(uriBase)
                .then()
                .statusCode(200);

    }

    //

    private ArrayList<String> gerarListaIdsCadastrados(String bodyString){

        String splitBody[] = bodyString.split("\"id\":");

        listIds = new ArrayList<String>();
        String itemAtual[] = new String[1];

        for(int i = 1; i <splitBody.length; i++){
            itemAtual = splitBody[i].split(",");
            listIds.add(itemAtual[0]);
        }

        return (ArrayList<String>) listIds;
    }

}
