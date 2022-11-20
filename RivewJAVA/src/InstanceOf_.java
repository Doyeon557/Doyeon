import java.util.stream.IntStream;

public class InstanceOf_ {

	public static void main(String[] args) {
		/*
		 * InstanceOf
		 */
		System.out.println("====class A====");
		A a = new A("A멤버변수 a");
		a.aMethod();
		
		System.out.println("====class B extends A====");
		B b = new B("A멤버변수 a", "B멤버변수 b");
		b.bMethod();
		b.aMethod();
		
		System.out.println("====B ->upCasting-> A====");
		A ba = new B("A멤버변수 a", "B멤버변수 b");
		ba.aMethod();
		//Before Override, System.out.println(a); aMethod run
		//After Override, System.out.println(b + ": aMethod Override"); Overridden aMethod run
		//=> Dynamic Binding
		
		System.out.println(b instanceof A); //true: b -> A type (up casting)
		System.out.println(a instanceof B); //false: a -> B type (down casting)
		System.out.println(ba instanceof B);//true: B -> A ba -> B (-> up -> down casting)
		
		System.out.println("====class C extends B====");
		C c = new C("A멤버변수 a", "B멤버변수 b");
		System.out.println(c instanceof B);// true
		System.out.println(c instanceof A);// true
		
		if(c instanceof A) {
			c.aMethod();
		}else {
			c.cMethod();
		} // => up casting O
		
	}

}

class A {
	String a;
	
	
	public A(String a) {
		this.a = a;
	}


	public void aMethod() {
		System.out.println(a);
	}
}

class B extends A{
	String b;

	public B(String a, String b) {
		super(a);
		this.b = b;
	}
	
	
	
	@Override
	public void aMethod() {
		System.out.println(b + ": aMethod Override");
	}



	public void bMethod() {
		super.aMethod();
		System.out.println(b);
	}
	
}

class C extends B {

	public C(String a, String b) {
		super(a, b);
	}
	
	@Override
	public void aMethod() {
		System.out.println("up casting O");
	}
	
	public void cMethod() {
		System.out.println("up casting X");
	}

	
}