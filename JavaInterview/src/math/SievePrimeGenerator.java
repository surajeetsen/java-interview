package math;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Sieve Algorithm for generating prime numbers.
 * 
 * @author Surajeet Sen
 */
public class SievePrimeGenerator {
	private int N;

	public SievePrimeGenerator() {
		N = 50; //If a number is not passed, primes upto 50 is calculated by default
	}

	public SievePrimeGenerator(int N) {
		this.N = N;
	}

	public List<Integer> getPrimes() {
		List<Integer> primeList = new ArrayList<>();
		boolean[] isPrime = new boolean[N + 1];
		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= N; i++) {
			if (isPrime[i]) {
				for (int j = i; i * j <= N; j++) {
					isPrime[i * j] = false;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				primeList.add(i);
			}
		}
		
		return primeList;
	}

	public static void main(String[] args) {
		SievePrimeGenerator spg = new SievePrimeGenerator();
		System.out.println(spg.getPrimes());
	}
}
