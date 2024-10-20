# Análise de Dados do Campeonato Brasileiro

Este projeto realiza a análise dos dados de jogos do Campeonato Brasileiro entre 2003 e 2022, trazendo estatísticas como o time com mais vitórias, o jogador com mais gols e mais cartões, entre outras informações.

## Enunciado do Projeto

O projeto tem como objetivo realizar a leitura de arquivos CSV com os dados de jogos do Campeonato Brasileiro e trazer os seguintes resultados:

* O time que mais venceu jogos no ano de 2008
* O estado que teve menos jogos entre 2003 e 2022
* O jogador que mais fez gols
* O jogador que mais fez gols de pênaltis
* O jogador que mais fez gols contra
* O jogador que mais recebeu cartões amarelos
* O jogador que mais recebeu cartões vermelhos
* O placar da partida com mais gols

Os arquivos CSV utilizados no projeto podem ser encontrados no link a seguir:

* [Dados do Campeonato Brasileiro](https://github.com/vconceicao/ada_brasileirao_dataset/tree/master)

  Inclui:
    * campeonato-brasileiro-cartoes.csv
    * campeonato-brasileiro-estatisticas-full.csv
    * campeonato-brasileiro-full.csv
    * campeonato-brasileiro-gols.csv

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Biblioteca:** OpenCSV (5.7.1)
* **Build:** Maven

## Pré-requisitos

* JDK 17+
* Maven
* IDE (IntelliJ IDEA, Visual Studio Code, etc.)
* Git instalado para clonar o repositório

## Instalação

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/Br3nOT/Tecnicas_de_programacao_I_Projeto_final_-_Campeonato_brasileiro.git
   ```

2. **Importe o projeto:**

   Abra o projeto clonado em sua IDE de preferência.

3. **Instale as dependências:**
   ```bash
   mvn clean install
   ```

## Como Executar

Após a instalação, compile e execute o projeto usando o comando:

```bash
mvn compile exec:java
```

O projeto fará a leitura dos arquivos CSV localizados no diretório `src/main/resources/data/`.

## Arquivos CSV

Certifique-se de que os arquivos CSV estão localizados na pasta `src/main/resources/data/`. Caso contrário, ajuste o caminho diretamente no código, na classe `ReaderImpl`.

## Estrutura do Projeto

* **src/main/java:** Código fonte do projeto.
* **src/main/resources/data:** Diretório para os arquivos CSV.
* **pom.xml:** Arquivo de configuração do Maven.


## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo [LICENSE](./LICENSE) para mais detalhes.


---
