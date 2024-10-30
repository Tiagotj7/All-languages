import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num1, num2, num3, num4, resultado;

        System.out.print("Escolha o primeiro número: ");
        num1 = scanner.nextInt();

        System.out.print("Escolha o segundo número: ");
        num2 = scanner.nextInt();

        System.out.print("Escolha o terceiro número: ");
        num3 = scanner.nextInt();

        System.out.print("Escolha o quarto número: ");
        num4 = scanner.nextInt();

        resultado = num1 + num2 + num3 + num4;

        System.out.println("O Resultado é: " + resultado);

        scanner.close();
    }
}
