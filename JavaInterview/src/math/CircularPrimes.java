package math;

import java.util.ArrayList;
import java.util.List;

/**
 * A circular prime is a prime number with the property that the number
 * generated at each intermediate step when cyclically permuting its (base 10)
 * digits will be prime. For example 1193 is a circular prime, since 1931, 9311
 * and 3119 all are also prime.
 * 
 * @author Surajeet Sen
 */
public class CircularPrimes {

	private int n;
	
	public CircularPrimes() {
		this.n = 100;
	}
	
	public CircularPrimes(int n) {
		this.n = n;
	}
	
	private List<Integer> getCircularPrimes(List<Integer> primes) {
		List<Integer> circularPrimes = new ArrayList<Integer>();
		for (int item : primes) {
			boolean isCircularPrime = true;
			int temp = getCircularRotation(item);
			
			while(temp != item) {
				if(temp > n) {
					if(!isPrime(temp)) {
						isCircularPrime = false;
						break;
					}
				} else {
					if(!primes.contains(temp)) {
						isCircularPrime = false;
						break;
					}
				}
				temp = getCircularRotation(temp);
			}
			
			if(isCircularPrime) {
				circularPrimes.add(item);
			}
		}
		
		return circularPrimes;
	}

	private boolean isPrime(int num) {
		boolean isPrime = true;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	private int getCircularRotation(int num) {
		int unitPlace = num % 10;
		num = num / 10;
		int temp = 1;
		while (num / temp != 0) {
			temp = temp * 10;
		}
		int number = unitPlace * temp + num;
		return number;
	}
	
	public static void main(String[] args) {
		int n = 10000; //The number until which circular primes are to be printed
		List<Integer> primes = new SievePrimeGenerator(n).getPrimes();
		List<Integer> circularPrimes = new CircularPrimes(n).getCircularPrimes(primes);
		System.out.println(circularPrimes);
	}
	
}