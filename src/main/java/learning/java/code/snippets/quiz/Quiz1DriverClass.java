package learning.java.code.snippets.quiz;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**********************************************************************/

class Quiz1DriverClass {
	public static void main(String[] args) {}
	
}

class TestThreadRun implements Runnable {

	public void run() {
		System.out.println("running : " + Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		Thread t = new Thread(new TestThreadRun());
		
		System.out.println(Thread.currentThread().getName());
		t.run();
		
		System.out.println(Thread.currentThread().getName());
		t.run();
		
		System.out.println(Thread.currentThread().getName());
		t.start();
		
		System.out.println(Thread.currentThread().getName());
		t.start();
	}
}

/**********************************************************************/

class Plant {
	private String name;

//	public Plant() {}
	
	public Plant() {
		this("fern");
	}
	
	public Plant(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}

class Tree extends Plant {

//	public Tree(String name) {
//		super(name);
//	}

	public void growFruit() {
	}

	public void dropLeaves() {
	}
}



/**********************************************************************/

class Nav {
	public enum Direction {
		NORTH, SOUTH, EAST, WEST
	}
}

class Sprite {

//	Direction d1 = NORTH;
//	Nav.Direction d2 = NORTH;
//	Direction d3 = Direction.NORTH;
	Nav.Direction d4 = Nav.Direction.NORTH;
	
}


/**********************************************************************/


class TestSeven extends Thread {

	private static int x;

	public synchronized void doThings() {
		int current = x;
		current++;
		x = current;
	}

	public void run() {
		doThings();
	}
}

/**********************************************************************/

class Test16 {

	public static void main(String[] args) {
		test(null);
	}
	
	public static void test(String str) {
		if (str == null | str.length() == 0) {
			System.out.println("String is empty");
		} else {
			System.out.println("String is not empty");
		}
	}
}


/**********************************************************************/
class WrappedString30 {
	private String s;

	public WrappedString30(String s) {
		this.s = s;
	}

	public static void main(String[] args) {
		
		HashSet<Object> hs = new HashSet<Object>();
		WrappedString30 ws1 = new WrappedString30("aardvark");
		WrappedString30 ws2 = new WrappedString30("aardvark");
		String s1 = new String("aardvark");
		String s2 = new String("aardvark");
		hs.add(ws1);
		hs.add(ws2);
		hs.add(s1);
		hs.add(s2);
		System.out.println(hs.size());
	}
}


/**********************************************************************/

class One {
	public One() {
		System.out.print(1);
	}
}

class Two extends One {
	public Two() {
		System.out.print(2);
	}
}

class Three extends Two {
	public Three() {
		System.out.print(3);
	}
}

class Numbers_10 {
	public static void main(String[] argv) {
		new Three();
	}
}

/**********************************************************************/

class Yikes_14 {
	
	public static void go(Long n) {
		System.out.println("Long ");
	}

	public static void go(Short n) {
		System.out.println("Short ");
	}

	public static void go(int n) {
		System.out.println("int ");
	}

	public static void main(String[] args) {
		short y = 6;
		long z = 7;
		go(y);
		go(z);
	}
}

/**********************************************************************/

class TestException extends Exception {}

class A {
	String sayHello(String name) throws TestException {

		if (name == null) {
			throw new TestException();
		}
		return "Hello" + name;
	}

	public static void main(String[] args) {
		A a = new A();

//		Unhandled exception type TestException
//		System.out.println(a.sayHello("John"));
	}

}


class A1 {
	String sayHello(String name) {

		if (name == null) {
			try {
				throw new TestException();
			} catch (Exception e) {
			}
		}
		return "Hello" + name;
	}

	public static void main(String[] args) {
		A1 a1 = new A1();

//		Unhandled exception type TestException
		System.out.println(a1.sayHello("John"));
	}

}


/**********************************************************************/
class Test27 {
	
//	Illegal modifier for the field obj
//	private synchronized Object obj;
	
