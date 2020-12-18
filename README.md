# Mensagem Secreta

“Na criptografia, a criptografia é o processo de codificação das informações. Esse processo converte a representação original da informação, conhecida como texto simples, em uma forma alternativa conhecida como texto cifrado. Somente partes autorizadas podem decifrar um texto cifrado em texto simples e acessar as informações originais.”

Seu desafio é construir um programa capaz de ler o arquivo anexado e encontrar o valor da chave usada para criptografar o documento e encontrar a mensagem do arquivo.

Sobre o processo de criptografia:
Cada letra possui um valor inteiro associado a ela. A letra A está associada ao valor 0, B está associada a 1, C a 2, e assim por diante até a letra Z. Após a letra Z, alguns sinais de pontuação estão disponíveis, ocupando 5 posições. Por fim temos algumas letras com os acentos.

Ao criptografar o documento, o seguinte processo é aplicado:
Nós convertemos o caractere que queremos criptografar, colocando em seu lugar e a letra que está em sua posição + CHAVE. 
Se o valor obtido pela soma da posição e da CHAVE for maior que 44 (última posição), deve-se continuar no início do alfabeto. Além disso, todos os espaços em branco são substituídos por # durante o processo de criptografia, para simplificar o processo deste exercício.

O que deve ser feito:
A entrada do seu programa deve ser apenas o arquivo com a mensagem criptografada.
A saída, a mensagem resolvida, pode ser no console ou em outro arquivo texto.

Você pode usar qualquer, biblioteca e estrutura que conheça para ajudá-lo nesta tarefa. 
Documente seu código para que possamos entender suas ideias sobre como resolver o problema.

Este desafio foi desenvolvido com base em um treinamento da PUC.

Explore os códigos disponibilizados no projeto: 
https://github.com/Macelot/Exemplos

mensagem secreta:
ÔZÜZ.QÓÇK#CÕ,RI#!Ó,ÕÓAÜÕB#Z#,ÃZC!#ÔZÜZ#;!,ÜÀ?ÜZÜ#Z#?ÜZÇ!#Ç!,Ü!AZ
#,ÕÓAÀÓB!#Ç!BÇ#!ÇAB;ÕÇ#!#A!ÓÃZ#ÍBÀAÕ#ÇB,!ÇÇÕKK#
