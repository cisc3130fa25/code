package A_intro;

public class ArrayUtils {
    /**
     * Returns the maximum element of a.
     * @param a an array
     * @return the max
     * @throws IllegalArgumentException if a is empty
     */
    public static double max(double[] a) {
        // note that we throw an exception to enforce the
        // method's precondition: something that needs to
        // be true in order for the method to work properly
        if (a.length == 0) {
            throw new IllegalArgumentException("empty array");
        }

        double maxSoFar = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > maxSoFar) {
                maxSoFar = a[i];
            }
        }

        return maxSoFar;
    }
}
