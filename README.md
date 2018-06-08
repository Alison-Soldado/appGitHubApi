# App GitHub Api 

Este projeto foi desenvolvido em Kotlin e consome dois endpoints da API do [GitHub](https://github.com). 
O primeiro é uma lista de repositórios e o segundo é uma lista de pulls requests.

Na tela inicial você terá que realizar a autenticação, então digite:

- __Email:__ exemplo@exemplo.com
- __Senha:__ 123

## Arquitetura 

Foi utilizado a arquitetura Model-View-Presenter (MVP), onde o model, pra quem não sabe, ele foi derivado do
Model-View-Controller (MVC). O MVP facilita a realização de teste devido separar bem as responsabilidades 
de cada camada.

## Comunicação com API

Foi utilizado a biblioteca chamada Retrofit

## Testes Locais

Foi utilizado a biblioteca chamada Mockito

## Testes Instrumentados

Foi utilizado a biblioteca chamada Espresso

## Testes Unitários

JVM e Emulador

## Relatório de cobertura de código

Foi utilizado o jacoco


