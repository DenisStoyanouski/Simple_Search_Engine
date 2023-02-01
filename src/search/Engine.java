package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Engine {
    private final static Scanner scanner = new Scanner(System.in);

    private static ArrayList<String[]> source = new ArrayList<>();

    private static String word;

    public static void start(String fileName) {
        loadData(fileName);
    }

    private static void loadData(String fileName) {
        Path path = Paths.get(fileName);
        File file = new File(path.toUri());
        try (Scanner scan = new Scanner(file)) {
            while(scan.hasNextLine()) {
                source.add(scan.nextLine().trim().split("\\s+"));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
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
                case "1" : getSearch();
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

    private static void getSearch() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        String matchingStrategy = input();
        if (matchingStrategy.equals("ALL")) {
            Searcher searcher = new Searcher();
            searcher.doTask(new StrategyAll(), source);
        }
        if (matchingStrategy.equals("ANY")) {
            Searcher searcher = new Searcher();
            searcher.doTask(new StrategyAny(), source);
        }
        if (matchingStrategy.equals("NONE")) {
            Searcher searcher = new Searcher();
            searcher.doTask(new StrategyNone(), source);
        }


    }

    private static void printAllPeople() {
        System.out.println("=== List of people ===");
        source.stream().forEach(x-> System.out.println(Arrays.toString(x).replaceAll("[\\[\\],]", "")));
    }

    private static String input(){
        return scanner.nextLine();
    }

}
