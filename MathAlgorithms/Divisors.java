package MathAlgorithms;

import java.util.Scanner;

public class Divisors {
    public static void findDivisors(int n) {
        System.out.println("Divisors of " + n + " are:");

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");  // First divisor
                if (i != n / i) {
                    System.out.print((n / i) + " ");  // Second divisor
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt(); // 36
        findDivisors(num);
        scanner.close();
    }
}
