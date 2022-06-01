package challenge.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TargetSubset {
    public static void main() {
        Scanner scanner = new Scanner(System.in);

        /* problem variables */
        System.out.print("Target:: ");
        long target = Long.parseLong(scanner.next());
        System.out.print("\n");
        System.out.print("Set:: ");
        String setString = scanner.next();
        System.out.print("\n");

        Long[] set = parseSet(setString);

        /* run recursive algorithm */
        SubsetState solution = (new TargetSubset()).recurse(set, target);

        /* print solution */
        Collections.sort(solution.subset);
        System.out.println("Base Set:: " + Arrays.toString(set));
        System.out.println("Target:: " + target);
        System.out.println("Solution:: " + solution);
    }

    /* parse input string into array of longs */
    public static Long[] parseSet(String setString) {
        return Arrays.stream(setString.split(",")).map(Long::parseLong).toArray(Long[]::new);
    }

    /* wrapper for recursive algorithm */
    public SubsetState recurse(Long[] set, long target) {
        SubsetState state = new SubsetState(set, target, new ArrayList<>());
        SubsetState solution = recurse(state, 0);
        /* Return empty set if a solution doesn't exist, otherwise return first solution found */
        if (solution.subset.stream().mapToLong(Long::longValue).sum() != target)
            return (new SubsetState(set, target, new ArrayList<>()));
        else
            return solution;
    }

    public SubsetState recurse(SubsetState state, long element) {
        /* when target = 0, the current subset is a solution */
        if (state.target <= 0) {
            return state;
        }

        /* find the largest element less than the target in the main set */
        int el_index = 0;
        while (el_index < state.set.length - 1 && state.set[el_index] < state.target) {
            el_index++;
        }

        /* recursively test each element in the array, decreasing from the largest element < target */
        while (el_index >= 0) {
            long new_el = state.set[el_index];
            state.addToSolution(new_el);
            state = recurse(state, new_el);
            /* terminate upon finding a solution, otherwise remove the tested value and continue */
            if (state.target == 0) {
                return state;
            } else {
                state.removeFromSolution(element);
            }
            el_index--;
        }
        /* this is reached when a solution does not exist */
        return state;
    }
}

/* object used to keep track of various algorithm values */
class SubsetState {
    /* main set that is being chosen from */
    Long[] set;
    /* target, changes as algorithm progresses */
    long target;
    /* solution set, as a list */
    ArrayList<Long> subset;

    /* initialize a new state */
    public SubsetState(Long[] set, long target, ArrayList<Long> subset) {
        this.set = set;
        this.target = target;
        this.subset = subset;
    }

    /* add the element to the solution set and subtract it from the target */
    public void addToSolution(long element) {
        this.subset.add(element);
        this.target -= element;
    }

    /* remove the element from the solution set and add it back to the target */
    public void removeFromSolution(long element) {
        this.subset.remove(element);
        this.target += element;
    }

    /* returns the solution set as a string*/
    public String toString() {
        return subset.toString();
    }
}