package search;

import java.util.ArrayList;
import java.util.Scanner;

class Searcher {
    private SearchStrategy strategy;
    private String[] data;

    private final Scanner scanner = new Scanner(System.in);

    public void doTask(SearchStrategy strategy, ArrayList<String[]> source) {
        setStrategy(strategy);
        doSearch(source);
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Enter a name or email to search all suitable people.");
        data = scanner.nextLine().split("\\s+");
    }

    public void doSearch(ArrayList<String[]> source) {
        this.strategy.doSearch(source, data);
    }
}
