package test;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Day_2_TungHuynh {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Exercise 1: calculate factorial
        calcFactorials(scanner);

        //initial an Array
        int[] testArray = initialArray(scanner);

        //Exercise 2: calculate the average of an Integer Array
        calcAverageOfArray(testArray);

        //Exercise 3: find the biggest number in an Integer Array
        findMaxNumber(testArray);

        //Exercise 4: sort an Integer Array incrementally
        sortArray(testArray);

        //Exercise 5: check if it is a prime number
        checkPrimeNumber(scanner);

    }

    //Exercise 1
    public static void calcFactorials(@NotNull Scanner scanner) {

        System.out.println("Enter your number factorial: ");
        byte factorialNumber = scanner.nextByte();

        int MAX_INTEGER_VALUE = Integer.MAX_VALUE;
        int MIN_INTEGER_VALUE = Integer.MIN_VALUE;
        long finalResult = 1L;

        if (factorialNumber == 0) {
            System.out.println("Please enter a valid positive number");
        } else {

            for (int i = 1; i <= factorialNumber; i++) {
                finalResult = finalResult * i;
            }

        }

        boolean isResultAccepted = MIN_INTEGER_VALUE <= finalResult && finalResult <= MAX_INTEGER_VALUE;

        if (isResultAccepted && factorialNumber != 0) {
            System.out.printf("The result of %d factorial is %d \n", factorialNumber, finalResult);
        } else {
            System.out.println("Your value is exceed the integer Value !!!\n" +
                    "Max Integer value is " + MAX_INTEGER_VALUE +
                    "\nYour result is " + finalResult);
        }

        //      Second way to calculate the factorial result !!!
/*
        boolean isValid = factorialNumber > 0 && factorialNumber < 13;

        if(isValid) {
            for(int i = 1; i <= factorialNumber; i++) {
                finalResult = finalResult * i;
            }
            System.out.printf("The final result is %d \n", finalResult);
        } else {
            System.out.println("Your input number will exceed the integer max value !!! \n" +
                               "Please try another number");
        }
*/

    }

    //Exercise 2
    public static void calcAverageOfArray(int[] myArray) {

        float sumOfArray = 0;

        if (myArray != null) {
            for (int element : myArray) {
                sumOfArray += element;
            }

            float averageOfArray = (sumOfArray != 0) ? (sumOfArray / myArray.length) : 0;

            if (averageOfArray != 0) {
                System.out.printf("The average of the array is %.2f \n", averageOfArray);
            } else {
                System.out.println("The sum of this is array is equal to 0 \n" +
                        "Please enter a valid number");
            }
        } else {
            System.out.println("The array is empty !!!");
        }

    }

    //Exercise 3
    public static void findMaxNumber(int @NotNull [] myArray) {
        int maxValue = myArray[0];
        int count = 0;

        for (int element : myArray) {
            if (maxValue < element) {
                maxValue = element;
            } else if (maxValue == element) {
                count++;
            }
        }

        if (count > 1) {
            System.out.printf("There are %d biggest number in the array is %d \n", count, maxValue);
        } else {
            System.out.printf("The biggest number is %d \n", maxValue);
        }

    }

    //Exercise 4
    public static void sortArray(int[] myArray) {
        int firstIndex, lastUnsortedIndex;

        if (myArray != null) {

            for (lastUnsortedIndex = (myArray.length - 1); lastUnsortedIndex > 0; lastUnsortedIndex--) {

                for (firstIndex = 0; firstIndex < lastUnsortedIndex; firstIndex++) {
                    if (myArray[firstIndex] > myArray[firstIndex + 1]) {
                        swapTwoNumber(myArray, firstIndex, firstIndex + 1);
                    }
                }

            }
            System.out.print("The sorted array is: ");
            printArray(myArray);

        } else {
            System.out.println("This array is empty !!!");
        }

    }

    //Exercise 5
    public static void checkPrimeNumber(@NotNull Scanner scanner) {

        System.out.println("Enter your number: ");
        int inputNumber = scanner.nextInt();
        int[] divisibleNumberArray = new int[inputNumber];
        int count = 0;

        for (int run = 2; run < inputNumber; run++) {

            if (inputNumber % run == 0) {
                divisibleNumberArray[run - 2] = run;
                count++;
            }

        }

        if (count > 0) {
            System.out.printf("%d is not a prime number \n", inputNumber);
            System.out.printf("Numbers that are divisible by %d are \n", inputNumber);
            printArray(divisibleNumberArray);
        } else {
            System.out.printf("%d is a prime number \n", inputNumber);
        }

    }

    //Common
    public static int[] initialArray(Scanner scanner) {

        System.out.print("Enter your array length: ");
        int arrayLength = scanner.nextInt();
        int[] myArray = (arrayLength != 0) ? new int[arrayLength] : null;

        if (myArray != null) {
            System.out.print("Please enter value for the array: ");

            for (int i = 0; i <= (arrayLength - 1); i++) {
                myArray[i] = scanner.nextInt();
            }
        } else {
            System.out.println("The array is equal to NULL !!!");
        }

        return myArray;
    }

    public static void swapTwoNumber(int[] myArray, int firstIndex, int nextIndex) {

        if (myArray[firstIndex] == myArray[nextIndex]) {
            return;
        }

        int temp = myArray[firstIndex];
        myArray[firstIndex] = myArray[nextIndex];
        myArray[nextIndex] = temp;

    }

    public static void printArray(int[] myArray) {

        for (int element : myArray) {
            if (element != 0) {
                System.out.print(element + " ");
            }
        }

        System.out.println();

    }

}
