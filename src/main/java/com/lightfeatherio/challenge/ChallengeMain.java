import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChallengeMain {
    public static void main(String[] argc) {
        System.out.println("Enter integers separated by space <Enter> when done:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> iList = new ArrayList<Integer>();
        int[] myIntArray = null;

        try {
            String s;
            s = br.readLine();
            if (s.length() > 0) {
                String[] tokens = s.trim().split("\\s+");
                myIntArray = new int[tokens.length];
                int i=0;
                for(String t : tokens) {
                    int number = Integer.parseInt(t);
                    myIntArray[i++] = number;
                }
            } else {
                System.out.println("Nothing was entered!");
                return;
            }
        }

        catch (Exception e) {
            System.out.println("error entering data - plase enter integer numbers separated by space only");
            return;
        }

        for (int i = 0; i < iList.size(); i++)
            myIntArray[i] = iList.get(i);

        SortChallenge sc = new SortChallenge();
        int[] ascSort = sc.simpleSort(myIntArray, true);

        System.out.print("The sorted array in ascending order is:");
        sc.printArray(ascSort);
        System.out.println("The frequency of array elements is as follows:");
        sc.printSortedFrequency(myIntArray);
        System.out.println("The number of unique element(s) in the array is: ");
        int nouv = sc.numberOfUniqueValues(myIntArray);
        System.out.println(nouv);

    }
}
