import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomShit {
    public static void main(String[] args) {
        /*LPHashTable hashTable =new  LPHashTable(6571, 1000000007);
        for (int i = 0; i <6571 ; i++) {
            System.out.print("hush ("+100+","+i+")"+hashTable.Hash(100,i));
            if (i%10==0&&i>0) System.out.println();*/
        List<Integer> list = Stream.generate(new MySupp(Integer.parseInt(args[0]))).limit(6571).collect(Collectors.toList());
        Set<Integer> set =Stream.generate(new MySupp(Integer.parseInt(args[0]))).limit(6571).collect(Collectors.toSet());
        System.out.println(list.size()+" l vs s "+set.size());
        System.out.println(set.getClass().getCanonicalName());
        System.out.println(list.toString());

        for (int i = 0; i <100 ; i++) {
            int err1=0;
            int err2=0;
            Random random = new Random();
            AQPHashTable hashTable =new  AQPHashTable(6571, 1000000007);
            for (int j = 0; j <6571 ; j++) {
                int b= random.nextInt(100);
                int a = 100*j+b;
                try {
                    hashTable.Insert(new HashTableElement(a,0));
                } catch (IHashTable.TableIsFullException e) {
                    err1++;
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    err2++;
                }
            }
            System.out.println("TableIsFullException "+err1+" KeyAlreadyExistsException "+err2);
        }
        }
    }
    class MySupp implements Supplier<Integer> {
        private int i;
        private int k;
        private AQPHashTable hashTable = new AQPHashTable(6571, 1000000007);

        public MySupp(int k) {
            this.k = k;
        }

        @Override
        public Integer get() {
            return hashTable.Hash(k, i++);
        }


        /*
            class MySupp implements Supplier<Integer>{
        private int i;
        private int k;
        private QPHashTable hashTable =new  QPHashTable(6571, 1000000007);
        public MySupp(int k){
            this.k=k;
        }
        @Override
        public Integer get() {
            return hashTable.Hash(k,i++);
        }
         */
        }


