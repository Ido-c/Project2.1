import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteTester {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException, IHashTable.KeyDoesntExistException {

        Random random = new Random();
        DoubleHashTable HashTable = new DoubleHashTable(10000019, 1000000007);
        double totalTime = 0;
        for (int i = 1; i < 7; i++) {

            List<HashTableElement> lst = Stream.generate(new MySupp2()).limit(5000009)
                    .map(x -> new HashTableElement((long) x, 0)).collect(Collectors.toList());

            /*
            List<HashTableElement> lst = new ArrayList<>();
            for (int j = 0; j <5000009 ; j++) {
                int b = random.nextInt(100);
                int a = 100 * (j++) + b;
                lst.add(new HashTableElement(a,0));
              */

            for (HashTableElement elm : lst) {
                long time1 = System.currentTimeMillis();
                HashTable.Insert(elm);
                long time2 = System.currentTimeMillis();
                totalTime += (time2 - time1)/1000D;
            }

            for (HashTableElement elm : lst) {
                long time1 = System.currentTimeMillis();
                HashTable.Delete(elm.GetKey());
                long time2 = System.currentTimeMillis();
                totalTime += (time2 - time1)/1000D;
            }
            if (i%3==0) {
                System.out.println("Iteration " + i + ": " + totalTime);
                totalTime=0;
            }
        }
    }
}

    class MySupp2 implements Supplier<Integer> {
        private Random random;
        private int j;

        public MySupp2() {
            this.random = new Random();
        }

        @Override
        public Integer get() {
            int b = random.nextInt(100);
            int a = 100 * (j++) + b;
            return a;
        }
    }
