import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Ryan Maidment Student Number: 040932067 Course: CST8130 - Data
 * Structures
 * 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 *
 */
public class Numbers {

	Scanner input = new Scanner(System.in);

	/**
	 * Stores Float values.
	 */
	private float[] numbers;

	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;

	/**
	 * Default Constructor
	 */
	public Numbers() {

		this.numbers = new float[10];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * 
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {

		this.numbers = new float[size];

	}

	/**
	 * Adds a value in the array
	 * 
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		int x = 1;
		Float num = null;
		do {
			try {
				System.out.println("Enter value to enter array: ");
				num = keyboard.nextFloat();
				x = 2;
				if (num <= 0) {
					do {
						System.out.println("Please enter a valid number.");
						num = keyboard.nextFloat();
					} while (num <= 0);
				}
			} catch (Exception e) {
				System.out.println("Error.");
				return;
			}
		} while (x == 1);

		numbers[numItems] = num;
		numItems++;
	}

	/**
	 * Calculates the average of all the values in the numbers array.
	 * 
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float sum = 0;
		// Loops through array to calculate average.
		for (int i = 0; i < numItems; i++) {

			sum += java.lang.Float.valueOf(numbers[i]);
		}
		float average = sum / numItems;

		return (float) average;

	}

	@Override
	public String toString() {

		String str = "";
		// for loop to print numbers[]
		for (int i = 0; i < numItems; i++) {
			str += numbers[i] + "\n";
		}

		return str;

	}

	public void saveArray() {

		System.out.println("Name the file you want to save to: ");
		String inputFile = input.nextLine();

		try {
			FileWriter fr = new FileWriter(inputFile);

			fr.write(toString());

			fr.close();

		}

		catch (IOException e) {
			System.out.println(e);
		}

	}

	public void readFiles() {
		Scanner scan = null;
		String i;
		System.out.println("Enter file name: ");

		String filePath = input.next();

		File file = new File(filePath);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry this file does not exist.\n");
			return;
		}

		try {
			while ((i = scan.nextLine()) != null) {
				System.out.println(i);
			}
		} catch (NoSuchElementException e) {

		}
		scan.close();
	}

	public void multipleValues() {

		System.out.println("How many values would you like to add? ");
		float j = 0;
		try {
			j = input.nextInt();
		} catch (Exception e) {
			System.err.println("Error, not valid input.\n");
		}
		if(j > numItems) {
			System.err.println("Error, array too small. Please resize array.");
			return;
		}
		for (int i = 0; i < j; i++) {

			int x = 1;
			Float f = null;
			do {
				try {
					System.out.println("Enter value to enter array: ");
					f = input.nextFloat();
					x = 2;
					if (f <= 0) {
						do {
							System.out.println("Please enter a valid number.");
							f = input.nextFloat();
						} while (f <= 0);
					}
				} catch (Exception e) {
					System.out.println("Error.");
					return;
				}
			} while (x == 1);

			numbers[numItems] = f;
			numItems++;

		}

	}

	public void sort() {
		   float n = numItems;  
	        for (int j = 1; j < n; j++) {  
	            float key = numbers[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( numbers [i] > key ) ) {  
	                numbers [i+1] = numbers [i];  
	                i--;  
	            }  
	            numbers[i+1] = key;  
	}
}
}
