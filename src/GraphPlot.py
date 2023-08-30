import csv
import matplotlib.pyplot as plt

x = []
y = []

with open('xy.txt', 'r') as csvFile:
    csvReader = csv.reader(csvFile, delimiter=';')
    
    for row in csvReader:
        if len(row) == 2:
            x.append(float(row[0]))
            y.append(float(row[1]))
            

plt.scatter(x, y, color='blue', marker='o', label='Operações')
plt.title('Algortimo de Degeneração')
plt.xlabel('n')
plt.ylabel('operações')
plt.legend()
plt.show()
