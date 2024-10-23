package studio6;

import edu.princeton.cs.introcs.StdDraw;

public class RecursiveMethods {

	/**
	 * Computes the geometric sum for the first n terms in the series
	 * 
	 * @param n the number of terms to include in the sum
	 * @return the sum of the first n terms of the geometric series (1/2 + 1/4 + 1/8
	 *         ...)
	 */
	public static double geometricSum(int n) {
		if (n == 0) {
			return 0;
		}
		else { 
			return (1 / Math.pow(2, n)) + geometricSum(n - 1); 
		}
	}

	/**
	 * @param xCenter                       x-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param yCenter                       y-coordinate of the center of the circle
	 *                                      at the current depth
	 * @param radius                        radius of the circle at the current
	 *                                      depth
	 * @param radiusMinimumDrawingThreshold radius above which drawing should occur
	 */
	public static void circlesUponCircles(double xCenter, double yCenter, double radius,
			double radiusMinimumDrawingThreshold) {

		if (radius < radiusMinimumDrawingThreshold) {
			return;  
		} else {
			double bound = 5.0;
			StdDraw.setXscale(-bound,bound);
			StdDraw.setYscale(-bound,bound);
			StdDraw.circle(xCenter,yCenter,radius);
			
			 
			circlesUponCircles(xCenter + radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter - radius,yCenter,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter + radius,radius/3.0,radiusMinimumDrawingThreshold);
			circlesUponCircles(xCenter,yCenter - radius,radius/3.0,radiusMinimumDrawingThreshold);
		}
		
		// FIXME
	}

	/**
	 * This method uses recursion to create a reverse of the given array
	 * 
	 * @param array the array to create a reverse of, not to be mutated
	 * @return an array with the same data as the input but it reverse order
	 */
	public static int[] toReversed(int[] array) {
		int[] reverse = new int[array.length];
		if (array.length > 0) {
			return toReverseHelper(array, reverse, 0);
		}
		else {
			return reverse;
		}
		// FIXME create a helper method that can recursively reverse the given array

	}
	
	public static int[] toReverseHelper (int[] array, int[] reverse, int i) {
		if (i > array.length / 2) {
			return reverse;
		}
		else {
			int a = array.length - 1 - i;
			reverse[i] = array[a];  
			reverse[a] = array[i];
			return toReverseHelper(array, reverse, i + 1); 
		}
	}

	/**
	 * This method uses recursion to compute the greatest common divisor
	 * for the two input values
	 * 
	 * @param p first operand
	 * @param q second operand
	 * @return greatest common divisor of p and q
	 */
	public static int gcd(int p, int q) {
        int i = 1;
        
		if (q == 0) {
			return p; 
		}
		
		else { 
			return gcd(q, p%q);
				
		}
		// FIXME compute the gcd of p and q using recursion
		

	}
	

}
