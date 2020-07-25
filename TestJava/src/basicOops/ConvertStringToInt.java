package basicOops;
import java.util.Scanner;
public class ConvertStringToInt {

	public static void main(String[] args) {
		
		System.out.println("Enter some float value : ");
		Scanner s1 = new Scanner(System.in);
		String input = s1.nextLine();
		
		int i = Integer.parseInt(input);
		System.out.println("String converted to float : " +i);
		//float f= Float.parseFloat(input);
		//System.out.println("String converted to float : " +f);
		s1.close();
		
	}

}
