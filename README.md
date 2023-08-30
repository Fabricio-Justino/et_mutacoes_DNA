# et_mutacoes_DNA
Trabalho de ALEST II


## Instrução de compilação para geração de gráficos

para compilar e gerar um gráfico, você deve estar na pasta 'et_mutacoes_DNA' ter 
a plibioteca matplotlib installado, caso não tenha use o comando abaixo

```cmd
    pip install matplotlib
```

### Pelo promt passo a passo
```cmd
    javac -d ./dist ./src/*java
    java -cp ./dist GrapthDots <número de observações>
    python ./src/GraphPlot.py
```

### Com makefile

```cmd
    make graph
```

ou

```cmd
    make graph MAX_X=<número de observações>
```

## Instrução de compilação para saber resultado final da degeneração

### Pelo promt passo a passo
```cmd
    javac -d ./dist ./src/*java
    java -cp ./dist Main <Cadeia>
```

`Cadeia` é a amostra exemplo DNADNAANDNDA, também é possivel gerar uma cadeia aleatória ao por 
um inteiro ao invés de uma String

### Com makefile
```cmd
    make run DNA=<cadeina>
```

`Cadeia` é a amostra exemplo DNADNAANDNDA, também é possivel gerar uma cadeia aleatória ao por 
um inteiro ao invés de uma String