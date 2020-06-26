/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

public class HashTableElement{
	private long key;
	private long value;
	
	public HashTableElement(long key, long value) {
		this.key = key;
		this.value = value;
	}
	
	public long GetKey() { return this.key;}
	
	public long GetValue() { return this.value;}
}