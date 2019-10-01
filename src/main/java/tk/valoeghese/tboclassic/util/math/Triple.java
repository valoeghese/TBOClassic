package tk.valoeghese.tboclassic.util.math;

public class Triple<A, B, C>
{
	protected A a;
	protected B b;
	protected C c;
	
	public A getA()
	{
		return this.a;
	}
	
	public B getB()
	{
		return this.b;
	}
	
	public C getC()
	{
		return this.c;
	}
	
	public Triple(A a, B b, C c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
