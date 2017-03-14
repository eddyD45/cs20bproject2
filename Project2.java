import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Eddy De Leon
 * @ID 1523723
 *
 */


public class Project2 {

	/**
	 * Read in a file containing student records and create an array of Student
	 * objects
	 * 
	 * @param file The filename
	 * @param num The number of students in the file
	 * @return An array of Student objects
	 */
	static Student[] readStudentsFromFile(String filename, int num) {
		try (Scanner in = new Scanner(new File(filename))) {
			Student[] students = new Student[num];
			int i = 0;
			
			// YOUR CODE HERE
			// Hints:
			// To read a line from the file you can call 
			//		String line = in.nextLine();
			// The split method of the String class might come in handy to get the fields
			do {
				String line = in.nextLine();
				String [] info = line.split(",");
				String tempName = info[0];
				int tempId = Integer.parseInt(info[1]);
				String tempSchool = info[2];
				Student tempStudent = new Student(tempName, tempId, tempSchool);
				students[i] = tempStudent;
				i++;
			} while (filename.hasNextLine());
			
			
			
			return students;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Write an array of Student objects to a file
	 * 
	 * @param students The array of Student objects to write out
	 * @param filename The output filename
	 */
	static void writeStudentsToFile(Student[] students, String filename) {
		try (FileWriter out = new FileWriter(filename)) {
			
			// YOUR CODE HERE
			// Hints:
			// To write a line to the file you can call 
			//		   out.write("Hello World!" + "\n");
			for (int i = 0; i < students.length; i++) {
				String tempToString = students[i].toString();
				String [] tempInfo = tempToString.split(",");
				String tempName = tempInfo[0];
				String tempId = tempInfo[1];
				String tempSchool = tempInfo[2];
				out.writeln(tempName + "," + tempId + "," + tempSchool);
			}
			out.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Find students belonging to both groups.
	 * 
	 * This function checks each student in group1 for membership in group2 by
	 * comparing it with every student in group2.
	 * 
	 * @param group1 A group of Students
	 * @param group2 A group of Students
	 * @param numCommon number of students belonging to both groups
	 * @return An array of Students which belong to both group1 and group2
	 */
	static Student[] findCommonStudents1(Student[] group1, Student[] group2,
			int numCommon) {
		Student[] common = new Student[numCommon];

		// YOUR CODE HERE
		if (group1.length >= group2.length) {
			for (int i = 0; i < group1.length; i++;) {
				for(int j = 0; j < group2.length; j++;) {
					
				}
			}
		}

		return common;
	}

	/**
	 * Find students belonging to both groups.
	 * 
	 * This function checks each student in group1 for membership in group2 by
	 * doing a binary search on group2.
	 * 
	 * @param group1 A group of Students
	 * @param group2 A group of Students
	 * @param numCommon number of students belonging to both groups
	 * @return An array of Students which belong to both group1 and group2
	 */
	static Student[] findCommonStudents2(Student[] group1, Student[] group2,
			int numCommon) {
		Student[] common = new Student[numCommon];
		
		// YOUR CODE HERE
		// Hints:
		// To search for an element in a sorted array you can call
		// 		Arrays.binarySearch(arr, element)
		// if the returned index is >= 0, the element was found at that index

		return common;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/***** These files provided to help you with initial testing *****/
		Student[] uc = readStudentsFromFile("sample_uc_students.txt", 10);
		Student[] smc = readStudentsFromFile("sample_smc_grads.txt", 5);
		final int SMC_UC_GradsNumber = 2;
		
		/***** Use these files for the output you submit *****/
//		Student[] uc = readStudentsFromFile("uc_students.txt", 350000);
//		Student[] smc = readStudentsFromFile("smc_grads.txt", 75000);
//		final int SMC_UC_GradsNumber = 25000;

		long start, end;

		start = System.currentTimeMillis();
		Student[] common1 = findCommonStudents1(uc, smc, SMC_UC_GradsNumber);
		end = System.currentTimeMillis();
		System.out.println("Cross checking took " + (end - start) / 1000.0
				+ " seconds.");
		Arrays.sort(common1);
		writeStudentsToFile(common1, "smc_grads_at_uc_1.txt");

		start = System.currentTimeMillis();
		Student[] common2 = findCommonStudents2(uc, smc, SMC_UC_GradsNumber);
		end = System.currentTimeMillis();
		System.out.println("Using binary search it took " + (end - start)
				/ 1000.0 + " seconds.");
		Arrays.sort(common2);
		writeStudentsToFile(common2, "smc_grads_at_uc_2.txt");
		
	}

}
