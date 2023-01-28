import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex4();
    }


    static void ex1(){
        //Вычислить n-ое треугольного число(сумма чисел от 1 до n)

        System.out.println("Введите n");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.print(sum);
    }

    static void ex2(){
        //Вычислить n! (произведение чисел от 1 до n)

        System.out.println("Введите n");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mult = 1;
        for (int i = 1; i <= n; i++) {
            mult = mult*i;
        }
        System.out.print(mult);
    }

       static void ex3() {
        //Вывести все простые числа от 1 до 1000
        // (простые числа - это числа которые делятся только на себя
        // и на единицу без остатка. Чтобы найти остаток от деления используйте оператор % ,
        // например 10%3 будет равно единице)

        for (int i = 1; i <= 1000; i++) {
            boolean prostoe = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0){
                    prostoe = false;
                }
            }
            if (prostoe){
                System.out.println(i);
            }
        }

    }

    static void ex4(){
        //Реализовать простой калькулятор
        // ("введите первое число"... "Введите второе число"...
        // "укажите операцию, которую надо выполнить с этими числами"... "ответ: ...")

        System.out.println("Введите a");
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        System.out.println("Введите b");
        int b = scanner.nextInt();
        System.out.println("Введите знак операции(+-*/)");

        String znak = scanner.next();


        if (Objects.equals(znak, "+")) {
            System.out.printf("%f%s%d = %f", a, znak, b, a+b);
        } else if (Objects.equals(znak, "-")) {
            System.out.printf("%f%s%d = %f", a, znak, b, a-b);
        } else if (Objects.equals(znak, "*")) {
            System.out.printf("%f%s%d = %f", a, znak, b, a*b);
        } else if (Objects.equals(znak, "/")) {
            System.out.printf("%f%s%d = %f", a, znak, b, a/b);
        } else {
            System.out.println("Неизвестная операция");
        }

    }

}
