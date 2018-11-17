import java.util.Scanner;
import java.util.ArrayList;


public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

		public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
				// your code goes here
		String[] strs = toReadFile(file);
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i].toLowerCase();
			// System.out.println(strs[i]);
            if (!(st.contains(str))) {
                st.put(str, 1);
            } else {
            	int count = st.get(str);
                st.put(str, count + 1);
            }
        }
		return st;
	}

}

class T9 {
	private TST<Integer> tst;
	private BinarySearchST<String, Integer> bst;

	public T9(BinarySearchST<String, Integer> st) {
		bst = st;
		tst = new TST<Integer>();
			for (String key : bst.keys()) {
				tst.put(key, bst.get(key));
			}
		// your code goes here
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
        ArrayList<String> al = new ArrayList<String>();
		for (String str : tst.keysWithPrefix(prefix)) {
            if (!al.contains(str) && tst.hasPrefix(str)) {
            	al.add(str);
            }
        }
		// your code goes here
		return al;
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		int top = k;
		String[] str1 = new String[10];
		String[] str2 = new String[10];
		int i = 0;
		ArrayList<String> als = new ArrayList<String>();
		for (String str : words) {
			str1[i++] = str;
		}
		int max = 0;
		for (int j = 0; j < i; j++) {
			if (bst.get(str1[j]) > max) {
				max = bst.get(str1[j]);
				str2[0] = str1[j];

			}
			System.out.println(bst.get(str1[j]));
			als.add(str2[0]);
		}

			// bst.get(str);

		
		// your code goes here
		return als;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
