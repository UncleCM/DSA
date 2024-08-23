package solutions.pack7;

import java.util.ArrayList;
import java.util.List;

public class Subsets_661277 {
    public static void printAllSubsets_Recurse(List<Integer> set){
        List<Integer> currentSubset = new ArrayList<>();
        printAllSubsets_Recurse(set, 0, currentSubset);   
    }
    private static void printAllSubsets_Recurse(List<Integer> set, int index, List<Integer> currentSubset) {
        if (index == set.size()) {
            System.out.println(currentSubset);
            return;
        }
        currentSubset.add(set.get(index));

        printAllSubsets_Recurse(set, index + 1, currentSubset);
        currentSubset.remove(currentSubset.size() - 1);
        printAllSubsets_Recurse(set, index + 1, currentSubset);

    }
    public static void printAllSubsets_DP(List<Integer> set) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>()); 

        for (int num : set) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> newSubset = new ArrayList<>(subsets.get(i));
                newSubset.add(num);
                subsets.add(newSubset);
            }
        }

        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}
