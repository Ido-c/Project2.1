import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private final ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}
	@Override
	public int Hash(long x, int i) {
		long j = i;
		long res=(modHash.Hash(x)+(parityCheck(j)*j*j))%m;
		return (int)res;
	}
	private int parityCheck(long i) {
		if (i % 2 == 0) return 1;
		return -1;
	}
}
