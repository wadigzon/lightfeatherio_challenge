import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChallengeMain {
    public static void main(String[] argc) {
        System.out.println("Enter integers (one per line - nothing to finish):");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> iList = new ArrayList<Integer>();
        try {

            String s;
            do {
                s = br.readLine();
                if (s.length() > 0) {
                    final int i = Integer.parseInt(s);
                    iList.add(i);
                }
            } while (s.length() != 0);
        }

        catch (final Exception e) {
            System.out.println("error entering data - plase enter integer numbers only");
        }

        if (iList.size() == 0) {
            System.out.println("No integer was entered!");
            return;
        }

        int[] myIntArray = new int[iList.size()];
        for (int i = 0; i < iList.size(); i++)
            myIntArray[i] = iList.get(i);

        SortChallenge sc = new SortChallenge();
        int[] ascSort = sc.simpleSort(myIntArray, true);

        sc.printArray(ascSort);
        
        sc.printSortedFrequency(myIntArray);

    }
}
