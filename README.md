# API Tarefas | Testes automatizados de serviços

Testes automatizados dos serviços disponibilizdos pela API de Tarefas, que foi construída por mim, e está disponível no GitHub no [link](https://github.com/savannadenega/abcontrol-spring-boot-microservices).

### Recursos utilizados

- Rest Assured
- Hamcrest
- TestNG
- Cucumber
- Surefire Plugin

------------------------------------------------------------------------------------------------------------------

### Como configurar o ambiente:

- Faça clone do projeto;
- Importe o projeto para sua IDE de preferência via pom (Maven);
- Faça a instalação na sua IDE do plugin 'Cucumber para Java'.

------------------------------------------------------------------------------------------------------------------

### Como executar a aplicação:

- O projeto pode ser executado de três maneiras:   
	- Realizando a execução da automação de todos os testes de serviço via TestNG, dos arquivos dentro do diretório `main`, onde a classe executável é a `ServiceTestsApiTarefas`,
	- Realizando a execução do teste de automação de serviço em BDD via Cucumber e TestNG, dos arquivos dentro do diretório `test`, onde a classe executável é a `TestRunner`;
	- Quando executado a partir do .jar, a execução é realizado de forma personalizada utilizando a ordem de classes especificada no arquivo testng.xml.   
	
- Os relatórios de testes são gerados e podem ser visualizados na pasta `\target\cucumber-reports\cucumber-pretty`, sendo que a execução do testes deve ser feita a partir da classe `TestRunner` (via Cucumber e TestNG).



