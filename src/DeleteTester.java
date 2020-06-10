import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteTester {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {
        Random random = new Random();
        DoubleHashTable doubleHashTable =new  DoubleHashTable(10000019, 1000000007);
        for (int i = 1; i < 7; i++) {
            List<HashTableElement> lst = Stream.generate(new MySupp2()).limit(5000009)
                    .map(x-> new HashTableElement(x, 0)).collect(Collectors.toList());
            long time1 = System.nanoTime();
            for (HashTableElement elm : lst) {
                doubleHashTable.Insert(elm);
            }
            for (HashTableElement elm : lst) {
                doubleHashTable.Delete(elm.GetKey());
            }
            long time2 = System.nanoTime();
            System.out.println("Iteration " + i + ": " + (time2 - time1));
        }
    }

    static class MySupp2 implements Supplier<Integer> {
        private Random random;
        private int j;

        public MySupp2() {
            Random random = new Random();
        }

        @Override
        public Integer get() {
            int b = random.nextInt(100);
            int a = 100 * (j++) + b;
            return a;
        }
    }
}
