import java.util.List;
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
        List<Integer> list = Stream.generate(new MySupp(100)).limit(6571).collect(Collectors.toList());
        Set<Integer> set =Stream.generate(new MySupp(100)).limit(6571).collect(Collectors.toSet());
        System.out.println(list.size()+" l vs s "+set.size());
        System.out.println(set.getClass().getCanonicalName());
        }
    }
    class MySupp implements Supplier<Integer>{
        private int i;
        private int k;
        private DoubleHashTable hashTable =new  DoubleHashTable(6571, 1000000007);
        public MySupp(int k){
            this.k=k;
        }
        @Override
        public Integer get() {
            return hashTable.Hash(k,i++);
        }
    }


