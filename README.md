# Sistemas-Distribuidos-1
Repositorio voltado para disciplina de SD1 

#I unidade

* 1.Utilizando JRMI, desenvolver um sistema mínimo e simples que possibilite a cópia de arquivos de uma dada pasta remota.
O objeto remoto deve ser consultado para fornecer  quais  arquivos  estão  disponíveis  em  cada  host,  devendo  o  cliente 
apresentar graficamente uma lista com a relação desses arquivos, conforme a figura abaixo.
O  cliente  deve  ter  a  opção  de  copiar  qualquer  um  arquivo  da  lista consolidada, sem a necessidade de se informar em que servidor está. O envio de arquivos  também  deve  estar disponível,  sendo  seu  local  de  destino  calculado 
aleatoriamente  pelo  sistema.  Todos  os  arquivos  deverão  ser  de  texto  simples,  ao estilo txt.
(3,0 pontos) – 05/01/2016

![alt tag](https://github.com/randler/Sistemas-Distribuidos-1/blob/master/imagens.jpeg)

#II unidade

* 2.Utilizando  JRMI, desenvolver  um  sistema que  permita  a resolução  de  expressões algébricas de forma distribuída. 
Uma expressão algébrica sempre deve ter a forma: 

* A op B, onde A é um dígito decimal
* Op uma operação algébrica (+, -, *, /)
* B um dígito  decimal

O sistema  deverá  solicitar  ao  usuário  uma  expressão  e fornecer o resultado,  calculando  de  forma  distribuída  
cada  mini-termo.  Para  a  expressão fornecida, o sistema deverá no cliente calcular a prioridade de resolução e solicitar 
aos objetos remotos a efetivação do cálculo. Deverão ser definidos quatro objetos remotos  (um para  cada  operação).
A  replicação das  operações é  necessária  em cada objeto, sendo a escolha de  qual será executada em cada nó   de responsabilidade do cliente. (3,0 pontos) – 19/01/2016
