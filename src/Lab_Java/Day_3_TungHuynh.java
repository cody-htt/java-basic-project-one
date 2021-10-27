package Lab_Java;

import java.util.Scanner;

public class Day_3_TungHuynh {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Exercise 01: Calculate the total minutes
        calcTimeInGivenString(scanner);

        //Exercise 02: Verify the given password from user
        verifyPassword(scanner);

        //Exercise 03: Print only number
        printOnlyNumberDigit(scanner);

        //Exercise 04: Print the url component
        getUrlComponent(scanner);

    }

    //Exercise 01
    public static void calcTimeInGivenString(Scanner scanner) {

        System.out.println("Please enter your sentence as the following format: \n" +
                "(x)hrs and (y) minutes");

        String inputTimeString = scanner.nextLine();

        char[] myCharArray = convertStringToCharArray(inputTimeString);

        int indexOfHrs = inputTimeString.indexOf("hrs");
        int theHour = Character.getNumericValue(myCharArray[indexOfHrs - 1]);

        int indexOfMinutes = inputTimeString.indexOf(" minutes");
        int theMinutes = Character.getNumericValue(myCharArray[indexOfMinutes - 1]);

        if (theHour >= 0 && theMinutes >= 0) {
            int theTotalTime = (theHour * 60) + theMinutes;
            System.out.printf("There are %d minutes in total" , theTotalTime);
        }

    }

    //Exercise 02
    public static void verifyPassword(Scanner scanner) {

        final String CORRECT_PASSWORD = "password123";

        int retryCount = 0;
        while (true) {

            System.out.print("Please enter your password: ");
            String inputPasswordFromUser = scanner.nextLine();
            if (inputPasswordFromUser.equals(CORRECT_PASSWORD)) {
                System.out.println("Your password is correct !!!");
                break;
            }

            if (retryCount == 2) {
                System.out.println("You have exceeded retry times !!! ");
                break;
            } else {
                System.out.println("Please try again!");
            }

            retryCount++;
        }

    }

    //Exercise 03
    public static void printOnlyNumberDigit(Scanner scanner) {

        System.out.print("Enter what ever you want: ");
        String inputString = scanner.nextLine();
        char[] nonFilterArray = convertStringToCharArray(inputString);

        for (char element : nonFilterArray) {
            if (Character.isDigit(element)) {
                System.out.print(element);
            }

        }

    }

    //Exercise 04
    public static void getUrlComponent(Scanner scanner) {

        System.out.print("Enter your URL: ");
        String inputString = scanner.nextLine();

        findDomainName(inputString);
        findWebProtocol(inputString);
        findDomainNameExtension(inputString);

    }

    private static void findDomainName(String inputString) {

        final String URL_SEPARATOR = "://";
        final String SINGLE_SEPARATOR = "/";
        String domainName;

        int indexOfSeparator = inputString.indexOf(URL_SEPARATOR);
        int indexOfSingleSeparator = inputString.indexOf(SINGLE_SEPARATOR , indexOfSeparator + 3);

        if (indexOfSingleSeparator > 0) {
            domainName = inputString.substring(indexOfSeparator + 3 , indexOfSingleSeparator);
        } else {
            domainName = inputString.substring(indexOfSeparator + 3);
        }

        System.out.println("The domain name is: " + domainName);

    }

    private static void findDomainNameExtension(String inputString) {

        final String EXT_MESSAGE = "The domain name extension";

        boolean isComExtension = inputString.contains("com");
        boolean isNetExtension = inputString.contains("net");
        boolean isOrgExtension = inputString.contains("org");

        if (isComExtension) {
            System.out.println(EXT_MESSAGE + " is .com");
        } else if (isNetExtension) {
            System.out.println(EXT_MESSAGE + " is .net");
        } else if (isOrgExtension) {
            System.out.println(EXT_MESSAGE + " is .org");
        }

    }

    private static void findWebProtocol(String inputString) {

        final String PROTOCOL_MESSAGE = "The web protocol is";

        boolean isHttpsProtocol = inputString.contains("https");
        boolean isHttpProtocol = inputString.contains("http");

        if (isHttpsProtocol) {
            System.out.println(PROTOCOL_MESSAGE + " HTTPS");
        } else if (isHttpProtocol) {
            System.out.println(PROTOCOL_MESSAGE + " HTTP");
        }

    }

    /* Common method */
    private static char[] convertStringToCharArray(String inputTimeString) {

        char[] myCharArray = new char[inputTimeString.length()];

        for (int i = 0; i < inputTimeString.length(); i++) {
            myCharArray[i] = inputTimeString.charAt(i);
        }

        return myCharArray;
    }

    enum UrlComponent {
        com,
        http,
        https,
        net,
        org

    }

}
