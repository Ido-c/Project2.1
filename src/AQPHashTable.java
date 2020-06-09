import java.util.Random;

public class AQPHashTable extends OAHashTable {
	private final ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
		// TODO Complete hash table constructor.
	}
	@Override
	public int Hash(long x, int i) {
		// TODO implement hash function
		return (modHash.Hash(x)+(int)(Math.pow(-1,i))*i*i);
	}
}
