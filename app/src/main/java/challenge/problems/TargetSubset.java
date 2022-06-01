package challenge.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TargetSubset {

    public static void main() {
        long target = 24;

        String setString = "1,3,7,13";
        String[] splitSet = setString.split(",");
        Long[] set = Arrays.stream(splitSet).map(Long::parseLong).toArray(Long[]::new);

        ArrayList<Long> solution = (new TargetSubset()).recurse(set, target).subset;
        Collections.sort(solution);
        System.out.println("Base Set:: " + Arrays.toString(set));
        System.out.println("Target:: " + target);
        System.out.println("Solution:: " + solution);
    }

    public SubsetState recurse(Long[] set, long target) {
        SubsetState state = new SubsetState(set, target, new ArrayList<>());
        SubsetState solution = recurse(state, 0);
        if (solution.subset.stream().mapToLong(Long::longValue).sum() != target)
            return (new SubsetState(set, target, new ArrayList<>()));
        else return solution;
    }

    public SubsetState recurse(SubsetState state, long element) {
        if (state.target <= 0) {
            return state;
        }

        int el_index = 0;
        while (el_index < state.set.length - 1 && state.set[el_index] < state.target) {
            el_index++;
        }
        while (el_index >= 0) {
            long new_el = state.set[el_index];
            state.addToSolution(new_el);
            state = recurse(state, new_el);
            if (state.target == 0) {
                return state;
            } else {
                state.removeFromSolution(element);
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

    public void addToSolution(long element) {
        this.subset.add(element);
        this.target -= element;
    }

    public void removeFromSolution(long element) {
        this.subset.remove(element);
        this.target += element;
    }
}