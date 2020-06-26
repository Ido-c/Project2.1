/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

/**
 * HashTable using open addressing with quadratic probing
 */
public class QPHashTable extends OAHashTable {
	private ModHash modHash;
	public QPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return product of Hash function (h(x)+i^2)%m
	 * h is a function from a universal family
	 */
	@Override
	public int Hash(long x, int i) {
		long j = i;
		long modH = (modHash.Hash(x)+(j*j)%m);
		return (int)(modH)%m;
	}
}