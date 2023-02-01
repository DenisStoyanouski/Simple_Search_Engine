package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class StrategyNone implements SearchStrategy{
    @Override
    public void doSearch(ArrayList<String[]> source, String[] data) {
        ArrayList<String> resultOfSearch = new ArrayList<>();
        for (String[] person : source) {
            if (Arrays.stream(person).noneMatch(Arrays.asList(data)::contains)) {
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
