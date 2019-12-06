import java.io.*;
import java.math.BigInteger;
import java.util.*;

// Mapping and sorting such that list of num strings given, suppose {"990", "332", "32"} and mapping given such 
// that {3,5,4,6,2,7, 9, 8, 0, 1} .. mapped num will be 990 == 668 (position of 9 and 0 in mappings list)
// similarly 332 to 004 and 32 to 04 .. according to sort 4, 668 and final sorted list = {"332", "32", "990"}.. order will be maintained
// if more than one string mapped to same number.


//Optimised code for handling numbers greater than BigInt
class StrangeSort {
    public static TreeMap sortByKey(HashMap<String, ArrayList<String>> mp) {
        TreeMap<String, ArrayList<String> > tp = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int l1 = s1.length();
                int l2 = s2.length();
                int c = l1-l2;
                if (c == 0) {
                    c = s1.compareTo(s2);
                }
                return c;
            } 
        });

        tp.putAll(mp);

        return tp;
    } 

    public static String mappedStringNum(ArrayList<Integer> mappings, String num) {
        // System.out.println(num);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num.length(); i++) {
            int index = mappings.indexOf(num.charAt(i)-48);
            sb.insert(i, index);
        }
        return sb.toString();
    }

    public static ArrayList<String> sortedStrings(ArrayList<Integer> mappings, String[] nums) {
        ArrayList<String> results = new ArrayList<>();
        HashMap<String, ArrayList<String> > mp = new HashMap<>();

        for (int i=0; i<nums.length; i+=1) {
            String mappedStrNum = mappedStringNum(mappings, nums[i]);

            int ind = 0;
            while (ind < mappedStrNum.length() && mappedStrNum.charAt(ind) == '0'   ) {
                ind++;
            } 
            StringBuffer newStrB = new StringBuffer(mappedStrNum);
            newStrB.replace(0, ind, "");
            mappedStrNum = newStrB.toString();

            if (mp.get(mappedStrNum) == null) 
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(nums[i]);
                mp.put(mappedStrNum, list);
            } else {
                (mp.get(mappedStrNum)).add(nums[i]);
            }
        }
        TreeMap<String, ArrayList<String> > tp = sortByKey(mp);
        System.out.println(tp);
        for (Map.Entry<String,ArrayList<String>> entry : tp.entrySet() ) {
            results.addAll(entry.getValue());
        }
        return results;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lin1 = br.readLine();
        String[] inputMappings = lin1.split(" ");
        ArrayList<Integer> mappingsArray = new ArrayList<>();

        for (int i =0; i<inputMappings.length; i++) {
            mappingsArray.add(Integer.parseInt(inputMappings[i]));
        }

        String lin2  = br.readLine();
        String[] nums = lin2.split(" ");

        ArrayList<String> result = sortedStrings(mappingsArray, nums);
        for (int i = 0; i<result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }
}