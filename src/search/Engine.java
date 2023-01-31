package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Engine {
    private final static Scanner scanner = new Scanner(System.in);

    private static ArrayList<String[]> source = new ArrayList<>();

    private static String word;

    public static void start() {
        enterData();
    }

    private static void enterData() {
        int numberOfPeople = 0;

        while (numberOfPeople == 0) {
            System.out.println("Enter the number of people:");
            try {
                numberOfPeople = Integer.parseInt(input());
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }

        System.out.println("Enter all people:");
        while (numberOfPeople != 0) {
            String[] person = input().split("\\s+");
            source.add(person);
            numberOfPeople--;
        }
        System.out.println();
        printMenu();
    }

    private static void printMenu() {
        String menuItem;
        while(true) {
            System.out.println(
                    "=== Menu ===\n" +
                    "1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            menuItem = input().trim();
            switch (menuItem) {
                case "1" : enterQuery();
                    break;
                case "2" : printAllPeople();
                    break;
                case "0" :
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    private static void enterQuery() {
        int numberOfSearch = 1;
        String data;
        /*while (numberOfSearch == 0) {
            System.out.println("Enter the number of search queries:");
            try {
                numberOfSearch = Integer.parseInt(input());
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }*/
        System.out.println();

        while (numberOfSearch != 0) {
            System.out.println("Enter a name or email to search all suitable people.");
            data = input();
            System.out.println();
            getSearch(data);
            numberOfSearch--;
        }
    }

    private static void getSearch(String data) {
        ArrayList<String> resultOfSearch = new ArrayList<>();
        for (String[] person : source) {
            for (String per : person) {
                if (per.toLowerCase().contains(data.toLowerCase())) {
                    resultOfSearch.add(Arrays.toString(person).replaceAll("[\\[\\],]", ""));
                    break;
                }
            }
        }
        if (resultOfSearch.size() ==0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("Found people:");
            resultOfSearch.forEach(System.out::println);
        }
        System.out.println();
    }

    private static void printAllPeople() {
        System.out.println("=== List of people ===");
        source.stream().forEach(x-> System.out.println(Arrays.toString(x).replaceAll("[\\[\\],]", "")));
    }

    private static String input(){
        return scanner.nextLine();
    }

    private static int getIndex(String[] source, String word) {
        for (int i = 0; i < source.length; i++) {
            if (Objects.equals(source[i], word)) {
                return i;
            }
        }
        return -1;
    }

    private static void print(int number){
        System.out.println(number > -1 ? number + 1 : "Not Found");
    }

}
