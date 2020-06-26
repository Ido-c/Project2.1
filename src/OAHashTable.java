/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

import com.sun.org.apache.xpath.internal.operations.Mod;

public abstract class OAHashTable implements IHashTable {

    private HashTableElement[] table;
    private final HashTableElement hteDeleted = new HashTableElement(0L, 0L);
    protected int m;

    public OAHashTable(int m) {
        this.table = new HashTableElement[m];
        this.m = m;
    }

    /**
     * @param key - the key to find in the table
     * @return the HashTableElement with the desired key if exists in table. else returns null
     */
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

    /**
     * @param hte - the HashTableElement to be added to the table
     * @throws TableIsFullException      - if  probing sequence ended without finding a vacant index
     * @throws KeyAlreadyExistsException - if found HashTableElement with same key
     */
    @Override
    public void Insert(HashTableElement hte) throws TableIsFullException, KeyAlreadyExistsException {
        if (Find(hte.GetKey()) != null) {
            throw new KeyAlreadyExistsException(hte);
        } else {
            for (int i = 0; i < table.length; i++) {
                int hashed = Hash(hte.GetKey(), i);
                if (table[hashed] == null || table[hashed] == hteDeleted) {
                    table[hashed] = hte;
                    return;
                }
            }
        }
        throw new TableIsFullException(hte);
    }


    /**
     * @param key - the key of the HashTableElement to be deleted from the table
     * @throws KeyDoesntExistException - if couldn't find HashTableElement with desired key
     */
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
