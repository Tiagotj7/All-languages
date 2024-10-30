#include <stdio.h>

int main() {


int num1, num2, resultado;


printf("Escolha o primeiro numero:");
scanf("%d", &num1);


printf("Escolha o segundo numero: ");
scanf("%d", &num2);


resultado = num1 + num2;


printf("O Resultado é %d + %d = %d\n", num1, num2, resultado);


return 0;


}