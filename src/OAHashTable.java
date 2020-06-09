import com.sun.org.apache.xpath.internal.operations.Mod;

public abstract class OAHashTable implements IHashTable {

    private HashTableElement[] table;
    private final HashTableElement hteDeleted = new HashTableElement(0L, 0L);
    protected int m;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
        this.m = m;
    }


    @Override
    public HashTableElement Find(long key) {
        for (int i = 0; i < table.length; i++) {
            if (table[Hash(key, i)].GetKey() == key) return table[Hash(key, i)];
        }
        return null;
    }

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        for (int i = 0; i < table.length; i++) {
            if (table[Hash(hte.GetKey(), i)] == null || table[Hash(hte.GetKey(), i)] == hteDeleted) {
                table[Hash(hte.GetKey(), i)] = hte;
                return;
            } else if (table[Hash(hte.GetKey(), i)].GetKey() == hte.GetKey()) {
                throw new KeyAlreadyExistsException(hte);
            }
        }
        throw new TableIsFullException(hte);
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        for (int i = 0; i < table.length; i++) {
            if (table[Hash(key, i)].GetKey() == key) {
                table[Hash(key, i)] = hteDeleted;
                return;
            }
        }
        throw new KeyDoesntExistException(key);
    }

    /**
     * @param x - the key to hash
     * @param i - the index in the probing sequence
     * @return the index into the hash table to place the key x
     */
    public abstract int Hash(long x, int i);
}
