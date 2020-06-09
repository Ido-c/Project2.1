import com.sun.org.apache.xpath.internal.operations.Mod;

public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	protected ModHash modhash;
	private final HashTableElement;

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
		this.modhash = ModHash.GetFunc(m, 1000000007);
	}
	
	
	@Override
	public HashTableElement Find(long key) {
		for (int i = 0; i < table.length; i++) {
			if (table[Hash(key, i)].GetKey() == key) return table[Hash(key, i)];
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		for (int i = 0; i < table.length; i++) {
			if (table[Hash(key, i)].GetKey() == key) return table[Hash(key, i)];
		}
	}
	
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		// TODO implement deletion
	}
	
	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