	private Object obj;

//	void go1() { synchronized() { /* code here */ }

	public synchronized void go2() {/* code here */ }

//	private synchronized(this) void go3() { /* code here */ }

	void go4() { synchronized(Object.class) { /* code here */ }}

	void go5() { Object o = new Object(); synchronized(o) { /* code here */ }}
}

/**********************************************************************/
//28) Which are possible results?
//0, 2, 4, 4, 6, 8, 10, 6,
//0, 2, 4, 6, 8, 10, 2, 4,
//0, 2, 4, 6, 8, 10, 12, 14,
//0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14,
//0, 2, 4, 6, 8, 10, 12, 14, 0, 2, 4, 6, 8, 10, 12, 14,

class Threads28 {
	
	int x = 0;
	
	class Runner28 implements Runnable {

		@Override
		public void run() {
			
			int current = 0;
			
			for (int i = 0; i < 4; i++) {
				current = x;
				System.out.print(current + ", ");
				x = current + 2;
			}
		}
	}
	
	public static void main(String[] args) {
		new Threads28().go();
	}
	
	public void go() {
		Runnable r1 = new Runner28();
		new Thread(r1).start();
		new Thread(r1).start();
	}
}


/**********************************************************************/

class tset1 {
	static int x = 6;

	public static void main(String[] args) {
		tset1 p = new tset1();
		p.doStuff(x);
		System.out.println(" main x = " + x);
	}

	void doStuff(int x) {
		System.out.println(" doStuff x = " + x++);
	}
}

/*
What is the result?

Compilation fails
An exception is thrown at runtime.
doStuff x = 6 main x = 6 <--
doStuff x = 7 main x = 7
doStuff x = 7 main x = 6
doStuff x = 6 main x = 7
*/

/**********************************************************************/

class Uber20 {
	
	static int y = 2;

	Uber20(int x) {
		this();
		y = y * 2; //2. 6
	}

	Uber20() {
		y++; //1. 3
	}
}

class Minor20 extends Uber20 {
	
	Minor20() {
		super(y);
		y = y + 3; //3. 9
	}

	public static void main(String[] args) {
		new Minor20();
		System.out.println(y);
	}
}

/**********************************************************************/

class Example2 {
	
	public static void main(String[] args) {
		Short s = 15;
		Boolean b;
		// insert code here
//		b = (Number instanceof s); X
		b = (s instanceof Short);
//		b = s.instanceof(Short); C
		b = (s instanceof Number);
//		b = s.instanceof(Object); C
//		b = (s instanceof String);	

		// Correct
		b = (s instanceof Short);
		b = (s instanceof Number);
		
		System.out.println();
	}
}

/**********************************************************************/

class Yippee4 {
	public static void main(String[] args) {
		
		String[] args1 = {};
		String[] args2 = {"1", "2", "3", "4"};
		
		for (int x = 1; x < args1.length; x++) {
			System.out.print(args1[x] + " ");
		}
		
		for (int x = 1; x < args2.length; x++) {
			System.out.print(args2[x] + " ");
		}
	}
}

/**********************************************************************/

abstract class Shape8 {
	private int x;
	private int y;

	public abstract void draw();

