package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class StrategyAll implements SearchStrategy{

    @Override
    public void doSearch(ArrayList<String[]> source, String[] data) {
        Set<String> resultOfSearch = new HashSet<>();
        for (String[] person : source) {
            if (new HashSet<>(Arrays.asList(person)).containsAll(Arrays.asList(data))) {
                resultOfSearch.add(Arrays.toString(person).replaceAll("[\\[\\],]", ""));
            }
        }
        if (resultOfSearch.size() ==0) {
            System.out.println("No matching people found.");
        } else {
            System.out.printf("%d persons found:%n", resultOfSearch.size());
            resultOfSearch.forEach(System.out::println);
        }
        System.out.println();
    }
}
