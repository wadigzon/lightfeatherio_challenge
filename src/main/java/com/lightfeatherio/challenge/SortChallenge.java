import java.util.ArrayList;
import java.util.List;

public class SortChallenge implements SortInterface {

    private class MiniHash {
        // array of keys 
        protected List<Integer>keys = null;
        protected List<Integer>values = null;
        // receives and list ordered ascending 
        MiniHash(int[] list) {
            // get the ascending list
            int[] ascList = simpleSort(list, true);            
            keys = new ArrayList<Integer>();
            values = new ArrayList<Integer>();
            // initialize hash with 1st element
            int index = 0;
            keys.add(ascList[0]);
            int counter = 1;
            values.add(counter);
            for (int i = 1; i < ascList.length; i++) {
                if (ascList[i - 1] == ascList[i]) {
                    // increase counter while we've got same integer
                    counter++;
                } else {
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
                if (i == ascList.length - 1) {
                    // different values found, set previous counter
                    values.set(index, counter);
                }
            }     
        }
        // return size of hash
        protected int size() {
            return keys.size(); 
        }
        // get the key
        protected int getKey(int index){
            return keys.get(index);
        }
        // get the value
        protected int getValue(int index) {
            return values.get(index);
        }
    }

    @Override
    // use simple and easy bubble sort
    public int[] simpleSort(int[] list, boolean ascending) {
        int t = 0;
        boolean needToSwap = false;
        int[] rlist = new int[list.length];
        int l = list.length;
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
        // get list of occurrences of elements in list
        MiniHash mh = new MiniHash(list);
        for (int i = 0; i < mh.size(); i++) {
            int element = mh.getKey(i);
            int times = mh.getValue(i);
            System.out.printf(times > 1 ? "%d appears %d times\n" : "%d appears %d time\n", element, times);
        }
    }

    @Override
    public int numberOfUniqueValues(int[] list) {
        // get list of occurrences of elements in list
        MiniHash mh = new MiniHash(list);
        // size of hash gives number of unique elements
        return mh.size();
    }

    public void printArray(int[] list) {
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