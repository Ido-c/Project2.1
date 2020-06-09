import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private final ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}
	@Override
	public int Hash(long x, int i) {
		int res=(modHash.Hash(x)+(int)(Math.pow(-1,i))*i*i);
		return (m+(res%m))%m;
	}
}
