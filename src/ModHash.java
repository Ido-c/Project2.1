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
		long b = ThreadLocalRandom.current().nextLong(0,p);
		return new ModHash(a,b,m,p);
	}
	
	public int Hash(long key) {
		long temp =((a*key+b)%p);
		temp=temp%m;
		return (int)temp;
	}
}
