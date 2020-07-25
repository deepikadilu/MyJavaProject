package basicOops;

public class TypeCastingEample {

	public static void main(String[] args) {
		
		// Implicit type casting - widening
		int i=20;
		long l =i;
		float f= l;
		
		System.out.println("integer number :" +i);
		System.out.println("Type cast int to long number :" +l);
		System.out.println("Type cast long to float number :" +f);
		
		
		// Explicit type casting
		
		double d = 30.98;
		f = (float) d;
		l = (long) f;
		i = (int) l;
		
		System.out.println("double number :" +d);
		System.out.println("Type cast double to float number :" +f);
		System.out.println("Type cast float to long number :" +l);
		System.out.println("Type cast long to int number :" +i);
	}

}
