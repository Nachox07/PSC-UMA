/*
 *Author: Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

#include <stdlib.h>
#include "arbolbb.h"

// Crea la estructura utilizada para gestionar el árbol.
void Crear(T_Arbol* arbol) {
    *arbol = NULL;
}

// Destruye la estructura utilizada y libera la memoria.
void Destruir(T_Arbol* arbol) {

    T_Arbol ptr;

    while (*arbol != NULL) {

        ptr = *arbol;

        if((*arbol)->der != NULL)
            Destruir((*arbol)->der);

        if((*arbol)->izq != NULL)
            Destruir((*arbol)->izq);

        free(ptr);

    }

}

// Inserta num en el árbol. Si ya está insertado, no hace nada
void Insertar(T_Arbol* arbol,unsigned num) {

    if(*arbol == NULL) {

        *arbol = malloc(sizeof(struct T_Nodo));
        (*arbol)->dato = num;
        (*arbol)->der = NULL;
        (*arbol)->izq = NULL;

    } else {

        T_Arbol ptr = *arbol;

        T_Arbol nuevonodo = malloc(sizeof(struct T_Nodo));
        nuevonodo->dato = num;
        nuevonodo->der = NULL;
        nuevonodo->izq = NULL;

        if(ptr->izq == NULL) {
            ptr->izq = nuevonodo;
        } else if(ptr->der == NULL) {
            ptr->der = nuevonodo;
        } else {

            if(ptr->izq->dato < num)
                Insertar(ptr->izq, num);
            else
                Insertar(ptr->der, num);

        }


    }

}

// Muestra el contenido del árbol en InOrden
void Mostrar(T_Arbol arbol) {



}

// Guarda en disco el contenido del fichero
void Salvar(T_Arbol arbol, FILE* fichero);

