import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Mapping {
    public static TreeMap sortByKey(HashMap<BigInteger, ArrayList<String>> mp) {
        TreeMap<BigInteger, ArrayList<String> > tp = new TreeMap<>();

        tp.putAll(mp);

        return tp;
    }

    public static String mappedStringNum(ArrayList<Integer> mappings, String num) {
        // System.out.println(num);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num.length(); i++) {
            int index = mappings.indexOf(num.charAt(i)-48);
            // System.out.println(num.charAt(i) + " === " + index);
            sb.insert(i, index);
        }
        return sb.toString();
    }

    public static ArrayList<String> sortedStrings(ArrayList<Integer> mappings, String[] nums) {
        ArrayList<String> results = new ArrayList<>();
        HashMap<BigInteger, ArrayList<String> > mp = new HashMap<>();

        for (int i=0; i<nums.length; i+=1) {
            String mappedStrNum = mappedStringNum(mappings, nums[i]);
           // System.out.println("==== " + mappedStrNum);
            BigInteger mappedNum = BigInteger.valueOf(Long.parseLong(mappedStrNum));

            if (mp.get(mappedNum) == null) 
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(nums[i]);
                mp.put(mappedNum, list);
            } else {
                (mp.get(mappedNum)).add(nums[i]);
            }
        }
        TreeMap<BigInteger, ArrayList<String> > tp = sortByKey(mp);
        for (Map.Entry<BigInteger,ArrayList<String>> entry : tp.entrySet() ) {
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