#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX 100

void *inc_x(void *x_void_ptr){
	//Transformar el valor de referencia en el tipo de dato deseado (entero)
	int *x_ptr = (int *)x_void_ptr;//Cast a valor entero
	printf("Estoy en el método implementado\n");
	while (++(*x_ptr) <MAX);
	printf("x terminó el incremento\n");
	return NULL;	
}

int main(){
	int x = 0;
	int y = 0;
	printf("x: %d, y: %d\n", x, y); // imprimir los valores de x y y

	pthread_t inc_x_thread; //Instancia del Hilo
	pthread_create(&inc_x_thread, NULL, inc_x, &x);//Creación del Hilo
	pthread_join (inc_x_thread, NULL);//Ubicación del Join
	
	while (++y <MAX);
	printf("y terminó el incremento\n");
	printf("X: %d, Y: %d\n", x, y);
	return 0;
}
