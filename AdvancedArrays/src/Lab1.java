import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Student Number: Course: CST8130 - Data Structures
 * 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */
public class Lab1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Numbers numbers = new Numbers();
		int menu = 0;
		int size;
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("Please select one of the following: ");
			System.out.println("1: Initialize a default array");
			System.out.println("2: To specify the max size of the array");
			System.out.println("3: Add value to the array");
			System.out.println("4: Display values in the array");
			System.out.println("5: Display the average of the values");
			System.out.println("6: Enter multiple values");
			System.out.println("7: Read values from file");
			System.out.println("8: Save values to file");
			System.out.println("9: Sort the array");
			System.out.println("10: To Exit");
			System.out.println("> ");

			try {
				menu = input.nextInt();
				if (menu < -1 || menu > 10) {
					throw new IndexOutOfBoundsException();
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: You've entered an invalid character!");
				input.next();
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Error: You've entered an invalid number!");

			}
			switch (menu) {

			case 1:

				numbers = new Numbers();

				System.out.println("Successfully initalized array!");

				break;

			case 2:

				try {
					System.out.println("Enter new size: ");
					size = input.nextInt();
					numbers = new Numbers(size);
				} catch (Exception e) {
					System.out.println("Error.");
				}

				break;

			case 3:

				numbers.addValue(input);

				break;

			case 4:

				System.out.println(numbers.toString());

				break;
			case 5:

				System.out.println(numbers.calcAverage());

				break;
				
			case 6:

				numbers.multipleValues();
				
				break;
			
			case 7:

				numbers.readFiles();

				break;
			
			case 8:

				numbers.saveArray();

				break;
				
			case 9:
				
				numbers.sort();
				
				break;
			}

		} while (!(menu == 10)); // quits menu
	}

}
