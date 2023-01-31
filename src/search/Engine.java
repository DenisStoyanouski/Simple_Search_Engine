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
        enterQuery();
    }

    private static void enterQuery() {
        int numberOfSearch = 0;
        String data;
        while (numberOfSearch == 0) {
            System.out.println("Enter the number of search queries:");
            try {
                numberOfSearch = Integer.parseInt(input());
            } catch (NumberFormatException e) {
                System.out.println("Try again");
            }
        }

        while (numberOfSearch != 0) {
            System.out.println("Enter data to search people:");
            data = input();
            getSearch(data);
            numberOfSearch--;
        }
    }

    private static void getSearch(String data) {
        ArrayList<String> resultOfSearch = new ArrayList<>();
        for (String[] person : source) {
            for (String per : person) {
                if (data.equalsIgnoreCase(per)) {
                    resultOfSearch.add(Arrays.toString(person).replaceAll("[\\[\\],]", ""));
                }
            }
        }
        if (resultOfSearch.size() ==0) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("Found people:");
            resultOfSearch.forEach(System.out::println);
        }
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