	public void setAnchor(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/**********************************************************************/

/*
We want to guarantee that the output can be either XXYY or YYXX,
but never XYXY or any other combination.
*/
class Letters3 extends Thread {
	
	private String name;

	public Letters3(String name) {
		this.name = name;
	}

	public void write() {
		System.out.print(name);
		System.out.print(name);
	}


//	public void run() {
	public synchronized void run1() { // NO -> YXXY
		try {Thread.sleep(100);} catch (Exception e) {}
		write();
	}
	
	public void run2() { // NO -> YXXY | XYYX
		try {Thread.sleep(100);} catch (Exception e) {}
		synchronized (this) {
			write();
		}
	}
	
	public void run3() { // Works?
		try {Thread.sleep(100);} catch (Exception e) {}
		synchronized (Letters3.class) {
			write();
		}
	}
	
	public void run4() { // Works?
		try {Thread.sleep(100);} catch (Exception e) {}
		synchronized (System.out) {
			write();
		}
	}
	
	
	public static void main(String[] args) {
		new Letters3("X").start();
		new Letters3("Y").start();
		
	}
}

/**********************************************************************/

class Starter26 extends Thread {

	private int x = 2;

	public static void main(String[] args) throws Exception {
		new Starter26().makeItSo();
		//Constructor -> x = 5 -> run() -> x = 10
		//join() -> x = 9
	}

	public Starter26() {
		x = 5;
		start();
	}

	public void makeItSo() throws Exception {

//		join(); // Without Join -> 4
		join(); // 9
		x = x - 1;
		System.out.println(x); // 9?
	}

	public void run() {
		x *= 2;
	}

}

/**********************************************************************/

interface DeclareStuff21 {
	public static final int EASY = 3;

	void doStuff(int t);
}

class TestDeclare21 implements DeclareStuff21 {
	
	public static void main(String[] args) {
		int x = 5;
		new TestDeclare21().doStuff(++x);
	}

	public void doStuff(int s) {
		s += EASY + ++s;
		//s = s + EASY + ++s;
		// s = 6 + 3 + 7 ? CORRECT -> s 16
		// s = 7 + 3 + 7 ? X
		
		System.out.println("s " + s);
	}
}

/**********************************************************************/

/*
Compilation fails. // X
The code compiles and the output is 2.
If lines 16, 17 and 18 were removed, compilation would fail. // X
If lines 24, 25 and 26 were removed, compilation would fail. // X
If lines 16, 17 and 18 were removed, the code would compile and the output would be 2.
If lines 24, 25 and 26 were removed, the code would compile and the output would be 1.
*/

interface Foo10 {
	int bar();
}

class Beta10 {

	class A implements Foo10 {
		public int bar() {
			return 1;
		}
	}

	public int fubar(Foo10 foo) {
		return foo.bar();
	}

	public void testFoo() {
		
		class A implements Foo10 {
			public int bar() {
				return 2;
			}
		}

		System.out.println(fubar(new A()));
	}

	public static void main(String[] args) {
		new Beta10().testFoo();
	}
	
}

/**********************************************************************/

class Old29 {
	public static Object get0(List list) {
		return list.get(0);
	}

	public static void main(String[] args) {
		
		Object o1 = Old29.get0(new LinkedList());
		
//		Which will compile successfully?
		
		// Cannot instantiate the type LinkedList<?>
//		Object o2 = Old29.get0(new LinkedList<?>());
		
		// Type mismatch: cannot convert from Object to String
//		String s3 = Old29.get0(new LinkedList<String>());
		
		Object o4 = Old29.get0(new LinkedList<Object>());
		
		String s5 = (String) Old29.get0(new LinkedList<String>());
		
	}

}

/**********************************************************************/

class Base15 {

	public static final String FOO = "foo";

	public static void main(String[] args) {

		Base15 b = new Base15();
		
		Sub s = new Sub();
		
		System.out.println(Base15.FOO); // foo
		System.out.println(Sub.FOO); // bar
		System.out.println(b.FOO); // foo
		System.out.println(s.FOO); // bar
		System.out.println(((Base15) s).FOO); // foo
	}
}

class Sub extends Base15 {
	public static final String FOO = "bar";
}

/**********************************************************************/

class Employee18 {
	
	String name;
	double baseSalary;

	Employee18(String name, double baseSalary) {
		this.name = name;
		this.baseSalary = baseSalary;
	}
}

class Salesperson18 extends Employee18 {

	double commission;

	public Salesperson18(String name, double baseSalary, double commission) {
		// insert code here
		super(name, baseSalary);
		this.commission = commission;
	}
}


/**********************************************************************/
//public static void main(String[] args) {}
