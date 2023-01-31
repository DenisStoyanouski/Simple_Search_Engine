package search;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Engine {
    private final static Scanner scanner = new Scanner(System.in);

    private static String[] source;

    private static String word;

    public static void start() {
        source = input().trim().split("\\s+");
        word = input().trim();
        print(getIndex(source, word));
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
        System.out.println(number > -1 ? number : "Not Found");
    }

}
