package data;

import java.util.List;

public class DataProvider{

//    public static String gerarNovoMesData(String dataAtual){
//
//        String[] dataAtualArray = dataAtual.split("/");
//
//        String novoMes = "";
//        while(novoMes.equals(dataAtualArray[1]) || novoMes == ""){
//            novoMes = Integer.toString((int) (Math.random() * 13));
//        }
//
//        if(Integer.parseInt(novoMes) < 10){
//            novoMes = "0" + novoMes;
//        }
//
//        return  dataAtualArray[0] + "/" + novoMes + "/" + dataAtualArray[2];
//    }

    public static String gerarId(){
        return Integer.toString((int) (Math.random() * 100));
    }

    public static String gerarIdNaoCadastrado(List<String> listIds) {

        String novoId = "0";

        if(listIds.get(0) != null) {
            novoId = listIds.get(0);
        }

        while(listIds.contains(novoId)){
            novoId = DataProvider.gerarId();
        }

        return novoId;
    }

    @org.testng.annotations.DataProvider(name = "informacoesTarefas")
    public static Object[][] informacoesTarefas() {

        return new Object[][] {
                {"Gerar novo layout", "Gerar novo layout para janelas", "Media", "Fechado", "02/07/2017", "13/12/2018", "Maria Carolina", "Material Padrão", "Anexo 14" },
                {"Gerar novo layout", "Gerar novo layout para janelas", "Media", "Aberta", "21/08/2017", "13/12/2018", "Bruna Andressa", "Material 3", "Anexo 21" },
                {"Duplicar relatorios", "Duplicar relatorios de fornecedores", "Alta", "Aberta", "02/02/2017", "13/12/2018", "Cassia", "Material 3", "Anexo 5" },
                {"Gerar novo padrao de cores alfa", "Gerar novo padrao de cores alfa para casas", "Media", "Fechado", "02/02/2017", "13/12/2018", "Jaqueline", "Material 5", "Anexo 7" },
                {"Novo Projeto 2", "Desenvolver novo Projeto 1", "Media", "Fechado", "02/02/2017", "23/11/2018", " André", "Material 18", "Anexo 5" },
                {"Novo Projeto 3", "Desenvolver novo Projeto 2", "Alta", "Aberta", "02/02/2017", "23/11/2018", "Carolina", "Material 24", "Anexo 18" },
                {"Novo Projeto 4", "Desenvolver novo Projeto 3", "Media", "Fechado", "02/02/2017", "23/11/2018", "Maria Carolina", "Material 4", "Anexo 4" },
                {"Comprar cimento", "Comprar cimento pois está em falta", "Alta", "Fechado", "02/02/2017", "23/11/2018", "Pedro", "Material 7", "Anexo 13" },
                {"Compras mês setembro", "Realizar compras mês setembro", "Baixa", "Aberta", "02/02/2017", "23/11/2018", "Ariel", "Material 9", "Anexo 4" },
                {"Realizar inpeção incêndio", "Realizar inpeção incêndio mês de agosto", "Media", "Fechado", "02/02/2017", "23/11/2018", "Pablo", "Material 14", "Anexo 24" },
        };
    }

}
