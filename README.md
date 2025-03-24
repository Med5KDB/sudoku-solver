# Sudoku Solver

Un programme Java qui résout des grilles de Sudoku en utilisant l'algorithme de backtracking.

## Description

Ce programme permet de résoudre des grilles de Sudoku de deux manières différentes :
- En lisant une grille depuis un fichier texte
- En saisissant manuellement la grille via la console

Le programme utilise l'algorithme de backtracking pour trouver la solution et affiche le résultat dans un format visuel agréable avec des caractères Unicode (box-drawing) pour les bordures.

## Prérequis

- Java JDK 8 ou supérieur
- Un terminal qui supporte les caractères Unicode (pour l'affichage des bordures)

## Installation

1. Clonez le dépôt :
```bash
git clone https://github.com/Med5KDB/sudoku-solver
```

2. Compilez les fichiers source avec la commande 
```bash
javac src/*.java
```
ou

```bash
javac Main.java
```

## Utilisation

### Via un fichier texte

1. Créez un fichier texte contenant votre grille de Sudoku :
- Utilisez le format 9x9
- Utilisez '0' pour les cases vides
- Pas d'espaces entre les chiffres
- Une ligne par rangée

Exemple de format (grille.txt) :

```
530070000
600195000
098000060
800060003
400803001
700020006
060000280
000419005
000080079
```

## Exemple

![Sudoku game solution example](https://github.com/user-attachments/assets/f2e4aaf9-e658-46e2-9c68-e54940729e0d)

## Exemple de sortie avec un fichier texte

![Sudoku game solution example with a text file](https://github.com/user-attachments/assets/28016ba8-bf53-47c7-93d7-99c9306be240)