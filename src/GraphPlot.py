import csv
import matplotlib.pyplot as plt

x = []
y = []

filename = 'xy.txt'

print('-> abrindo arquivo ...')
with open(filename, 'r') as csvFile:
    print(f'-> Arquivo {filename} aberto com sucesso')
    csvReader = csv.reader(csvFile, delimiter=';')
    print(f'-> Lendo dados ...')
    for row in csvReader:
        if len(row) == 2:
            x.append(float(row[0]))
            y.append(float(row[1]))
            

print(f'-> Plotando ...')
plt.plot(x, y, color='blue', marker='o', label='Operações')
plt.title('Algortimo de Degeneração')
plt.xlabel('n')
plt.ylabel('operações')
plt.legend()
print(f'-> Procesos finalisados')
plt.show()