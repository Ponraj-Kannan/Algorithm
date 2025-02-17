package MathAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

    // Function to perform prime factorization
    public static List<Integer> primeFactors(int number) {
        List<Integer> factors = new ArrayList<>();

        // Divide by 2 until number is odd
        while (number % 2 == 0) {
            factors.add(2);
            number /= 2;
        }

        // Check for odd factors from 3 to sqrt(number)
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                factors.add(i);
                number /= i;
            }
        }

        // If number is still greater than 2, it must be prime
        if (number > 2) {
            factors.add(number);
        }

        return factors;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to find its prime factors: ");
        int number = scanner.nextInt();

        if (number <= 1) {
            System.out.println("Prime factorization is not applicable for numbers less than or equal to 1.");
        } else {
            List<Integer> factors = primeFactors(number);
            System.out.println("Prime factors of " + number + " are: " + factors);
        }

        scanner.close();
    }
}