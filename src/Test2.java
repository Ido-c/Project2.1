import java.util.Random;

public class Test2 {
    public static void main(String[] args) throws IHashTable.TableIsFullException, IHashTable.KeyAlreadyExistsException {
        Random random = new Random();
      /*  //not meagered
        LPHashTable lpHashTable2 = new LPHashTable(10000019, 1000000007);
        QPHashTable qpHashTable2 = new QPHashTable(10000019, 1000000007);
        AQPHashTable aqpHashTable2 = new AQPHashTable(10000019, 1000000007);
        DoubleHashTable doubleHashTable2 = new DoubleHashTable(10000019, 1000000007);
        for (int j = 0; j < 5000009; j++) {
            long b = random.nextInt(100);
            long a = 100 * j + b;
            lpHashTable2.Insert(new HashTableElement(a, 0));
        }//not merged*/
        double totalTotalTime=0;
        for (int time = 0; time < 30; time++) {
            AQPHashTable aqpHashTable =new  AQPHashTable(10000019, 1000000007);
            double totalTime = 0;
            for (int j = 0; j < 9500018; j++) {
                long b = random.nextInt(100);
                long a = 100 * j + b;
                long time1 = System.currentTimeMillis();
                aqpHashTable.Insert(new HashTableElement(a, 0));
                long time2 = System.currentTimeMillis();
                totalTime += (time2 - time1)/ 1000D;
            }
            System.out.println("QP time: " + totalTime );
            totalTotalTime+=totalTime;
        }
        System.out.println("QP averege time: " + totalTotalTime / 30);
        }
}
