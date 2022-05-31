package challenge.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class TargetArraySum {
    public static void main(String[] args) {
        long target = 5;

        String setString = "2,3,4";
        String[] splitSet = setString.split(",");
        Long[] set = Arrays.stream(splitSet).map(Long::parseLong).toArray(Long[]::new);

        System.out.println((new TargetArraySum()).recurse(set, target).subset);
    }

    public SubsetState recurse(Long[] set, long target) {
        SubsetState state = new SubsetState(set, target, new ArrayList<>());
        long element = 0;
        for (int i = 0; i < set.length && set[i] < target; i++) {
            element = set[i];
        }
        return recurse(state, element);
    }

    public SubsetState recurse(SubsetState state, long element) {
        if (state.target == 0) {
            return state;
        } else if(state.target < 0){
            state.subset.remove(element);
            return state;
        }

        int el_index = 0;
        while (el_index < state.set.length && state.set[el_index] < state.target) {
            el_index++;
        }
        el_index--;
        while (el_index >= 0) {
            long new_el = state.set[el_index];
            state.addToSolution(new_el);
            state = recurse(state, new_el);
            if (state.target == 0) {
                return state;
            }
            el_index--;
        }
        return state;
    }
}

class SubsetState {
    Long[] set;
    long target;
    ArrayList<Long> subset;

    public SubsetState(Long[] set, long target, ArrayList<Long> subset) {
        this.set = set;
        this.target = target;
        this.subset = subset;
    }
    public void addToSolution(long element){
        this.subset.add(element);
    }
}