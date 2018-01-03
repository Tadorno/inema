# inema

# Tecnologias
  1. Java 8
  2. NetBeans 8.1
  3. Wildfly 10.1
  4. driver postgresql 42.1.4.jre7
  5. PostgreSQL 10.1
  6. PgAdmin 4
  7. Hibernate 4.3.1.Final
  8. EJB 3.1
  9. JSF 2.2
  10. Primefaces 5.0
  
#### Estrutura
  loja-virtual <-Front da aplicação  
    src
      main
        java
          com
            tadorno
              loja
               virtual <- ManagedBeans de Formulários
                lazy <- Estrutura responsável pala paginação das listas
        resource
        webapp
          paginas <- páginas da aplicação  
          partial <- Template e Menu
          resources <- Css, imagens e javascripts
  
  -------------
  
  loja-virtual-server <- Back da aplicação
    src
      main
        java
          com
            tadorno
              loja
                virtual
                  server
                    api <- Interfaces EJB para utilização CDI 
                    aspecto <- Interfaces e abstrações de aspectos comuns aos objetos
                    bean <- Beans da aplicação
                    dao <- Repository dos dados
                    exception <- Classes de exceção
                    model <- Entidades dos dados
  
# Configuração Wildfly
  Para configurar o Wildfly é necessário instalar o driver postgreSQL (Ou qualquer outro banco a sua escolha) e configurar um datasource.
  Para isso basta seguir os passos do link utilizado como referência: 
  https://bgasparotto.com/pt/adicionar-datasource-ao-wildfly/
  
# Configuração Netbeans
  Adicione o server Wildfly na aba Ferramentas > Servidores

# Instalação do projeto loja-virtual
  Compile o projeto loja-virtual-server para baixar as dependências necessárias e gerar o .war
  Compile o projeto loja-virtual para baixar as dependências, associar o .war de loja-virtual-server e gerar um novo.war
  Execute O projeto loja-virtual
