# API_JAVA_MYSQL__03

## Status: Concluído

### Funcionamento:
<p>1 - Api apresenta camada de segurança com usuario e senha.
<p>2 - Você deve se logar:
<p>---> Envie uma requisiçao post para: GET http://localhost:8080/login</p>
<p>---> COnteudo: {"login":"ana.sousa@voll.me","password":"444555"}
<p>---> Resposta: {--um tokem JWT que devera ser enviado no cabeçario Bearer 
  junto com cada nova requisição, esse tokem eh valido por 2 horas --}
  
<p>1 - A api implementa CRUD completo para 4 tabelas em um banco de dados MySQL;</p>
<p>2 - As tabelas do banco de dados são: customers, product, sales, seller; </p>
<p>3 - Os endpoints de interação são: </p>
              <p> GET http://localhost:8080/---TABELAAQUI---</p>
              <p> GET http://localhost:8080/---TABELAAQUI---/"numero de um id"</p>
              <p> POST http://localhost:8080/---TABELAAQUI--- {Dados em json}</p>
              <p> PUT http://localhost:8080/---TABELAAQUI--- {Dados em json}</p>
              <p> DELETE http://localhost:8080/---TABELAAQUI---/"numero de um id"</p>
               

### Observação:
<p>1 - Para executá-lo você precisará usar uma IDE com um JDK mínimo de 17;
<p>2 - Este é um aplicativo Java Maven, usando o framework Spring Boot 3.0, não se esqueça de carregar as dependencias;</p>
<p>3 - O banco de dados utilizado é o MySql, o backup do bando esta na raiz desete projeto, procure o arquivo .sql e restaure o banco;</p>
