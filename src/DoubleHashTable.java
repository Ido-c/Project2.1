public class DoubleHashTable extends OAHashTable {
	private ModHash modHash1;
	private ModHash modHash2;
	public DoubleHashTable(int m, long p) {
		super(m);
		modHash1 = ModHash.GetFunc(m,p);
		modHash2 = ModHash.GetFunc(m-1,p);
	}
	
	@Override
	public int Hash(long x, int i) {
		long j = i;
		long temp = (modHash1.Hash(x)+j*(modHash2.Hash(x)+1))%m;
		return (int) temp;
	}
	
}
