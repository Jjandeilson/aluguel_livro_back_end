# Projeto para aluguel de livro
Esse projeto foi de desenvolvido como um desafio e foi construida uma implementação de uma API Rest para o aluguel de livros.

## Conteúdo do projeto

**Eco sistema spring utilizando os projetos:**
- Sporing boot.
- Spring data jpa e implementação da implementação(por padrão hibernate).
- Spring Web.

**Dependências adicionais**
-conexão de banco de dados MYSQL.
-flywaydb.
-Spring devtools.
-commons-lang3.

-versão do java utilizada foi o 12 e wen container Apache tomcat(padrão do spring).

##Como está estruturado o projeto?
-pacote para as classes de domain.
-pacote para API.

##O que contém no pacote de domain?
-pacote model contém todas as classes de domínio do projeto.
-pacote repository interfaces correspondentes a cada classe do model que é persistida no banco de dados.
-pacote service tem interfaces e classes com métodos que corresponde a cada classe do model e suas implementações r tratamento de exeções de domínio.

##O que contém o pacote API
-pacote de controller são mapeamentos de endpoints da API para cada recurso existe.
-pacote cors é o filtro de  requisiçção de domínio da web que é verificada se quem está fazendo a requisição para API tem permissão.
-pacote event contém uma classe que emite eventos quandod uma determinada ação acontece e um listener que vai capturar e disparar esse evento.
-pacote exception contém a classe que são tratada as execeções emitada pelo spring e exeções criada para uma determita exceção não capturada pelo spring.

##Execução do Projeto
###Quando é executado o projeto, no application.properties está configurado so seguinte modo:
-conexão com o banco de dados passando o endereço, usuário e senha do banco de dados. Está configurado na execução para verificar se o banco de daos é existente caso ele 
não exista é criado autômaticamente, o timezone foi utilizado o utc. 
**OBS(Para utilizar outro banco de dados só troca o drive de conexão)**
**OBS(está configurado exibições de select feito hibernate isso só de ser configurado em dev)

-Na pasta db/migrrations existe arquivos sql que são migrações de banco de dados que são a cada novo arquivo novo adicionado ao projeto, isso ocorre por que está configurado a 
dependência flywaydb no pom.xml essa ferramenta ajuda com esse trabalho.

-model tem as classes que são mapeadas para banco através de anotações do hibernate e os atributos das classes são contém anotações de definição referente a coluna do bando
validações do hibernate validator.
**OBS(nesse projeto está configurado o lombok que ajuda com códigos repetidos com get e set das classes, ele tem que ser configurado no pom.xml e instalado na ide)
Lombok:<https://projectlombok.org/>.

-repository interfaces que estende outra interface do spring a JpaRepository(passamos no gênerico o tipo de classe e o tipo da id), ela fornece métodos prontos para ser 
utilizado e captura de exceções lançado pelo spring.

-service interfaces referente a cada classe do model e classes que implementão essas interfaces e trata possiveis execeções lançada. Também dentro de pacote classe de validação
e execeções não capturada pelo spring.

-controller o mapeamento de classes referente a cada recurso da API e criação de endpoints correspondente a cada verbo HTTP, está configura o status a cada tipo de ação ocorrida
na requisição.

-cors classe de configuração para filtro de permissão de requisição domínio permitido **OBS(a forma que foi feita nesse projeto não é adequada, só foi feito para facilitar nesse desafio)

-event classe que emite um evento quando uma entidade é persistida no bando de dados ela retorna um cabeçalho com o endereço do recurrso criado, uma classes anotado com 
@EventListener para executa o evento e a interface ApplpicationEventListener para publicar esse evento na resposta da requisição

-exception classe que trata as exceções lançadas no sistema.

