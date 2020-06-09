import java.util.Random;

public class LPHashTable extends OAHashTable {
	private ModHash modHash;
	public LPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);

		// TODO Complete hash table constructor.
	}
	
	@Override
	public int Hash(long x, int i) {
		return (modHash.Hash(x)+i)%m;
	}
	
}
