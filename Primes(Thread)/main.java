//imports
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


class Prime implements Runnable {
	static AtomicBoolean flag = new AtomicBoolean(false); // a boolean flag to run a piece of code once
	final public static int n = 100000000;  //100 million hard coded for simplicity 
	static int counter = 3; //by starting with three and incrementing by 2, we save time as we exclude all even numbers
	static TreeSet<Integer> primes = new TreeSet<>(); // a data structure to hold the prime numbers we find
													  // I chose a tree set because it is a sorted set, 
													// so I can fetch the last ten numbers easily.
	static boolean isNotPrime[] = new boolean [n + 1]; //for the sieve
	int number = 0;  // field for the thread object
	
	// this synchronized method is to assign a number to a thread
	// and to increment a static variable to be ready for the next thread
	public synchronized void getAndIncrement() {
		this.number = counter;
		counter += 2;
	}

	// this method is a sieve that will exclude the multiples of a prime number
	public void setPrime(int x) {
		if ( x <= n) {
			if (isNotPrime[x] == false) {
				for (int i = x * 2; i < n; i += x) {
					isNotPrime[i] = true;
				}
			}
		}
	}
	
	// the main method for thread
	@Override
	public void run() {
		// set a flag to be run only once
		// this will add 2 to the list of the prime numbers
		// and will exclude all the even numbers to cut time
		if (!flag.getAndSet(true)) {
			primes.add(2);
			for (int i = 2; i <= n; i += 2) {
				isNotPrime[i] = true;
			}
		}
		// every thread will pick a number and set if it is prime or not
		while (counter < n) {
			getAndIncrement();
			setPrime(this.number);
		}
	}

}
public class main {

	public static void main(String[] args) throws FileNotFoundException {
		long sum = 0; // to get the sum of all the prime numbers
		long start = System.currentTimeMillis();  // the start of calculating the time
		// creating an array list of thread objects
		ArrayList<Thread> threads = new ArrayList<>(); 
		for (int i = 0; i < 8; i++) threads.add(new Thread(new Prime())); 

		//starting the threads
		for (int i = 0; i < 8; i++) threads.get(i).start();
		
		// joining the threads
		for (int i = 0; i < 8; i++) {
			try {
				threads.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// the end of the calculation when all of the threads are terminated
		long finish = System.currentTimeMillis();
		float timeElapsed = (float)(finish - start) / 1000;  

		// adding the prime numbers to the tree set
		for (int i = 3; i < Prime.n; i += 2) {
			if (Prime.isNotPrime[i] == false) {
				Prime.primes.add(i);
			}
		}

		
		int size = Prime.primes.size();
		for (Integer number: Prime.primes) sum += number;


		// fetching the last ten prime numbers
		TreeSet<Integer> lastTen = new TreeSet<>();
		for (int i = 0; i < 10; i++) lastTen.add(Prime.primes.pollLast());

		
		
		// printing the results to the console and to the output.txt file
		FileOutputStream output = new FileOutputStream("primes.txt");
		PrintWriter pw = new PrintWriter(output);

		pw.print(timeElapsed + " "); System.out.print(timeElapsed + " ");
		pw.print(size +  " ");       System.out.print(size + " ");
		pw.println(sum);             System.out.println(sum);
		for (Integer number: lastTen) {
			System.out.printf("%d  ", number);
			pw.print(number + " ");
		}
		pw.println();
		System.out.println();
		pw.flush();
		pw.close();

	}

}
//the results just to make sure I got the right 
//5,761,455  number of prime numbers
//279209790387276   // sum of prime numbers

