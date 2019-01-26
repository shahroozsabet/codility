package example;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by shsabet on 1/23/2019.
 */
public class SolutionImpl implements Solution {

    public int binaryGap1(int N) {
        int quot, i = 1, j;
        int[] bin_num = new int[100];

        quot = N;

        while (quot != 0) {
            bin_num[i++] = quot % 2;
            quot = quot / 2;
        }
        StringBuilder binary_str = new StringBuilder();
        System.out.print("Binary number of " + N + " is: ");
        for (j = i - 1; j > 0; j--) {
            binary_str.append(bin_num[j]);
        }
        System.out.println(binary_str);
        i = binary_str.length() - 1;
        while (binary_str.charAt(i) == '0') {
            i--;
        }
        int length = 0;
        int ctr = 0;
        for (; i >= 0; i--) {
            if (binary_str.charAt(i) == '1') {
                length = Math.max(length, ctr);
                ctr = 0;
            } else {
                ctr++;
            }
        }
        return Math.max(length, ctr);
    }

    @Override
    public int binaryGap2(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(N + " in binary is " + binary);
        int length = 0;
        int index = 0;

        for (int i = 0; i < binary.length(); i = index) {
            int start = binary.indexOf('0', index);
            if (start < 0) break; // stopping condition

            int end = binary.indexOf('1', start) - 1;
            if (end < 0) break; // ignore trailing zeroes

//            System.out.println("Start = " + start);
//            System.out.println("End = " + end);
//            System.out.println("Temp = " + (end - start));
//            System.out.println("Length = " + length);

            int temp = end - start + 1;
            if (temp > length) length = temp;
            index = end + 1;
        }

        return length;
    }

    public int oddOccurrencesInArray(int[] A) {
        return Arrays.stream(A).reduce(0, (a, b) -> a ^ b);
    }

    @Override
    public int[] cyclicRotation(int[] A, int K) {
        int N = A.length;
        if (N == 0)
            return A;
        if (K >= N)
            K %= N;
        if (K == 0)
            return A;
        int[] rotA = new int[N];
        for (int i = 0; i < N; i++)
            rotA[i] = (i < K) ? A[N + i - K] : A[i - K];
        return rotA;
    }

    @Override
    public int frogJmp(int X, int Y, int D) {
        int steps = (Y - X) / D;
        int extras = (Y - X) % D > 0 ? 1 : 0;
        return steps + extras;
    }

    @Override
    public int permMissingElem(int[] A) {
        long N = A.length + 1;
        long sum = N * (N + 1) / 2;
        for (int i1 : A) sum -= i1;
        return (int) sum;
    }

    @Override
    public int tapeEquilibrium(int[] A) {
        //Base Case
        long lsum = A[0]; //Set Left Sum Equal to First Element
        long rsum; //Set Right Sum Equal to Zero
        long diff; //Variable to Hold Difference

        //Set Right Sum to Sum of Rest of Values in Array
        rsum = Arrays.stream(A, 1, A.length).sum();

        diff = Math.abs(lsum - rsum); //Set Diff Equal to Absolute Difference of Left and Right Sums

        //If More Elements
        if (A.length > 2) {
            //Update Left and Right Sums, and Difference (If Necessary)
            for (int P = 1; P < A.length - 1; P++) {
                lsum += A[P];
                rsum -= A[P];

                long tmp = Math.abs(lsum - rsum);

                if (tmp < diff) //If Smaller, Update Difference
                {
                    diff = tmp;
                }
            }
        }

        return (int) diff; //Return diff as Integer
    }

    @Override
    public int permCheck(int[] A) {
        boolean[] seen = new boolean[A.length + 1];

        // repeated elements
        for (int i1 : A) {
            if (i1 < 1 || i1 > A.length || seen[i1]) return 0;
            seen[i1] = true;
        }

        return 1;
    }

    @Override
    public int frogRiverOne(int X, int[] A) {
        HashSet<Integer> fallen = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X)
                fallen.add(A[i]);

