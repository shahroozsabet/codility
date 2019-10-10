package alten3;

/**
 * Given a list with the mean temperature per day,
 * find the longest consecutive sequence of days
 * where the temperature stays within five degrees.
 * In other words the maximum temperature
 * within the sequence minus the minimum temperature
 * within the sequence must not be greater than five.
 * All mean temperatures have integer values.
 * Created by shsabet on 1/23/2019.
 */
interface SolutionInterface {

    /**
     * Return the start day for the longest sequence of days where the mean temperature
     * is within five degrees.
     */
    void getStartDay(int[] arr);

    /**
     * Return the end day for the longest sequence of days where the mean temperature
     * is within five degrees.
     * <p>
     * Note that the start and end day of the sequence may be
     * the same.
     */
    int getEndDay(int[] arr);

}
