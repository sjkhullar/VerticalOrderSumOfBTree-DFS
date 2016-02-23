
package org.learn.Question;

import java.util.HashMap;
import java.util.Map;

public class VerticalOrderSumOfBTree {
	private static Map<Integer, Integer> map = null;

	private static void verticalOrder(Node root, int distance) {
		if (null == root)
			return;
		int existingValue = 0;
		if (map.containsKey(distance)) {
			existingValue = map.get(distance);
		}
		map.put(distance, root.data + existingValue);
		verticalOrder(root.left, distance - 1);
		verticalOrder(root.right, distance + 1);
	}

	public static void verticalOrderSumOfBTree(Node root) {
		if (null == map) {
			map = new HashMap<Integer, Integer>();
		} else {
			map.clear();
		}
		verticalOrder(root, 0);
		map.forEach((k, v) -> System.out.println("Nodes at distance " + k + " = " + v));
	}
}
