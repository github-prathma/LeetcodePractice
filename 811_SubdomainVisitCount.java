import java.util.*;
import java.io.*;

class SubdomainVisitCount {

	public static List<String> subdomainCount(String[] cpdomains) {
		HashMap<String, Integer> domainsCount = new HashMap<>();

		for (int i=0; i<cpdomains.length; i++) {
			String[] countDomains = cpdomains[i].split(" ");

			// for (String s : countDomains) {
			// 	System.out.print(s + " ");
			// }
			// System.out.println();

			String[] subdomainWords = countDomains[1].trim().split("\\.");

			if (subdomainWords.length == 2) {
				if (domainsCount.containsKey(subdomainWords[1])) {
					domainsCount.put(subdomainWords[1], domainsCount.get(subdomainWords[1]) + Integer.parseInt(countDomains[0]));
				} else {
					domainsCount.put(subdomainWords[1], Integer.parseInt(countDomains[0]));
				}

				if (domainsCount.containsKey(countDomains[1])) {
					domainsCount.put(countDomains[1], domainsCount.get(countDomains[1]) + Integer.parseInt(countDomains[0]));

				} else {
					domainsCount.put(countDomains[1], Integer.parseInt(countDomains[0]));
				}
			} else if (subdomainWords.length == 3) {
				String sdomain1 = subdomainWords[1] + "." + subdomainWords[2];

				if (domainsCount.containsKey(sdomain1)) {
					domainsCount.put(sdomain1, domainsCount.get(sdomain1) + Integer.parseInt(countDomains[0]));
				} else {
					domainsCount.put(sdomain1, Integer.parseInt(countDomains[0]));
				}

				if (domainsCount.containsKey(subdomainWords[2])) {
					domainsCount.put(subdomainWords[2], domainsCount.get(subdomainWords[2]) + Integer.parseInt(countDomains[0]));
				} else {
					domainsCount.put(subdomainWords[2], Integer.parseInt(countDomains[0]));
				}

				if (domainsCount.containsKey(countDomains[1])) {
					domainsCount.put(countDomains[1], domainsCount.get(countDomains[1]) + Integer.parseInt(countDomains[0]));
				} else {
					domainsCount.put(countDomains[1], Integer.parseInt(countDomains[0]));
				}
			}
		}


		List<String> res = new ArrayList<>();

		for (Map.Entry<String, Integer> entry : domainsCount.entrySet()) {
			res.add(Integer.toString(entry.getValue()) + " " + entry.getKey()); 
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Number of domains: ");

		int n = Integer.parseInt(br.readLine());

		String[] input = new String[n];

		for (int i=0; i<n; i++) {
			String s = br.readLine();
			input[i] = s;
		}

		List<String> res = subdomainCount(input);

		for (String s : res) {
			System.out.println(s + " ");
		}
		System.out.println();
	}
}