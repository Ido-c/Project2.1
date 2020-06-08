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

	public static ModHash GetFunc(int m, long p){
		long a = ThreadLocalRandom.current().nextLong(1,p);
		long b = ThreadLocalRandom.current().nextLong(1,p);
		// TODO implement random choice of mod function from family
		return new ModHash(a,b,m,p);
	}
	
	public int Hash(long key) {
		// TODO implement hash function
		return (int) (((a*key+b)%p)%m);
	}
}
