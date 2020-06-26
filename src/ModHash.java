/*
 work by:
 Jacob Gidron 315964536 jacobgidron
 Ido Cohen 305199416 idoc
 */

import java.util.concurrent.ThreadLocalRandom;

public class ModHash {
	private final long a;
	private final long b;
	private final int m;
	private final long p;

	public ModHash(long a,long b,int m,long p){
		this.a=a;
		this.b=b;
		this.m=m;
		this.p=p;
	}

	/**
	 *
	 * @param m - size of Table
	 * @param p - Prime number larger than m
	 * @return a ModHash object with parameters for building a Hash function from a universal family
	 */
	public static ModHash GetFunc(int m, long p){
		long a = ThreadLocalRandom.current().nextLong(1,p);
		long b = ThreadLocalRandom.current().nextLong(0,p);
		return new ModHash(a,b,m,p);
	}

	/**
	 *
	 * applies Hash function from a universal family on given key
	 * @param key - key of HashTableElement to be Hashed
	 * @return the product of applying the Hash function on key.
	 */
	public int Hash(long key) {
		long temp =((a*key+b)%p);
		temp=temp%m;
		return (int)temp;
	}
}