            if (fallen.size() == X)
                return i;
        }

        return -1;
    }

    @Override
    public int missingInteger(int[] A) {
        HashSet<Integer> seen = new HashSet<>();
        int min = 1;

        for (int i1 : A) {
            if (i1 > 0) seen.add(i1);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!seen.contains(i)) return i;
        }

        return min;

    }

    @Override
    public int[] maxCounter(int N, int[] A) {
        int max = 0;
        int lastMax = 0;
        int[] counters = new int[N];

        for (int i1 : A) {
            if (i1 >= 1 && i1 <= N) {
                // this is instead of the nested loop in solution2
                counters[i1 - 1] = Math.max(counters[i1 - 1], lastMax);
                counters[i1 - 1] += 1;
                max = Math.max(max, counters[i1 - 1]);
            } else if (i1 == N + 1) {
                lastMax = max;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }

    @Override
    public int passingCars(int[] A) {
        int passing = 0; //Integer to Hold Number of Cars Passing
        int zeros = 0; //Integer to Keep Count of Cars Going East
        int sum = 0; //Interger to Hold Sum of Array

        //Edge Case
        if (A.length <= 1)
            return 0; //Only One Element Means No Passing

        //If Here, Then More Than One Element, Worth Traversing Through Array
        for (int i1 : A) {
            sum += i1; //Update Sum

            if (i1 == 0) //If Going East, Update Zero Count
                zeros++;
            else //If Going West, Car Will Pass All Cars Previous Cars Going East
            {
                passing += zeros; //Increment passing by Current Numbers of East Cars

                if (passing > 1000000000) //Check If passing Exceeds Allowed Max
                    return -1; //Return -1 If So

                /*
                 * With Given Edges of Problem, Zero Count Will be 100,000 at Max
                 * Meaning passing Cannot Jump From Allowed Max to A Number Greater Than the Integer Max
                 * So Value of passing Will Never Become Too Big and Turn Into Negative
                 */
            }

        }

        //Another Edge Case
        //Return Value
        //If All Array Values are the Same
        return sum == 0 || sum == A.length ? 0 : passing; //All the Same Values Means No Passing

    }

    //region genomicRangeQuery
    // @Override
    public int[] genomicRangeQuery(String S, int[] P, int[] Q) {

        boolean same = true; //Whether or Not Sequence is Filled With Same Character
        int N = S.length(); //Length of Sequence
        int M = P.length; //Number of Queries
        int[] impacts = new int[M]; //Array of Minimal Impact Factors

        //Edge Cases
        if (N > 1) //If More Than 1 Nucleotide in Sequence
        {
            //Check if Array is Sequence is Repetition of Single Nucleotide
            same = IntStream.range(1, S.length()).noneMatch(i -> S.charAt(i) != S.charAt(0));
        }
        if (same) //If Only One Distinct Nucleotide
            Arrays.fill(impacts, convert(S.charAt(0))); //Set All Impacts to Impact Factor of Nucleotide
        else {
            int minFactPos = minNucl(S); //Position of Minimum Impact Factor of Whole Sequence
            int[][] ps = new int[N][4]; //Matrix of Prefix Sums of Each Nucleotide

            //Initialize Matrix
            //Mark Location of Every Nucleotide
            IntStream.range(0, N).forEach(i -> ps[i][convert(S.charAt(i)) - 1] = 1);
            for (int i = 1; i < N; i++) //Fill Matrix With Prefix Sums
            {
                for (int j = 0; j < 4; j++)
                    ps[i][j] += ps[i - 1][j];
            }
            for (int K = 0; K < M; K++) {
                int x = P[K]; //Staring Value in Range
                int y = Q[K]; //Ending Value in Range

                //Edge Cases
                if (x == y) //If Same Position to Look at in Sequence (Same Nucleotide)
                {
                    impacts[K] = convert(S.charAt(x)); //Fill Position of Impacts With Impact Factor of Nucleotide
                    continue; //Goto Next Iteration of For Loop
                }
                if (x <= minFactPos && y >= minFactPos) //If Range Includes Minimum Factor's Position
                {
                    impacts[K] = convert(S.charAt(minFactPos)); //Fill Position of Impacts With Minimum Impact Factor of Whole Sequence
                    continue; //Goto Next Iteration of For Loop
                }
                ///*
                for (int j = 0; j < 4; j++) //General Case
                {
                    //For Each Query, Check Each Nucleotide From Minimum
                    //If it Exists Between Range, Mark as Minimum Factor
                    int subt = 0;

                    if (x > 0) //If Starting Range Value is Not First Index
                        subt = ps[x - 1][j]; //Get Count of Nucleotide Appearances Before Staring Value
                    if (ps[y][j] - subt > 0) //Subtract Amount Before Starting Value, If More Than Zero
                    {
                        impacts[K] = j + 1; //Must be Minimum
                        break; //Onto the Next Query
                    }
                }
                //*/
                //impacts[K] = convert(S.charAt(minNucl(S.substring(x, y+1)))); Easy Version, But Makes the Runtime O(N*M)
            }
        }

        return impacts; //Return Array
    }

    private int convert(char c) //Function to Convert Nucleotide to Impact Factor
    {
        switch (c) //Depending on Passed Character, Return Integer
        {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                return -1; //Invalid Nucleotide Character
        }
    }

    private int minNucl(String S) //Function to Find Minimum Nucleotide Factor in Sequence
    {
        //Search if Sequence Contains Minimum Possible Factor, If Not, Check Next Possible Minimum
        if (S.contains("A"))
            return S.indexOf('A');
        if (S.contains("C"))
            return S.indexOf('C');
        if (S.contains("G"))
            return S.indexOf('G');
        if (S.contains("T"))
            return S.indexOf('T');

        return -1; //No Valid Nucleotide Characters in Sequence
    }
    //endregion genomicRangeQuery

    @Override
    public int minAvgTwoSlice(int[] A) {
        //Edge Cases
        int N = A.length;
        //Check if Array is Filled With Same Value
        if (IntStream.range(1, N).noneMatch(i -> A[i] != A[0])) //If So, Return 0
            return 0;
        double avg; //Current Average
        double minAvg = (A[0] + A[1]) / 2.0; //Minimum Average, Initialize to Average of Slice of First Two Elements
        int minAvgInd = 0; //Position of Minimum Average, Initialize to First Position
        for (int i = 0; i < N - 2; i++) //Check From First to Penultimate Element
        {
            //Check Next Two Element Slice
            avg = (A[i] + A[i + 1]) / 2.0; //Get Current Average

            if (avg < minAvg) //If Current Average is Less Than Minimum
            {
                minAvg = avg; //Replace Minimum Average
                minAvgInd = i; //Replace Position
            }

            //Check Next Three Element Slice
            avg = (A[i] + A[i + 1] + A[i + 2]) / 3.0; //Get Current Average

            if (avg < minAvg) //If Current Average is Less Than Minimum
            {
                minAvg = avg; //Replace Minimum Average
                minAvgInd = i; //Replace Position
            }
        }

        //Check Slice of Last Two Elements
        avg = (A[N - 1] + A[N - 2]) / 2.0; //Get Average of Slice

        if (avg < minAvg) //If Current Average is Less Than Minimum
        {
            minAvgInd = N - 2; //Replace Position
        }

        return minAvgInd; //Return Position
    }

    @Override
    public int countDiv(int A, int B, int K) {
        //Edge Cases
        if (A == B && K != 1) //If No Range, Only One Number
        {
            if (A % K == 0) //If Number is Divisible by K
                return 1; //return 1

            return 0; //Else Return 0
        } else if (K == 1) //If K is One
            return B - A + 1; //Return Count for Simple Case

        int count = ((B - A) / K) + 1; //Get Count of Integers Divisible by K for General Case
        boolean lbA = (A & 1) == 1; //Check Last Bit, True if A is Odd, False if Even
        boolean lbB = (B & 1) == 1; //Check Last Bit, True if B is Odd, False if Even
        boolean lbK = (K & 1) == 1; //Check Last Bit, True if K is Odd, False if Even

        if (lbA && lbB && !lbK) //Check for Special Case, A and B are Odd, K is Even
            count--; //Decrement Count If So

        return count; //Return Count Value
    }

    @Override
    public int distinct(int[] A) {
        if (A.length < 2) //If Less Than Two Elements
            return A.length; //Return Number of Elements

        //int M; //For Range of Elements
        int N = A.length; //Length of Array
        int min = A[0]; //Minimum Value in Array
        int max = A[0]; //Maximum Value in Array

        for (int i = 1; i < N; i++) //Loop Through Array, Get Minimum and Max
        {
            if (A[i] < min)
                min = A[i];
            else if (A[i] > max)
                max = A[i];
        }
        //Array of Counters
        int[] count = new int[max - min + 1]; //Set Size of Counters Array to Range of Elements
        //M = count.length; //Length of Counters Array

        int dc = 0; //Number of Distinct Values
        for (int i1 : A) {
            int tmp = ++count[i1 - min]; //Increment Count of Number in Respective Position in Counters
            ///*
            if (tmp == 1) //If Count of Current Element is 1 (Was Zero Before)
                dc++; //New Distinct Element, Increment Counter of Distinct Elements
            //*/
        }
        /*
        for (int i=0; i<M; i++) //Loop Through Array of Counters, This Would Make the Runtime O(N+M)
        {
            if (count[i]!=0) //If Count of Element Isn't Zero
                dc++; //New Distinct Element, Increment Counter of Distinct Elements
        }
        */
        return dc; //Return Count of Distinct Elements
    }

    @Override
    public int maxProductOfThree(int[] A) {
        //Edge Case
        if (A.length == 3) //If Only Three Element
            return (A[0] * A[1] * A[2]); //Return Product of Array Elements

        int N = A.length; //Length of Array
        int min = A[0]; //Minimum Value in Array
        int max = A[0]; //Maximum Value in Array

        for (int i = 1; i < N; i++) //Loop Through Array, Get Minimum and Max
        {
            if (A[i] < min)
                min = A[i];
            else if (A[i] > max)
                max = A[i];
        }

        if (max == 0) //If Max Element is Zero
            return 0; //Return Zero Because All Other Options Are Negative

        //Array of Counters
        int[] count = new int[max - min + 1]; //Set Size of Counters Array to Range of Elements

        for (int i1 : A) count[i1 - min]++; //Increment Count of Number in Respective Position in Counters Array

        int t = 0; //For Traversing Array of Counters

        for (int i = 0; i < N; ) //Sort Array Using Counters
        {
            while (count[t] == 0)
                t++;
            for (int j = 0; j < count[t]; j++)
                A[i++] = t + min;

            t++;
        }

        //Product of Elements
        int prod = A[N - 1]; //Start Product at Value of Last Element

        if (A[1] > 0 || prod < 0) //General Case, Last Two Elements Aren't Negative, or Max is Negative
            prod *= A[N - 2] * A[N - 3]; //Max Product is Product of Last Three Elements
        else //Special Case, If Second Element is Negative and Max Isn't
            prod *= Math.max(A[0] * A[1], A[N - 2] * A[N - 3]); //Multiply by Bigger Value, Product of First Two or Second to Last Two Elements

        return prod; //Return Product
    }

    //region triangle
    @Override
    public int triangle(int[] A) {
        if (possTriangle(A)) {
            System.out.println("Triangle is Possible With Given Edges");
            return 1;
        } else {
            System.out.println("Triangle isn't Possible With Given Edges");
            return 0;
        }
    }

    private boolean possTriangle(int[] A) //Determine if Triangle is Possible
    {
        int N = A.length; //Get Length

        if (N < 3) //If Less Than Three Elements, Automatically Impossible
            return false;
        else if (N == 3) //If Exactly Three
        {
            if (A[0] < 1 || A[1] < 1 || A[2] < 1) //If Any are at Least Zero
                return false; //Triangle Impossible
            if ((long) A[0] + A[1] <= A[2]) //If Sum of any Two Sides Not Greater Than Third
                return false; //Triangle Impossible
            if ((long) A[1] + A[2] <= A[0])
                return false;
            return (long) A[0] + A[2] > A[1];//If Reached Here, Triangle is Possible
        }
        /*
         * If You Know the Order of the Three Numbers From Min to Max, Example: X<=Y<=Z,
         * You Only Need to Check if X+Y>Z, Since Z is Max it's Sum Will be Valid With
         * Any of the Other Sides
         */
//        try //Try Sorting Using Quicker Method
//        {
//            //Class That Sorts Using Counters
//            A = sortArray(A); //Sort Using Array of Counters, Makes Program O(N+M)
//        } catch (java.lang.OutOfMemoryError e) //If Exceeds Memory Space Limit
//        {
        Arrays.sort(A);
//        } //Sort Using Built in Function, Makes Program O(N*log(N))
        if (A[N - 3] < 1) //If At Most Two Elements Greater Than Zero
            return false; //Triangle Impossible
        for (int i = N - 3; i > 0; i--) //From Third To Last Element, to Zero
        {
            if (A[i] < 1) //If Element is Less Than 1
                break; //Stop Looking
            if ((long) A[i] + A[i + 1] > A[i + 2]) //Sum of Smaller Two Edges is Greater Than Biggest of Three
                return true; //Triangle Possible
        }

        return false; //If Reached Here, Triangle Not Possible
    }

    private int[] sortArray(int[] A) {
        boolean sort = true; //To Check If Array is Already Sorted
        int N = A.length; //Length of Array
        int min = A[0]; //Minimum Value in Array
        int max = A[0]; //Maximum Value in Array

        for (int i = 1; i < N; i++) //Loop Through Array, Get Minimum and Max, and Check if Sorted Already
        {
            if (sort && A[i] < A[i - 1]) //If Not Sorted, Then Eventually One Element
                sort = false; //Will be Smaller Then it's Precedent
            if (A[i] < min) //If Smaller Than Current Min
                min = A[i]; //Change Min
            else if (A[i] > max) //If Greater Than Current Max
                max = A[i]; //Change Max
        }
        if (sort) //If Already Sorted
            return A; //Return Array as is

        //Array of Counters
        int[] count = new int[max - min + 1]; //Set Size of Counters Array to Range of Elements

        for (int i1 : A) count[i1 - min]++; //Increment Count of Number in Respective Position in Counters Array
        int t = 0; //For Traversing Array of Counters
        for (int i = 0; i < N; ) //Sort Array Using Counters
        {
            while (count[t] == 0) //Find Next Smallest Number that Appears in Array
                t++;
            for (int j = 0; j < count[t]; j++) //Place It in Array However Many Times the Count is
                A[i++] = t + min;

            t++; //Increment Traverser of Counter Array
        }

        return A; //Return Sorted Array
    }
    //endregion triangle

    @Override
    public int numberOfDiscIntersections(int[] A) {
        //Edge Cases
        if (A.length < 2) //If Less Than Two Discs
            return 0; //No Intersections
        else if (A.length == 2) //If Only Two
        {
            //Base Case
            if (1 <= (long) A[0] + A[1]) //Check If Two Discs Intersect, Return Result
                return 1;
            else
                return 0;
        }

        int N = A.length; //Length of Array
        int[] dps = new int[N]; //Array to Hold Count of Values of Start Points on Plane
        int[] dpe = new int[N]; //Array to Hold Count of Values of End Points on Plane

        for (int i = 0; i < N; i++) //Walk Through Array
        {
            dps[Math.max(0, i - A[i])]++; //Increment Count of Respective Start Point
            dpe[(int) Math.min(N - 1, (long) i + A[i])]++; //Increment Count of Respective End Point
        }

        int t = 0; //Traverser
        int count = 0; //Number of Intersections

        for (int i = 0; i < N; i++) //Walk Through Array
        {
            if (dps[i] > 0) //If Start Point Isn't Zero
            {
                count += t * dps[i] + dps[i] * (dps[i] - 1) / 2; //Increment Count by Number of Intersections at Respective Start Point

                if (count > 10000000) //If More Than Number Allowed
                    return -1; //Return -1, Indicate Too Big

                t += dps[i]; //Increment Traverser by Start Point Count Value
            }

            t -= dpe[i]; //Decrement Traverser by End Point Count Value
        }

        return count; //Return Count
    }

    //region brackets
    @Override
    public int brackets(String S) {
        //Edge Cases
        if (S.length() == 0) //Empty String
            return 1; //Properly Nested
        else if ((S.length() & 1) == 1) //If Odd Number of Characters
            return 0; //Automatically Not Properly Nested

        //General Case
        int N = S.length(); //Get Length
        Stack<Character> nest = new Stack<>(); //Declare Stack of Characters

        for (int i = 0; i < N; i++) //Loop Through String Characters
        {
            char tmp = S.charAt(i); //Get Current Character

            switch (tmp) //Depending on Character, Peform Action
            {
                case '{':
                case '[':
                case '(':
                    nest.push(tmp); //If One of Preceding Characters, Push Onto Stack
                    break; //Leave Switch
                case '}':
                case ']':
                case ')':
                    try //If One of Following Characters
                    {
                        if (nest.pop() != precede(tmp)) //Check Most Recent Push Value
                            return 0; //Improperly Nested If Not Respective Preceding Character
                    } catch (EmptyStackException e) //If Empty Stack, Can't Pop
                    {
                        return 0;
                    } //Improperly Nested
                    break; //Leave Switch
                default: //Per Given Assumptions, Won't Happen, but I Included Anyway (I Just Felt Like It)
//                    throw new IllegalArgumentException(); //Invalid Character
                    return 0; //Could Also Just Say Not Nested Properly
            }
        }

        if (!nest.empty()) //After All Pushes and Pop, Stack Should be Empty
            return 0; //If Not, Improperly Nested

        return 1; //If Reached Here, Properly Nested
    }

    private char precede(char c) //Get Respective Preceding Character
    {
        switch (c) //Check Passed Character
        {
            case '}':
            case ']':
                return (char) (c - 2); //General Case, Respective Preceding Character is Two Less on ASCII Table
            case ')': //Special Case
                return '('; //Return Respective Preceding Character, '('
            default: //Shouldn't Happen Per Program, but Placed to Give Program Better Evolution
                return c; //Return Character Passed
        }
    }
    //endregion brackets

    @Override
    public int fish(int[] A, int[] B) {
        if (A.length == 1) //Only One fish
            return 1; //One fish Left Standing

        int N = A.length; //Number of fish
        int t = -1; //To Hold Position of First fish Swimming Downstream
        boolean nm = true; //Boolean to Check If Any fish Will Meet

        //Base Case and Edge Cases
        for (int i = 0; i < N; i++) //Loop Through Array
        {
            /* In Order for fish to Meet, There Must be at Least
             * One Swimming Upstream After One Swimming Downstream
             * If Not, All fish Alive
             */
            switch (B[i]) //Act Depending on Direction
            {
                case 0: //Upstream fish
                    if (t > -1) //If After Downstream fish
                        nm = false; //At Least One Pair of fish Will Meet
                    break;
                case 1: //Downstream fish
                    if (t < 0) //If No Prior fish Swimming Downstream
                        t = i; //Mark fish Location
                    break;
            }
            if (!nm) //If At Least One Pair of Meeting fish
                break; //Stop Checking
        }
        int alive = N; //Count of Living, All fish Initially Alive
        if (nm) //If No Pairs of fish Will Meet
            return alive; //All Will Live
        Stack<Integer> fish = new Stack<>(); //Keep Track of Downstream fish

        fish.add(A[t]); //Add Instance of Downstream fish to Stack

        for (int i = ++t; i < N; i++) //Loop Through Remaining fish
        {
            if (B[i] == 1) //If Downstream fish
                fish.add(A[i]); //Add to Stack
            else if (!fish.isEmpty()) //If Upstream fish With Prior Downstream fish
            {
                while (!fish.isEmpty() && A[i] > fish.peek()) //If Upstream fish Bigger Than Downstream Fishes
                {
                    fish.pop(); //Remove fish From Stack
                    alive--; //Decrement Alive Count
                }
                if (!fish.isEmpty()) //If Still fish in Stack
                    alive--; //Upstream fish Gets Eaten
            }
        }

        return alive; //Return Remaining Alive Count
    }

    @Override
    public int nesting(String S) {
        if (S.length() == 0) //If Empty String
            return 1; //Return True
        else if ((S.length() & 1) == 1) //If Odd Number of Characters
            return 0; //Automatically Not Properly Nested

        int N = S.length(); //Length of String
        int clp = 0; //Count of Left Parenthesis to be Matched

        //General Case
        for (int i = 0; i < N; i++) //Loop Through Each Character in String
        {
            char tmp = S.charAt(i); //Store Current Character

            if (tmp == '(') //If Left Parenthesis
                clp++; //Increment Count to be Matched
            else if (tmp == ')') //If Right Parenthesis
                clp--; //Decrement Count
            else //Not Needed Per Given Assumptions, but I Put in Anyway for Program Evolution
                throw new IllegalArgumentException(); //Illegal Character in String
            //return false //Could Just do This

            if (clp < 0) //If Count is Negative, Misplaced Right Parenthesis,
                return 0; //Improper Nesting
        }

        if (clp != 0) //If Left Parenthesis Left to Match
            return 0; //Improper Nesting

        return 1; //If Here, Properly Nested
    }

    @Override
    public int stoneWall(int[] H) {
        if (H.length == 1) //Base Case, Only One Height
            return 1;

        int N = H.length; //Number of Required Heights
        int count = 1; //Count of Blocks, At Least One
        Stack<Integer> Wall = new Stack<>(); //Stack to Keep Track of Heights

        Wall.add(H[0]); //Add First Height to Stack

        for (int i = 1; i < N; i++) //Loop Through Heights
        {
            while (!Wall.isEmpty() && H[i] < Wall.peek()) //Remove Elements Until Height That Isn't
                Wall.pop(); //Greater Than Current
            if (!Wall.isEmpty() && H[i] == Wall.peek()) //If Equal
                continue; //Skip

            count++; //Increment Count of Blocks
            Wall.add(H[i]); //Add Height to Stack
        }

        return count; //Return Number of Blocks Needed
    }

}
