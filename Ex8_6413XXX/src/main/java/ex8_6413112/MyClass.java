package ex8_6413112;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MyClass {

	public static void main(String[] args) {

		TreeMap<String, String> tree = new TreeMap<String, String>();

		tree.put("Tel", "0843261855");
		tree.put("MemberID", "1");
		tree.put("Name", "SASIT SRIRAT");
		tree.put("Tel", "0843261855");
		tree.put("Tel", "0843261855");

		Set<Entry<String, String>> set = tree.entrySet();

		Iterator<Entry<String, String>> it = set.iterator();
		while (it.hasNext()) {
			Map.Entry me = (Map.Entry) it.next();
			System.out.print("Key = " + me.getKey() + " , ");
			System.out.println("Value = " + me.getValue());
		}

	}

}
