/* 
 *Author: Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

#include "gestion_memoria.h"

/* Crea la estructura utilizada para gestionar la memoria disponible. Inicialmente, sólo un nodo desde 0 a MAX */
void crear(T_Manejador* manejador) {

    *manejador = NULL;

}

/* Destruye la estructura utilizada (libera todos los nodos de la lista. El parámetro manejador debe terminar apuntando a NULL */
void destruir(T_Manejador* manejador) {

    T_Manejador ptr;

    while (*manejador != NULL) {

        ptr = *manejador;
        *manejador= (*manejador)->sig;
        free(ptr);

    }

}

/* Devuelve en dir la dirección de memoria simulada (unsigned) donde comienza el
 * trozo de memoria continua de tamaño tam solicitada.
 * Si la operación se pudo llevar a cabo, es decir, existe un trozo con capacidad suficiente,
 * devolvera TRUE (1) en ok; FALSE (0) en otro caso.
 */
void obtener(T_Manejador *manejador, unsigned tam, unsigned* dir, unsigned* ok) {

    T_Manejador ptr, aux;

    int c_mem;
    int first = -1;
    tam -= 1;

    if(*manejador == NULL) {
        *manejador = malloc(sizeof(struct T_Nodo));
        (*manejador)->inicio = 0;
        (*manejador)->fin = 999;
        (*manejador)->sig = NULL;
    }

    ptr = *manejador;
    *ok = 0;

    while (ptr != NULL && c_mem < tam) {

        c_mem = ptr->fin - ptr->inicio;

        aux = ptr;
        ptr = ptr->sig;

        first++;

    }

    if (c_mem >= tam) {
        // Devolvemos direccion de memoria y ok como TRUE
        *dir = aux->inicio;
        *ok = 1;

        if (c_mem == tam) {
            // Si la cantidad solicitada es igual al tamaño, se elimina el nodo
            ptr = *manejador;
            free(ptr);

            // Si es el primer nodo o está en otra posición
            if (first == 0)
                *manejador = (*manejador)->sig;
            else
                aux->sig = (*manejador)->sig;

        } else {
            // Si no es igual, es restada al nodo
            aux->fin -= tam + 1;
        }

    }

}

/* Muestra el estado actual de la memoria, bloques de memoria libre */
void mostrar (T_Manejador manejador) {

    int i = 0;

    if(manejador != NULL) {

        while(manejador != NULL) {

            printf("Nodo %d - Inicio: %d, Fin: %d\n", i, manejador->inicio, manejador->fin);

            manejador = manejador->sig;
            i++;

        }

    } else {

        printf("Error: Lista vacía\n");

    }

}

/* Devuelve el trozo de memoria continua de tamaño tam y que
 * comienza en dir.
 * Se puede suponer que se trata de un trozo obtenido previamente.
 */
void devolver(T_Manejador *manejador,unsigned tam,unsigned dir) {

    T_Manejador aux, ptr;

    ptr = *manejador;

    unsigned fin = dir + tam - 1;

    while(ptr != NULL && dir != 1000) {

        if(ptr->fin == dir-1) {
            ptr->fin = fin;
            dir = 1000;
        }

        if(fin == ptr->inicio-1) {
            ptr->inicio = dir;
            dir = 1000;
        }

        aux = ptr;
        ptr = ptr->sig;

    }

    if(dir != 1000) {

        T_Manejador  nuevonodo= malloc(sizeof(struct T_Nodo));
        nuevonodo->inicio = dir;
        nuevonodo->fin = fin;
        nuevonodo->sig = NULL;
        aux->sig = nuevonodo;

    }


}
