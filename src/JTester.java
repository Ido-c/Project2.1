import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JTester {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        Random random = new Random();
        LPHashTable lpHashTable = new LPHashTable(10000019, 1000000007);
        QPHashTable qpHashTable = new QPHashTable(10000019, 1000000007);
        AQPHashTable aqpHashTable = new AQPHashTable(10000019, 1000000007);
        DoubleHashTable doubleHashTable = new DoubleHashTable(10000019, 1000000007);

            List<HashTableElement> lst = Stream.generate(new MySupp2()).limit(5000009)
                    .map(x -> new HashTableElement((long) x, 0)).collect(Collectors.toList());
        for (HashTableElement elem : lst) {
            lpHashTable.Insert(elem);
            qpHashTable.Insert(elem);
            aqpHashTable.Insert(elem);
            doubleHashTable.Insert(elem);
        }
        for (HashTableElement elem : lst) {
            if (lpHashTable.Find(elem.GetKey())!=elem) System.out.println("Fail 1");
            if (qpHashTable.Find(elem.GetKey())!=elem) System.out.println("Fail 2");
            if (aqpHashTable.Find(elem.GetKey())!=elem) System.out.println("Fail 3");
            if (doubleHashTable.Find(elem.GetKey())!=elem) System.out.println("Fail 4");
        }
        System.out.println("sucses ? ");
    }
}
