package Lab_Java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your number: ");
        int inputNumber = scanner.nextInt();

        boolean isEvenNumber = (inputNumber % 2 == 0);

        if (isEvenNumber) {
            System.out.printf("The number %d is an even number!", inputNumber);
        }
        else {
            System.out.printf("The number %d is not an even number!", inputNumber);
        }

        System.out.println("Good to see you buddy !!!");
    }
}
