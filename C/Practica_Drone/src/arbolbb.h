/* 
 *Author: Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

#ifndef PRACTICA_DRONE_ALBOLBB_H_H
#define PRACTICA_DRONE_ALBOLBB_H_H

#include <stdio.h>

typedef struct T_Nodo* T_Arbol;

struct T_Nodo {
    unsigned dato;
    T_Arbol izq, der;
};

// Crea la estructura utilizada para gestionar el árbol.
void Crear(T_Arbol* arbol);

// Destruye la estructura utilizada y libera la memoria.
void Destruir(T_Arbol* arbol);

// Inserta num en el árbol. Si ya está insertado, no hace nada
void Insertar(T_Arbol* arbol,unsigned num);

// Muestra el contenido del árbol en InOrden
void Mostrar(T_Arbol arbol);

// Guarda en disco el contenido del fichero
void Salvar(T_Arbol arbol, FILE* fichero);

#endif //PRACTICA_DRONE_ALBOLBB_H_H
