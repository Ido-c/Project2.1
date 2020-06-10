import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private final ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}
	@Override
	public int Hash(long x, int i) {
		int res=(modHash.Hash(x)+(parityCheck(i)*i*i));
		return (m+(res%m))%m;
	}
	private int parityCheck(int i) {
		if (i % 2 == 0) return 1;
		return -1;
	}
}
