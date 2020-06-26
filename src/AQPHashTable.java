/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

/**
 * HashTable using open addressing with alternating quadratic probing
 */
public class AQPHashTable extends OAHashTable {
	private final ModHash modHash;

	public AQPHashTable(int m, long p) {
		super(m);
		modHash = ModHash.GetFunc(m,p);
	}

	/**
	 *
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return product of Hash function (h(x)+((-1)^i)*i^2)%m
	 * h is a function from a universal family
	 */
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
