import java.util.ArrayList;
import java.util.List;

public class SortChallenge implements SortInterface {

    @Override
    public int[] simpleSort(int[] list, boolean ascending) {
        int t = 0;
        boolean needToSwap = false;
        final int[] rlist = new int[list.length];
        final int l = list.length;
        System.arraycopy(list, 0, rlist, 0, l);
        for (int i = 0; i < l - 1; i++) {
            for (int j = i + 1; j < l; j++) {
                needToSwap = ascending ? rlist[i] > rlist[j] : rlist[i] < rlist[j];

                if (needToSwap) {
                    t = rlist[i];
                    rlist[i] = rlist[j];
                    rlist[j] = t;
                }
            }
        }
        return rlist;
    }

    @Override
    public void printSortedFrequency(int[] list) {
        // get the ascending list
        int[] ascList = simpleSort(list, true);

        // array of keys 
        List<Integer>keys = new ArrayList<Integer>();
        List<Integer>values = new ArrayList<Integer>();
        int index = 0; 
        keys.add(ascList[0]);
        int counter = 1;
        values.add(counter);

        for (int i=1; i<list.length; i++) {
            if (ascList[i-1] == ascList[i]) {
                // increase counter while we've got same integer
                counter++;
            }
            else {
                // different values found, set previous counter
                values.set(index, counter);
                // add new unique element
                keys.add(ascList[i]);
                // next unique element
                index++;
                // reset counter 
                counter = 1;
                values.add(counter);
            }
            // check for the last element
            if (i == list.length - 1) {
                // different values found, set previous counter
                values.set(index, counter);
            }
        }
        for (int i=0;  i<keys.size(); i++) {
            int element = keys.get(i);
            int times = values.get(i);
            System.out.printf(times > 1 ? "%d appears %d times\n" : "%d appears %d time\n", element, times);
        }
    }

    @Override
    public int numberOfUniqueValues(int[] list) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void printArray(int [] list) {
        System.out.println(""); // new line
        System.out.print("[ ");
        for (int i =0; i<list.length; i++) {
            if (i < list.length - 1) {
                System.out.printf("%d ,", list[i]);
            } else {
                System.out.printf("%d ", list[i]);
            }
            
        }
        System.out.println("] ");
    }
}