import java.util.HashSet;
import java.util.Random;

public class Tester {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        Random random = new Random();
        LPHashTable lpHashTable =new  LPHashTable(10000019, 1000000007);
        QPHashTable qpHashTable =new  QPHashTable(10000019, 1000000007);
        AQPHashTable aqpHashTable =new  AQPHashTable(10000019, 1000000007);
        DoubleHashTable doubleHashTable =new  DoubleHashTable(10000019, 1000000007);


/*        LPHashTable lpHashTable2 =new  LPHashTable(10000019, 1000000007);
        QPHashTable qpHashTable2 =new  QPHashTable(10000019, 1000000007);
        AQPHashTable aqpHashTable2 =new  AQPHashTable(10000019, 1000000007);
        DoubleHashTable doubleHashTable2 =new  DoubleHashTable(10000019, 1000000007);
        for (int j = 0; j < 5000009; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            lpHashTable2.Insert(new HashTableElement(a, 0));
            qpHashTable2.Insert(new HashTableElement(a, 0));
            aqpHashTable2.Insert(new HashTableElement(a, 0));
            doubleHashTable2.Insert(new HashTableElement(a, 0));
            }//not merged*/
        double totalTime = 0;
        for (int j = 0; j < 9500018; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            long time1 = System.nanoTime();
            lpHashTable.Insert(new HashTableElement(a, 0));
            long time2 = System.nanoTime();
            totalTime += time2 - time1;
        }
        System.out.println("LP time: " + totalTime/1000000000);
        totalTime = 0;
        for (int j = 0; j < 9500018; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            long time1 = System.nanoTime();
            qpHashTable.Insert(new HashTableElement(a, 0));
            long time2 = System.nanoTime();
            totalTime += time2 - time1;
        }
        System.out.println("QP time: " + totalTime/1000000000);
        totalTime = 0;
        for (int j = 0; j < 9500018; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            long time1 = System.nanoTime();
            aqpHashTable.Insert(new HashTableElement(a, 0));
            long time2 = System.nanoTime();
            totalTime += time2 - time1;
        }
        System.out.println("AQP time: " + totalTime/1000000000);
        totalTime = 0;
        for (int j = 0; j < 9500018; j++) {
            int b = random.nextInt(100);
            int a = 100 * j + b;
            long time1 = System.nanoTime();
            doubleHashTable.Insert(new HashTableElement(a, 0));
            long time2 = System.nanoTime();
            totalTime += time2 - time1;
        }
        System.out.println("Double time: " + totalTime/1000000000);
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