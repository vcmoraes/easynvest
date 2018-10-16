![Easynvest](https://otesourodireto.com/wp-content/uploads/2017/03/Easynvest-tesouro-direto-confiavel-seguro-boa.png)

# Frameworks

* Kotlin
* Mockito
* Espresso
* LiveData & ViewModel
* Data Binding
* Retrofit 2
* ConstraintLayout

# Entendendo o Projeto

Esse projeto utiliza o conceito MVP (Model View Presenter) com **UseCases**, ou seja, temos a camada da **View** que se comunica com o **Presenter** no qual se comunica com os **UseCases** e os mesmo se comunicam com os Serviços(**core**).

![Scheme](images/print1.png)

**APP**

* Tela - **Ui** responsável por mostrar informações ao usuário, como **Activity, Fragment, Dialog e etc**. 

![Scheme](images/print2.png)

* Contract - **Interface** responsável por garantir o **contrato entre o Presenter e a View**.

![Scheme](images/print3.png)

* Presenter - responsável por fazer a comunicação entre a **View** e os **UseCase**, **(NO PRESENTER NÃO VAI REGRA DE NEGÓCIO, POIS SE NÃO O USECASE FICA SEM EMPREGO)**

![Scheme](images/print4.png)

* UseCase - responsável por fazer a comunicação entre **Presenter** e o Serviço(**core**), sendo aqui onde fica as regras de negócios e conversão dos objetos entre **App e Core** utilizando os **Mapper**, **(NADA DE FAZER CONVERSÃO FORA DOS MAPPERS, POIS ELES PRECISAM DESSE EMPREGO)**

![Scheme](images/print5.png)

* Model - responsável por representar os dados de um Objeto para as **View**

![Scheme](images/print6.png)

* Mapper - responsável por converter o **ModelResponse do Core** em **Model do App**

![Scheme](images/print7.png)

**CORE**

* ModelRequest - Model que representa o conjunto de dados para uma requisição

* ModelResponse - Model que representa a resposta de uma requisição

![Scheme](images/print9.png)

* API - Classe que controla as chamadas 

![Scheme](images/print10.png)
