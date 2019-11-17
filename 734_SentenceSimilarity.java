import java.util.*;
import java.io.*;

// 3ms solution by using map
class SentenceSimilarity {
    public static boolean isSame(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        HashMap<String, List<String>> mp = new HashMap<>();
        
        for (int i=0; i<pairs.size(); i++) {
            if (mp.containsKey(pairs.get(i).get(0))) {
                List<String> paird = mp.get(pairs.get(i).get(0));
                paird.add(pairs.get(i).get(1));
                mp.put(pairs.get(i).get(0),paird);
            } else {
                List<String> pairedwords = new ArrayList<>();
                pairedwords.add(pairs.get(i).get(1));
                mp.put(pairs.get(i).get(0),pairedwords);
            }
            
            if (mp.containsKey(pairs.get(i).get(1))) {
                List<String> paird = mp.get(pairs.get(i).get(1));
                paird.add(pairs.get(i).get(0));
                mp.put(pairs.get(i).get(1),paird);
            } else {
                List<String> pairedwords = new ArrayList<>();
                pairedwords.add(pairs.get(i).get(0));
                mp.put(pairs.get(i).get(1),pairedwords);
            }
        }
        // System.out.println(mp);
        
        boolean isMatched = true;
        for (int i=0; i<words1.length; i++) {
            if (words1[i].compareTo(words2[i]) != 0) {
                if (mp.containsKey(words2[i])) {
                    if (!(mp.get(words2[i])).contains(words1[i])) {
                        isMatched = false;
                        break;
                    }
                } else {
                    isMatched = false;
                    break;
                }
            }
        }
        return isMatched;
    }
    public static List<List<String>> arrayTo2DList(String input) {
        JsonArray jsonArray = JsonArray.readFrom(input);
        if (jsonArray.size() == 0) {
          return new ArrayList<List<String>>();
        }
        List<List<String>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          list.add(stringToStringList(cols.toString()));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        String[] words1 = line1.split(" ");

        String line2 = br.readLine();
        String[] words2 = line2.split(" ");

        List<List<String>> pairs = new ArrayList<>();
        while (true) {
            String line = br.readLine();
            // System.out.println("=== " + line);
            if (line.length() == 0) {
                // System.out.println("end");
                break;
            }
            List<String> l = new ArrayList<>();
            String[] p = line.split(" ");
            for (int i=0; i<p.length; i++) {
                l.add(p[i]);
            }
            pairs.add(l);
        }
        // System.out.println("hfhfs");
        boolean ans = isSame(words1, words2, pairs);
        System.out.println(ans);
    }
}