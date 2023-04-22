package generics.tester;

public class EvenIntegerTester implements Tester<Integer> {
    @Override
    public boolean test(Integer i) {
        return i % 2 == 0;
    }
}
