import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomShit {
    public static void main(String[] args) {
        DoubleHashTable hashTable =new  DoubleHashTable(6571, 1000000007);
        List<Integer> list = Stream.generate(new MySupp(Integer.parseInt(args[0]))).limit(7000).collect(Collectors.toList());
        Set<Integer> set =Stream.generate(new MySupp(Integer.parseInt(args[0]))).limit(7000).collect(Collectors.toSet());
        System.out.println(list.size()+" l vs s "+set.size());
        System.out.println(set.getClass().getCanonicalName());
        /*
        int SumErr1=0;
        int SumErr2=0;
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
                    SumErr1++;
                } catch (IHashTable.KeyAlreadyExistsException e) {
                    err2++;
                    SumErr2++;
                }
            }
            System.out.println("TableIsFullException "+err1+" KeyAlreadyExistsException "+err2);
        }
        System.out.println("overoll TableIsFullException "+SumErr1+" oveall KeyAlreadyExistsException "+SumErr2);

         */


    }

   public static class MySupp implements Supplier<Integer> {
        private int i;
        private int k;
        private DoubleHashTable hashTable = new DoubleHashTable(6571, 1000000007);

        public MySupp(int k) {
            this.k = k;
        }

        @Override
        public Integer get() {
            return hashTable.Hash(k, i++);
        }
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
        class MySupp2 implements Supplier<Integer>{
            private Random random;
            private int j;
            public MySupp2(){
                Random random = new Random();
            }

            @Override
            public Integer get() {
                int b= random.nextInt(100);
                int a = 100*(j++)+b;
                return a;
            }
        }
        }


