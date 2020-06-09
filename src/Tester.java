import java.util.HashSet;

public class Tester {
    public static void main(String[] args) {
        HashSet<Integer> Q1 = new HashSet<>();
        HashSet<Integer> Q2 = new HashSet<>();
        for (int i = 0; i < 6571; i++) {
            Q1.add((i*i)%6571);
            Q2.add((int)(Math.pow(-1, i)*i*i)%6571);
        }
        System.out.println("Q1 size is: " + Q1.size());
        System.out.println("Q2 size is: " + Q2.size());
    }
}
