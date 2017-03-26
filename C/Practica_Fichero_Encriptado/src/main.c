/* 
 *Author: Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

const int delta = 0x9e3779b9;

void decrypt(unsigned int * v, unsigned int * k);

int main() {

    unsigned int v[2], k[4] = {128, 129, 130, 131};
    int n_bloques, tam;

    FILE *f_encriptado, *f_desencriptado;

    unsigned int *ptr2, *ptr2_ref;

    f_encriptado = fopen("imgno8.enc","rb");
    f_desencriptado = fopen("imagen2.png","wb");

    if(f_encriptado == NULL || f_desencriptado == NULL) {
        printf("Error: No se pudo abrir el fichero\n");
    }

    fread(v, 1, sizeof(int), f_encriptado);
    tam = * ((int *) v);
    n_bloques = tam/8;

    // Reservamos memoria para el puntero al contenido y guardamos su referencia inicial
    ptr2 = malloc(sizeof(v) * n_bloques);
    ptr2_ref = ptr2;

    for(int i = 0;i < n_bloques;i++) {

        fread(v, 1, 8, f_encriptado);

        decrypt(v, k);

        // Copiamos contenido en memoria de v a ptr2
        memcpy(ptr2, v, 8);

        // Incrementamos ptr2 para seguir rellenando con contenido desencriptado
        ptr2 += 2;

    }

    // Volcamos contenido desencriptado del puntero
    fwrite(ptr2_ref, 8, n_bloques, f_desencriptado);

    if (tam % 8 != 0) {
        memcpy(ptr2, v, 8);
        decrypt(v,k);
        fwrite(ptr2_ref,8,tam % 8,f_desencriptado);
    }

    fclose(f_encriptado);
    fclose(f_desencriptado);

    // Liberamos memoria
    free(ptr2_ref);

    return 0;

}

void decrypt(unsigned int * v, unsigned int * k) {

    int sum = 0xC6EF3720;

    for(int i = 0;i < 32;i++) {

        v[1] -= ((v[0] << 4) + k[2]) ^ (v[0] + sum) ^ ((v[0] >> 5) + k[3]);

        v[0] -= ((v[1] << 4) + k[0]) ^ (v[1] + sum) ^ ((v[1] >> 5) + k[1]);

        sum -= delta;

    }

}
