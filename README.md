# O DNA D/N/A
Depois de analisar cuidadosamente o disco voador que caiu no meio do parque
da Redenção, os cientistas chegaram a algumas conclusões sobre os seres que o
ocupavam (e que fugiram em uma cápsula de resgate).

Os cientistas descobriram que o DNA dos alienígenas é feito 
com 3 bases em vez das 4 bases do DNA terrestre. Ironicamente eles batizaram
as 3 bases de D, N e A. Eles também descobriram que o DNA alienígena sofre mutações
que o deterioram com o tempo: duas bases diferentes que estão uma ao lado da outra
podem se fundir produzindo a terceira base recriando uma cadeia de DNA um pouco menor.
Isto acontece de uma forma muito organizada:

* Em uma cadeia de DNA a fusão de bases acontece sempre na dupla de bases diferentes mais à esquerda;
* A nova base criada com a fusão vai ser agregada ao final da cadeia de DNA.

Por exemplo, a pequena cadeia *DNA* sofre uma deterioração em *DN* e acaba gerando *AA*.
Já uma cadeia maior como *DNANDANDANDANADNDDDAN* acaba virando simplesmente *N*.

Os cientistas agora perguntam:
'dada uma cadeia de DNA, qual o tamanho e qual cadeia podem
ser obtidos depois de todas as mutações possíveis?'
Você deve escrever um algoritmo capaz de ler as cadeias que os cientistas 
colocaram em vários arquivos de teste e depois informe o tamanho da menor cadeia que pode ser obtida
em cada caso.

Ao final você deve apresentar um relatório desrevendo:

* Qual o problema sendo resolvido;
* Como o problema foi modelado;
* Como é o proesso de solução, apresentando exemplos e algoritmos;
* Os resultados dos casos de teste;
* Conlusões.

## Mutações no DNA e Análise de Degradação

Este documento fornece instruções e diretrizes para o
projeto "Mutação no DNA e Análise de Degradação"
desenvolvido como parte do curso ALEST II.

## Instruções de Compilação para Geração de Gráficos

Para compilar e gerar gráficos para este projeto,
siga estes passos:

1. Navegue até o diretório 'et_mutacoes_DNA'.
2. Certifique-se de que a biblioteca `matplotlib`
   esteja instalada. Se não estiver instalada,
   use o seguinte comando para instalá-la:

```bash
pip install matplotlib
```

3. A compilação e geração de gráficos podem ser
   feitas através do prompt de comando seguindo
   estas etapas:

```bash
javac -d ./dist ./src/*.java
java -cp ./dist GraphDots <número de observações>
python ./src/GraphPlot.py
```

4. Alternativamente, você pode usar o Makefile
   fornecido:

```bash
make graph
```

ou

```bash
make graph MAX_X=<número de observações>  [GRAPH_TIME=<ON/OFF>]
```

argumentos entre conchetes são opcionais.

## Instruções de Compilação para Obter Resultados
Para compilar e obter os resultados finais da
análise de degradação, siga estes passos:

1. Navegue até o diretório 'et_mutacoes_DNA'.
2. A compilação e análise de resultados podem ser
   feitas através do prompt de comando seguindo
   estas etapas:

```bash
javac -d ./dist ./src/*.java
java -cp ./dist Main <Sequência>
```

Substitua `Sequência` por uma sequência de exemplo,
como 'DNADNAANDNDA'. Também é possível gerar uma
sequência aleatória fornecendo um número inteiro em
vez de uma string.

3. Alternativamente, você pode usar o Makefile
   fornecido:

```bash
make run DNA=<sequência>
```

Substitua `Sequência` por uma sequência de exemplo
ou um número inteiro para gerar uma sequência
aleatória.

## Instruções de Compilação Através de arquivo
Para compilar atravéz do arquivo e obter os resultados finais da
análise de degradação, siga estes passos:

1. Navegue até o diretório 'et_mutacoes_DNA'.
2. A compilação e análise de resultados podem ser
   feitas através do prompt de comando seguindo
   estas etapas:

```bash
javac -d ./dist ./src/*.java
java -cp ./dist FileReader <local_do_arquivo>
```

3. Alternativamente, você pode usar o Makefile
   fornecido:

```bash
make run_file FILE_PATH=<local_do_arquivo>
```

Substitua `local_do_arquivo` por um local absoluto ou relativo à pasta
'et_mutacoes_DNA', também pode ser substituído por *sample* onde ira gerar
um arquivo de exemplo chamado *sample_xy.txt* 

### AVISO
O arqivo deve obedecer a sequinte regra: *Uma única sequência por linha*, como 
por exemplo:

```txt
DNADNA
AAAADA
DNAAND
NNNNNA
```
