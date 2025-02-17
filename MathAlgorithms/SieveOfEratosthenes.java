package MathAlgorithms;

import java.util.Arrays;

public class SieveOfEratosthenes {
     /**
     * Finds and prints all prime numbers up to a given number n using the Sieve of Eratosthenes.
     * n the upper limit to find prime numbers.
     */
    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n + 1]; // Step 1
        Arrays.fill(isPrime, true);  // Assume all numbers are prime
        isPrime[0] = isPrime[1] = false; // 0 and 1 are not prime

        for (int i = 2; i * i <= n; i++) { // Step 5
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) { // Step 3 & 4
                    isPrime[j] = false;
                }
            }
        }

        // Print all prime numbers
        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int n = 50; // Example: Find primes up to 50
        sieve(n);
    }
}
