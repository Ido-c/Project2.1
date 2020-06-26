/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

/**
 * HashTable using open addressing with Double Hashing
 */
public class DoubleHashTable extends OAHashTable {
	private ModHash modHash1;
	private ModHash modHash2;
	public DoubleHashTable(int m, long p) {
		super(m);
		modHash1 = ModHash.GetFunc(m,p);
		modHash2 = ModHash.GetFunc(m-1,p);
	}

	/**
	 *
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return product of Hash function (h1(x)+ih2(x)+1)%m
	 * +1 is used in order to not get a step of size zero
	 * h is a function from a universal family
	 */
	@Override
	public int Hash(long x, int i) {
		long j = i;
		long temp = (modHash1.Hash(x)+j*(modHash2.Hash(x)+1))%m;
		return (int) temp;
	}
	
}
