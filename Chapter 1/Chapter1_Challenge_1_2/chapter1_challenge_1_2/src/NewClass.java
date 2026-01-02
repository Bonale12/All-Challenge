/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
/*

//package LotteryAnalysis
        
//public static void main(string[] args)
//to do code application logic here

 public class LotteryAnalysis {
    public static void main(String[] args) {
        //sttep1:initialize the array with winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};
        
        String winningNumber = "";
        double highestAverage = 0;

        for (String number : winningNumbers) {
            // Remove dashes
            String continuousString = number.replace("-", "");
            // Convert to char array and then to integer array
            int[] digits = new int[continuousString.length()];

            for (int i = 0; i < continuousString.length(); i++) {
                digits[i] = Character.getNumericValue(continuousString.charAt(i));
            }

            // Calculate sum and average
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }
            double average = (double) sum / digits.length;

            // Print analysis for this ticket
            System.out.println("Analyzing: " + number);
            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);

            // Check for the highest average
            if (average > highestAverage) {
                highestAverage = average;
                winningNumber = number;
            }
        }

        // Announce the winning number with the highest average
        System.out.println("The winning number with the highest average is: " + winningNumber + " with an average of " + highestAverage);
    }
}
   

