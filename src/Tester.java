import java.util.HashSet;
import java.util.Random;

public class Tester {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        Random random = new Random();
        long time0 = System.nanoTime();
        LPHashTable lpHashTable =new  LPHashTable(10000019, 1000000007);
        QPHashTable qpHashTable =new  QPHashTable(10000019, 1000000007);
        AQPHashTable aqpHashTable =new  AQPHashTable(10000019, 1000000007);
        DoubleHashTable doubleHashTable =new  DoubleHashTable(10000019, 1000000007);
        long time1 = System.nanoTime();
        for (int j = 0; j < 5000009; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            lpHashTable.Insert(new HashTableElement(a, 0));
        }
        long time2 = System.nanoTime();
        for (int j = 0; j < 5000009; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            qpHashTable.Insert(new HashTableElement(a, 0));
        }
        long time3 = System.nanoTime();
        for (int j = 0; j < 5000009; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            aqpHashTable.Insert(new HashTableElement(a, 0));
        }
        long time4 = System.nanoTime();
        for (int j = 0; j < 5000009; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            doubleHashTable.Insert(new HashTableElement(a, 0));
        }
        long time5 = System.nanoTime();
        System.out.println("Initialize: " + (time1 - time0));
        System.out.println("LP time: " + (time2 - time1));
        System.out.println("QP time: " + (time3 - time2));
        System.out.println("AQP time: " + (time4 - time3));
        System.out.println("Double time: " + (time5 - time4));
    }
}





 /*   HashSet<Integer> Q1 = new HashSet<>();
    HashSet<Integer> Q2 = new HashSet<>();
        for (int i = 0; i < 6571; i++) {
        Q1.add((i*i)%6571);
        Q2.add((int)(Math.pow(-1, i)*i*i)%6571);
    }
        System.out.println("Q1 size is: " + Q1.size());
        System.out.println("Q2 size is: " + Q2.size());
}*/