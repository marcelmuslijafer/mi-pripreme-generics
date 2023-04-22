package generics.comparators;

public class IntegerComparator implements MyComparator<Integer> {

    @Override
    public int compare(Integer i1, Integer i2) {
        return i1 - i2;
    }
}
