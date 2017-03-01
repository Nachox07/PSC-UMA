/*
 * @author Nacho González-Garilleti <nachox07@users.noreply.github.com>
 */

#include <stdio.h>

/* 1.
 * implementar un procedimiento con un parámetro de
 * tipo puntero a entero que muestre el valor de la variable.
 * (acceso a la variable anónima)
 * */

void ej1(int *num) {
	printf("El valor de la variable es %d\n", *num);
}

/*
 * Implementar un procedimiento con dos parámetros de tipo puntero a entero.
 * Modificar su valor y mostrarlo por pantalla. (Uso de parámetros de E/S)
 * */

void ej2(int * num1, int * num2) {
	*num1 = 3;
	*num2 = 4;

	printf("Num1: %d; Num2: %d", *num1, *num2);
}

/*
 * Implementar un procedimiento que tenga como parámetro un puntero a una zona de memoria
 * de números enteros e introduzca valores leídos por teclado.
 * Definir el tamaño de la zona en el programa principal e invocar a este procedimiento.
 * (Uso de aritmética de punteros/uso arrays)
 * */

void ej3(int * nums) {

	int local = 0;

	for(int i = 0;i < 4;i++) {

		printf("Introduzca un numero para la posicion %d: ",i);
		scanf("%d", &local);
		*nums = local;
		nums += 1;

	}

}

/*
 * Realizar lo mismo definiendo en el programa principal un array.
 * (Uso de aritmética de punteros/uso arrays)
 * */

// Hecho en main

/*
 * Implementar un procedimiento con un parámetro de tipo puntero a una
 * zona de memoria de números enteros y mostrar su contenido.
 * (Uso de aritmética de punteros/uso arrays)
 * */

void ej5(int * nums) {

	for(int i = 0;i < 4;i++) {
		printf("%d", *nums);
		nums += 1;
	}

}

/*
 * Implementar un procedimiento con un parámetro de tipo
 * puntero a una zona de memoria de números enteros y modificar su contenido.
 * (Uso de aritmética de punteros/uso arrays)
 * */

void ej6(int * nums) {
	for(int i = 0;i < 4;i++) {
		*nums = i*2;
		nums++;
	}
}

/*
 * Definir un registro compuesto por dos registros.
 * El primero de ellos (Info1) formado por los campos nombre y apellidos y
 * el segundo (Info2) por los campos edad y altura. Definir dos procedimientos
 * que tengan como parámetro un puntero a Info1 y a Info2 respectivamente y
 * */

typedef struct {
	char nombre [10];
	char apellidos [20];
} Info1;

typedef struct {
	int edad;
	double altura;
} Info2;

typedef struct {
	Info1 i1;
	Info2 i2;
} persona;


int main(void) {

	int n1, n2;
	n1 = 4;
	n2 = 5;

	// Comprobación (Ejercicio 3 y 4)
	int ns [4] = {2,3,4,5};

	//ej3(&ns);
	// Fin (Ejercicio 3 y 4)

	ej6(&ns);
	ej5(&ns);

	return 0;
}
