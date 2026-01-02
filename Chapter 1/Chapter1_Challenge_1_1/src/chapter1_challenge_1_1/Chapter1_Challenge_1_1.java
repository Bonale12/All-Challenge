/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter1_challenge_1_1;

    import java.util.Scanner;

public class Chapter1_Challenge_1_1 {
    public static void main(String[] args) {
        // Step 1: Take input
        try (Scanner input = new Scanner(System.in)) {
            // Step 1: Take input
            System.out.print("Enter a positive integer: ");
            int num = input.nextInt();
            
            // Step 2: Find number of digits
            int digits = (int) Math.log10(num) + 1;
            
            // Step 3: Extract first digit
            int firstDigit = (int) (num / Math.pow(10, digits - 1));
            
            // Step 4: Extract last digit
            int lastDigit = num % 10;
            
            // Step 5: Extract second digit (from left)
            int secondDigit = (int) (num / Math.pow(10, digits - 2)) % 10;
            
            // Step 6: Extract second-last digit (from right)
            int secondLastDigit = (num / 10) % 10;
            
            // Step 7: Calculate product and sum
            int product = firstDigit * lastDigit;
            int sum = secondDigit + secondLastDigit;
            
            // Step 8: Create final code by concatenating product and sum
            String finalCode = Integer.toString(product) + Integer.toString(sum);
            
            // Step 9: Display result
            System.out.println("The decrypted code is: " + finalCode);
        }
    }
}


    