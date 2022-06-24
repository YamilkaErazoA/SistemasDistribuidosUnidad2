//Yamilka Erazo

#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define MAX_THREADS 8
#define VECTOR_SIZE 100000000

pthread_t tid[10000000];
pthread_mutex_t mutex;

int private_count[100000][2];
long entrada;
long suma = 0;
void *hiloFactorial(void *arg){
long j;
long tam = (long)arg;

printf("El factorial de %ld = ",(long)tam);

long fact = 1;

    for(j = 1; j <= tam; j++){ 
        fact = fact * j;
    }
    
   printf("valor %ld\n",(long)fact);
   suma = suma + (long) fact;
   private_count[tam][0] = fact; 
   private_count[tam][1] = j;

   return NULL;
}

int main(int argc, char* argv[]){
    long i = 1;
    clock_t t1, t2;
    printf("=======================================================\n");
    printf("Ingrese la serie del factorial que desea calcular: ");
    scanf("%ld", &entrada);
    printf("=======================================================\n");
    
    int aux = entrada;
    t1 = clock();
    pthread_mutex_init(&mutex, NULL);
    for(; i<= aux;i++){
        pthread_create(&tid[i], NULL, &hiloFactorial, (void*)entrada);
        pthread_join(tid[i], NULL);
        pthread_mutex_lock(&mutex);
        entrada--;
        pthread_mutex_unlock(&mutex);
    }    
}