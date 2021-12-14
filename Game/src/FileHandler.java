import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;


// the generic file handler class
// i for integers, d for doubles, s for Strings, c for characters
// I was planning to create only 6 variables, but i failed to  create loops to work with all this data types.
// so I figured out that I will create a variable for every word in the file 
// it will be longer, but it will do the job.
public class FileHandler <i,d,s,c> {

	 
	 Scanner file;
	 Formatter format;
	 Formatter output;
	 
	// Q stands for question, A is for Answer.
	// 1,2,3,4 ...... stands for the question number.
	// abcd .... stands for the 4 choices we have for each question
	// A1a, A2a , A3a..... will always hold the right answer
	 
	 
	d Q1a;
	i Q1b;
	d A1a;
	i A1b;
	i A1c;
	i A1d;
	
	d Q2a;
	d Q2b;
	i A2a;
	d A2b;
	i A2c;
	i A2d;
	
	s Q3a;
	s Q3b;
	s A3a;
	s A3b;
	s A3c;
	s A3d;
	
	c Q4a;
	c Q4b;
	s A4a;
	s A4b;
	i A4c;
	i A4d;
	
	i Q5a;
	i Q5b;
	i A5a;
	i A5b;
	i A5c;
	i A5d;
	
	s Q6a;
	s Q6b;
	s A6a;
	i A6b;
	d A6c;
	i A6d;
	
	s Q7a;
	s Q7b;
	s A7a;
	s A7b;
	s A7c;
	s A7d;
	
	s Q8a;
	i Q8b;
	s A8a;
	d A8b;
	i A8c;
	i A8d;
	
	s Q9a;
	s Q9b;
	s A9a;
	s A9b;
	s A9c;
	s A9d;
	
	i Q10a;
	i Q10b;
	i A10a;
	i A10b;
	i A10c;
	i A10d;
	
