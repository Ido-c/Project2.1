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
            int hashed = Hash(key, i);
            if (table[hashed] == null) {
                return null;
            } else if (table[hashed] == hteDeleted) {
                continue;
            } else if (table[hashed].GetKey() == key) {
                return table[hashed];
            }
        }
        return null;
    }

    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        for (int i = 0; i < table.length; i++) {
            int hashed = Hash(hte.GetKey(), i);
            if (table[hashed] == null || table[hashed] == hteDeleted) {
                table[hashed] = hte;
                return;
            } else if (table[hashed].GetKey() == hte.GetKey()) {
                throw new KeyAlreadyExistsException(hte);
            }
        }
        throw new TableIsFullException(hte);
    }

    @Override
    public void Delete(long key) throws KeyDoesntExistException {
        for (int i = 0; i < table.length; i++) {
            int hashed = Hash(key, i);
            if (table[hashed] == null) {
                throw new KeyDoesntExistException(key);
            } else if (table[hashed] == hteDeleted) {
                continue;
            } else if (table[hashed].GetKey() == key) {
                table[hashed] = hteDeleted;
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
