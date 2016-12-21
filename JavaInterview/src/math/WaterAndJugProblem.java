package math;

/**
 * From the Die-hard 3 movie (https://www.youtube.com/watch?v=BVtQNK_ZUJg)
 * 
 * You are given two jugs with capacities x and y litres. There is an infinite
 * amount of water supply available. You need to determine whether it is
 * possible to measure exactly z litres using these two jugs.
 * 
 * If z liters of water is measurable, you must have z liters of water contained
 * within one or both buckets by the end.
 * 
 * Operations allowed: 
 * -> Fill any of the jugs completely with water.
 * 
 * -> Empty any of the jugs.
 * 
 * -> Pour water from one jug into another till the other jug is completely full or
 *    the first jug itself is empty.
 * 
 * https://leetcode.com/problems/water-and-jug-problem/
 * 
 * @author Surajeet Sen
 */
public class WaterAndJugProblem {

	public boolean canMeasureWater(int x, int y, int z) {
		if (((x == 0 || y == 0) && (z != 0)) || (z > (x + y))) {
			return false;
		}

		if ((z == 0) || (z % getGcd(x, y)) == 0) {
			return true;
		}

		return false;
	}

	private int getGcd(int x, int y) {
		if (y == 0) {
			return x;
		}
		return getGcd(y, x % y);
	}

	public static void main(String[] args) {
		WaterAndJugProblem waj = new WaterAndJugProblem();
		System.out.println(waj.canMeasureWater(3, 5, 4));
	}

}
