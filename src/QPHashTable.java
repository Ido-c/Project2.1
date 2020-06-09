import java.util.Random;

public class QPHashTable extends OAHashTable {
	private ModHash modHash;
	public QPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (modHash.Hash(x)+i*i)%m;
	}
}
