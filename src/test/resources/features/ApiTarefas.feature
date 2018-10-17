# language: pt
@TesteApiTarefas
Funcionalidade: Testar os metodos disponibilizados pela API Tarefas
  Como um desenvolver e usuario dos servicos disponibilizados pela API
  Quero testar os servicos disponibilizados
  Para consumir os servicos que estao funcionando no meu software em desenvolvimento

  Cenário: Teste método insertTarefa

    Dado que eu quero adicionar uma nova tarefa com as informacoes seguintes
      |id | nome              | descricao                      | prioridade | status  | dataComecoRealizacao | dataEstimadaEntrega | usuario       | material        | anexo    |
      |20 | Gerar novo layout | Gerar novo layout para janelas | Media      | Fechado | 02/07/2017           | 13/12/2018          | Maria Carolina| Material Padrão | Anexo 14 |

    Quando eu realizar a requisição no metodo na url http://localhost:8080/tarefas/
    Então o código de status retornado deverá ser 200