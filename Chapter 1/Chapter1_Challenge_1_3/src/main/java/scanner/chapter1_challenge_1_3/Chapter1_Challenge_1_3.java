/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package scanner.chapter1_challenge_1_3;

/**
 *
 * @author du
 */
//public class Chapter1_Challenge_1_3 {
import java.util.Random;
import java.util.Scanner;

public class Chapter1_Challenge_1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int health = 100;
        final int totalRooms = 5;

        System.out.println("Welcome to the Dungeon Game!");
        System.out.println("Starting health: " + health);
        System.out.println();

        // Step 2: Simulate 5 rooms
        for (int room = 1; room <= totalRooms; room++) {
            System.out.println("Entering room " + room + "...");
            int event = rand.nextInt(3) + 1;  // 1 to 3

            // Step 3 & 5: Handle event with switch
            switch (event) {
                case 1: // Trap
                    System.out.println("A trap sprung!");
                    health -= 20;
                    System.out.println("Health is now " + health + ".");
                    break;

                case 2: // Healing potion
                    System.out.println("You found a healing potion!");
                    health += 15;
                    if (health > 100) {
                        System.out.println("Health exceeded 100 -> capped to 100.");
                        health = 100;
                    }
                    System.out.println("Health is now " + health + ".");
                    break;

                case 3: // Monster encounter
                    System.out.println("A monster appears! Guess a number (1-5) to defeat it!");
                    int monsterNumber = rand.nextInt(5) + 1; // 1 to 5
                    int guess;

                    // Step 3: Use do-while loop for guessing
                    do {
                        System.out.print("Your guess: ");
                        guess = scanner.nextInt();
                        if (guess != monsterNumber) {
                            System.out.println("Wrong! Try again.");
                        }
                    } while (guess != monsterNumber);

                    System.out.println("You defeated the monster!");
                    break;

                default:
                    System.out.println("Nothing happens...");
                    break;
            }

            // Step 6: Check if player is dead
            if (health <= 0) {
                System.out.println("Your health has dropped to 0.");
                System.out.println("You have been defeated in room " + room + ".");
                break;
            }

            System.out.println(); // Spacing between rooms
        }

        // Step 7: Victory or defeat
        if (health > 0) {
            System.out.println("You cleared the dungeon! Victorious with " + health + " health!");
        }

        scanner.close();
    }
}
