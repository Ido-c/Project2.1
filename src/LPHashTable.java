/**
 * HashTable using open addressing with linear probing
 */
public class LPHashTable extends OAHashTable {
	private ModHash modHash;
	public LPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);

	}

	/**
	 *
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return product of Hash function (h(x)+i)%m
	 * h is a function from a universal family
	 */
	@Override
	public int Hash(long x, int i) {
		return (modHash.Hash(x)+i)%m;
	}
	
}
