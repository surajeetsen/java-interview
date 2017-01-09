package bitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * 
 * Given two integers x and y, calculate the Hamming distance.
 * 
 * https://leetcode.com/problems/hamming-distance/
 * 
 * @author Surajeet Sen
 */
public class HammingDistance {

	public static void main(String[] args) {
		HammingDistance hd = new HammingDistance();
		System.out.println(hd.getHammingDistance(1, 4));
	}

	public int getHammingDistance(int x, int y) {
		int num = x ^ y;
		int count = 0;

		while (num != 0) {
			if ((num & 1) == 1) {
				++count;
			}
			num = num >> 1;
		}

		return count;
	}
}
