import csv
import matplotlib.pyplot as plt

x = []
y = []

filename = 'xy.txt'

color = None
label = None
yLabel = None

print('-> abrindo arquivo ...')
with open(filename, encoding='utf-8', mode='r') as csvFile:
    print(f'-> Arquivo {filename} aberto com sucesso')
    csvReader = csv.reader(csvFile, delimiter=';')
    
    print(f'-> Lendo dados ...')
    for row in csvReader:
        if len(row) == 2:
            x.append(float(row[0]))
            y.append(float(row[1]))
        elif len(row) == 3:
            color  = row[0]
            yLabel = row[1]
            label  = row[2] 
            
            

print(f'-> Plotando ...')
plt.scatter(x, y, color=color, marker='o', label=label)
plt.title('Algortimo de Degeneração')
plt.xlabel('n')
plt.ylabel(yLabel)
plt.legend()
print(f'-> Procesos finalisados')
plt.show()