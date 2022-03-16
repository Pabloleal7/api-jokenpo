
# Jokempo

Desafio
Escreva um programa que analise o resultado de múltiplos jogadores em um jogo de 
jokenpo, você deve utilizar técnicas de programação de forma que a solução seja 
resiliente para possíveis mudanças como por exemplo adicionar e remover jogadas, 
e inserir e remover novos jogadores.
Requisitos
Os jogadores deverão informar as entradas através das jogadas e o sistema deverá 
indicar qual o jogador ganhador.
As entradas das jogadas deverão ser disponibilizadas através de APIs REST, além da 
aplicação disponibilizar APIs para realização do cadastro dos jogadores e das 
jogadas também ter a possibilidade de consulta-los e exclui-los.
Exemplos:
1. Entrada 1 – Jogador 1 e Jogada Pedra
2. Entrada 2 – Jogador 2 e Jogada Tesoura
3. Entrada 3 – Jogador 3 e Jogada Tesoura
4. Jogar 
5. Resultado Jogador 1 Vitória
#



![](https://d2r9epyceweg5n.cloudfront.net/stores/001/573/072/products/pedra-papel-tesoura-preto-png1-59215562c60b1fc79e16243219134709-1024-1024.png)
#
## Documentação da API

#### Retorna todos os players

```http
  GET /players
```


#### Retorna um player

```http
  GET /players/${id}
```
#### Deleta um player

```http
  DELETE /players/${id}
```


#### Cria um player

```http
  POST /players

  {
    "name":"nome do jogador"
  }
```

#### Retorna o id de todas as partidas existentes

```http
  GET /matchs
```


#### Retorna o id da partida caso ela exista

```http
  GET /matchs/${id}
```
#### Deleta uma partida

```http
  DELETE /players/${id}
```

#### Cria uma partida

```http
  POST /matchs 

  
```

#### Retorna todas as jogadas existentes

```http
  GET /inputs
```


#### Retorna a jogada escolhida por id

```http
  GET /inputs/${id}
```
#### Deleta uma jogada

```http
  DELETE /inputs/${id}
```


#### Cria uma jogada

```http
  POST /inputs 
  {
    "matchEntity": {
        "id": 1 /* id da partida criada */ 
    },
    "playerEntity":{
        "id": 3 /* id do player existente*/
    },
    "inputsEnum":2 /* itentificador da opção a ser jogada neste caso papel */
  }

  
```

#### Resultado de uma Partida

```http
  GET /play/${id}    // id da partida
```


#

# Como jogar

Para jogar você deve criar 3 usuários

```
POST /players

{
    "name":"Pablo"
}
```
```
POST /players

{
    "name":"Buiu"
}
```
```
POST /players

{
    "name":"Monica"
}
```

Após criar os 3 usuários cada um deles retorna um ID que e gerado sequencialmente, guarde esse ID para que possa utilizar nas próximas etapas.

Agora devemos criar uma partida, para criar é muito simples

```http
  POST /matchs 

  
```

Após utilizar o Método POST na rota acima e retornado o ID da partida, guarde esse ID também.

Agora criaremos as jogadas de cada jogador utilizando o ID dos jogadores e da Partida como no exemplo seguinte.

Jogada 1 - Player 1 Pablo - /* Spock */
```http
  POST /inputs 
{
    "matchEntity": {
        "id": 1
    },
    "playerEntity":{
        "id": 1 
    },
    "inputsEnum":0 
}

  
```

Jogada 2 - Player 2 Buiu -  /* Tesoura */
```http
  POST /inputs 
{
    "matchEntity": {
        "id": 1
    },
    "playerEntity":{
        "id": 2 
    },
    "inputsEnum":1 
}


```

Jogada 3 - Player 3 Monica - /* Pedra */
```http
  POST /inputs 
{
    "matchEntity": {
        "id": 1
    },
    "playerEntity":{
        "id": 3 
    },
    "inputsEnum":3 
}

```
Lembrado que cada partida permite somente 3 jogadas, e as 3 são necessárias para o resultado do jogo.

Para obter o resultado do jogo siga a rota abaixo com o ID da partida, no nosso caso do exemplo é 1
```http
  GET /play/1    // id da partida
```

```


Resultado
{
    "playerCombateList": [
        {
            "name": "Pablo",
            "input": "SPOCK",
            "points": 2
        },
        {
            "name": "Buiu",
            "input": "TESOURA",
            "points": 0
        },
        {
            "name": "Monica",
            "input": "PEDRA",
            "points": 1
        }
    ],
    "mensagem": "Pablo Ganhou"
}
```



### Probabilidades e resultado de cada jogada caso cada player escolha uma opção diferente e a quantidade de pontos
spock 1
tesura 1
papel 1


spcok 2
tesoura
pedra 1

spock 1
tesoura 1
lagarto 1


spock 1
papel 2
pedra

spock 
papel 1
lagarto 2

spock 1
pedra 1
lagarto 1

tesoura 1
papel 1
pedra 1

tesoura2
papel 
lagarto 1

tesoura 1
pedra2
lagarto

papel 1
pedra 1
lagarto 1

### Enum de cada opção a ser escolhida.
##### SPOCK = 0     Mata: Tesoura = 1  Pedra = 3
##### TESOURA = 1   Mata: Papel =2  Lagarto = 4
##### PAPEL = 2     Mata: Pedra =3  Spock = 0
##### PEDRA = 3     Mata: Lagarto=4 Tesoura = 1
##### LAGARTO = 4   Mata: Spock = 0 Papel = 2

### Mais
Qualquer duvida basta me procurar que ficarei muito feliz em ajudar.
