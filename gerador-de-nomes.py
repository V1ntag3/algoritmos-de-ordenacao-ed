import random


lista_de_nomes = []
lista = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']
for i in range(500000):
    nome = ''
    for j in range(6):
        letra = random.choice(lista)
        nome = nome + letra
    
    lista_de_nomes.append(nome+'\n')


with open('arquivo500.000.txt','w') as f:
    f.writelines(lista_de_nomes)
        