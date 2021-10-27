package Lab_Java;

import java.util.Scanner;

public class Ex01_TungHuynh {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first number: ");
        int firstNumber = scanner.nextInt();

        System.out.println("Enter your first number: ");
        int secondNumber = scanner.nextInt();

        calcAddition(firstNumber, secondNumber);
        calcSubtract(firstNumber, secondNumber);
        calcDivision(firstNumber, secondNumber);
        calcMultiplication(firstNumber, secondNumber);

    }

    // This method is used to add 2 numbers
    public static void calcAddition(int firstNum, int secondNum) {

        int result = firstNum + secondNum;
        System.out.printf("The sum of 2 numbers is %d", result);
        System.out.println();

    }

    // This method is used to subtract 2 numbers
    public static void calcSubtract(int firstNum, int secondNum) {

        int result = 0;
        boolean isGreaterThan = firstNum > secondNum;

        if (isGreaterThan) {
            result = firstNum - secondNum;
        } else {
            result = secondNum - firstNum;
        }
        System.out.printf("The difference of 2 numbers is %d", result);
        System.out.println();

    }

    // This method is used to divide 2 numbers
    public static void calcDivision(int firstNum, int secondNum) {

        boolean isNotZeroNumber = firstNum != 0 && secondNum != 0;
        boolean isGreaterThan = firstNum > secondNum;
        int result;

        if (isNotZeroNumber) {
            if (isGreaterThan) {
                result = firstNum / secondNum;
            } else {
                result = secondNum / firstNum;
            }
            System.out.printf("The quotient of 2 numbers is %d", result);
        }
        else {
            checkZeroNumber(firstNum);
        }

        System.out.println();

    }

    // This method is used to multiply 2 numbers
    public static void calcMultiplication(int firstNum, int secondNum) {

        int result = firstNum * secondNum;
        System.out.printf("The product of 2 numbers is %d", result);

    }

    // This method is used to check if a number is equal to 0
    private static void checkZeroNumber(int firstNum) {
        if(firstNum == 0) {
            System.out.print("Your first number is equal to 0");
        } else {
            System.out.print("Your second number is equal to 0");
        }
    }

}