	// setters and getters
	public d getQ1a() {
		return Q1a;
	}
	public i getQ1b() {
		return Q1b;
	}
	public d getA1a() {
		return A1a;
	}
	public i getA1b() {
		return A1b;
	}
	public i getA1c() {
		return A1c;
	}
	public i getA1d() {
		return A1d;
	}
	public d getQ2a() {
		return Q2a;
	}
	public d getQ2b() {
		return Q2b;
	}
	public i getA2a() {
		return A2a;
	}
	public d getA2b() {
		return A2b;
	}
	public i getA2c() {
		return A2c;
	}
	public i getA2d() {
		return A2d;
	}
	public s getQ3a() {
		return Q3a;
	}
	public s getQ3b() {
		return Q3b;
	}
	public s getA3a() {
		return A3a;
	}
	public s getA3b() {
		return A3b;
	}
	public s getA3c() {
		return A3c;
	}
	public s getA3d() {
		return A3d;
	}
	public c getQ4a() {
		return Q4a;
	}
	public c getQ4b() {
		return Q4b;
	}
	public s getA4a() {
		return A4a;
	}
	public s getA4b() {
		return A4b;
	}
	public i getA4c() {
		return A4c;
	}
	public i getA4d() {
		return A4d;
	}
	public i getQ5a() {
		return Q5a;
	}
	public i getQ5b() {
		return Q5b;
	}
	public i getA5a() {
		return A5a;
	}
	public i getA5b() {
		return A5b;
	}
	public i getA5c() {
		return A5c;
	}
	public i getA5d() {
		return A5d;
	}
	public s getQ6a() {
		return Q6a;
	}
	public s getQ6b() {
		return Q6b;
	}
	public s getA6a() {
		return A6a;
	}
	public i getA6b() {
		return A6b;
	}
	public d getA6c() {
		return A6c;
	}
	public i getA6d() {
		return A6d;
	}
	public s getQ7a() {
		return Q7a;
	}
	public s getQ7b() {
		return Q7b;
	}
	public s getA7a() {
		return A7a;
	}
	public s getA7b() {
		return A7b;
	}
	public s getA7c() {
		return A7c;
	}
	public s getA7d() {
		return A7d;
	}
	public s getQ8a() {
		return Q8a;
	}
	public i getQ8b() {
		return Q8b;
	}
	public s getA8a() {
		return A8a;
	}
	public d getA8b() {
		return A8b;
	}
	public i getA8c() {
		return A8c;
	}
	public i getA8d() {
		return A8d;
	}
	public s getQ9a() {
		return Q9a;
	}
	public s getQ9b() {
		return Q9b;
	}
	public s getA9a() {
		return A9a;
	}
	public s getA9b() {
		return A9b;
	}
	public s getA9c() {
		return A9c;
	}
	public s getA9d() {
		return A9d;
	}
	public i getQ10a() {
		return Q10a;
	}
	public i getQ10b() {
		return Q10b;
	}
	public i getA10a() {
		return A10a;
	}
	public i getA10b() {
		return A10b;
	}
	public i getA10c() {
		return A10c;
	}
	public i getA10d() {
		return A10d;
	}
	
	
	public void setQ1a(d q1a) {
		Q1a = q1a;
	}
	public void setQ1b(i q1b) {
		Q1b = q1b;
	}
	public void setA1a(d a1a) {
		A1a = a1a;
	}
	public void setA1b(i a1b) {
		A1b = a1b;
	}
	public void setA1c(i a1c) {
		A1c = a1c;
	}
	public void setA1d(i a1d) {
		A1d = a1d;
	}
	public void setQ2a(d q2a) {
		Q2a = q2a;
	}
	public void setQ2b(d q2b) {
		Q2b = q2b;
	}
	public void setA2a(i a2a) {
		A2a = a2a;
	}
	public void setA2b(d a2b) {
		A2b = a2b;
	}
	public void setA2c(i a2c) {
		A2c = a2c;
	}
	public void setA2d(i a2d) {
		A2d = a2d;
	}
	public void setQ3a(s q3a) {
		Q3a = q3a;
	}
	public void setQ3b(s q3b) {
		Q3b = q3b;
	}
	public void setA3a(s a3a) {
		A3a = a3a;
	}
	public void setA3b(s a3b) {
		A3b = a3b;
	}
	public void setA3c(s a3c) {
		A3c = a3c;
	}
	public void setA3d(s a3d) {
		A3d = a3d;
	}
	public void setQ4a(c q4a) {
		Q4a = q4a;
	}
	public void setQ4b(c q4b) {
		Q4b = q4b;
	}
	public void setA4a(s a4a) {
		A4a = a4a;
	}
	public void setA4b(s a4b) {
		A4b = a4b;
	}
	public void setA4c(i a4c) {
		A4c = a4c;
	}
	public void setA4d(i a4d) {
		A4d = a4d;
	}
	public void setQ5a(i q5a) {
		Q5a = q5a;
	}
	public void setQ5b(i q5b) {
		Q5b = q5b;
	}
	public void setA5a(i a5a) {
		A5a = a5a;
	}
	public void setA5b(i a5b) {
		A5b = a5b;
	}
	public void setA5c(i a5c) {
		A5c = a5c;
	}
	public void setA5d(i a5d) {
		A5d = a5d;
	}
	public void setQ6a(s q6a) {
		Q6a = q6a;
	}
	public void setQ6b(s q6b) {
		Q6b = q6b;
	}
	public void setA6a(s a6a) {
		A6a = a6a;
	}
	public void setA6b(i a6b) {
		A6b = a6b;
	}
	public void setA6c(d a6c) {
		A6c = a6c;
	}
	public void setA6d(i a6d) {
		A6d = a6d;
	}
	public void setQ7a(s q7a) {
		Q7a = q7a;
	}
	public void setQ7b(s q7b) {
		Q7b = q7b;
	}
	public void setA7a(s a7a) {
		A7a = a7a;
	}
	public void setA7b(s a7b) {
		A7b = a7b;
	}
	public void setA7c(s a7c) {
		A7c = a7c;
	}
	public void setA7d(s a7d) {
		A7d = a7d;
	}
	public void setQ8a(s q8a) {
		Q8a = q8a;
	}
	public void setQ8b(i q8b) {
		Q8b = q8b;
	}
	public void setA8a(s a8a) {
		A8a = a8a;
	}
	public void setA8b(d a8b) {
		A8b = a8b;
	}
	public void setA8c(i a8c) {
		A8c = a8c;
	}
	public void setA8d(i a8d) {
		A8d = a8d;
	}
	public void setQ9a(s q9a) {
		Q9a = q9a;
	}
	public void setQ9b(s q9b) {
		Q9b = q9b;
	}
	public void setA9a(s a9a) {
		A9a = a9a;
	}
	public void setA9b(s a9b) {
		A9b = a9b;
	}
	public void setA9c(s a9c) {
		A9c = a9c;
	}
	public void setA9d(s a9d) {
		A9d = a9d;
	}
	public void setQ10a(i q10a) {
		Q10a = q10a;
	}
	public void setQ10b(i q10b) {
		Q10b = q10b;
	}
	public void setA10a(i a10a) {
		A10a = a10a;
	}
	public void setA10b(i a10b) {
		A10b = a10b;
	}
	public void setA10c(i a10c) {
		A10c = a10c;
	}
	public void setA10d(i a10d) {
		A10d = a10d;
	}
	
	// opens the (input.txt) file to extract data from it.
	public  void openFile(String filePath){
		try {
	 file = new Scanner(new File(filePath));
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	// assigning each word in the txt file to its corresponding variable
	public String assignVar() {
		return file.next();
	}
	
	// closes the file
	public void closeFile() {
		file.close();
	}
	
	// creates a new file
	public void createFile() {
		try {
			format = new Formatter("Score Board.txt");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// adds data to a file then closed it
	public void addDataToFile() {
		try {
			output = new Formatter("Hall of Fame.txt");
			output.format("%s", DataBase.showScore());
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("error outputfile");
		}
		finally {
			output.close();
		}
		
	}
}
