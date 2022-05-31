package challenges;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;

public class SumNNumbers {
    public static void main(String @NotNull [] args) {
        long target = Long.parseLong(args[1]);

        String setString = args[2];
        String[] splitSet = setString.split(",");
        Long[] set = Arrays.stream(splitSet).map(Long::parseLong).toArray(Long[]::new);

        SumNNumbers sum = new SumNNumbers();

        System.out.println(sum.recurse(set, target).subset);
    }

    public SubsetState recurse(Long[] set, long target) {
        SubsetState state = new SubsetState(set, target, new ArrayList<Long>());
        long element = -1;
        for (int i = 0; i < set.length && set[i] < target; i++) {
            element = set[i];
        }
        return recurse(state, element);
    }

    public SubsetState recurse(SubsetState state, long element) {
        if (element == -1) {
            return state;
        }

        int el_index = 0;
        while (el_index < state.set.length && state.set[el_index] < state.target) {
            el_index++;
        }

        while (el_index >= 0) {
            state.subset.add(state.set[el_index]);
            state = recurse(state, state.set[el_index]);
            if (state.target == 0) {
                return state;
            }
            state.subset.remove(state.set[el_index]);
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
}