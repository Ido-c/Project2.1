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
		long res=m+(modHash.Hash(x)+(parityCheck(j)*j*j))%m;
		return (int)res%m;
	}

	/**
	 * used instead Math.pow(-1, i) for efficiency purposes
	 * @param i - int to be checked
	 * @return 1 if i is even or -1 if odd
	 */
	private int parityCheck(long i) {
		if (i % 2 == 0) return 1;
		return -1;
	}
}
