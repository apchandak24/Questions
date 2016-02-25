import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

	public Graph() {

		initializeGraph(6);
		addEdge(0, 1);
		addEdge(3, 1);
		addEdge(1, 2);

		addEdge(5, 4);
		addEdge(2, 5);

		deleteVertex(2);
		for (Entry<Integer, LinkedList<Integer>> val : map.entrySet()) {
			System.out.println(val.getKey() + " " + val.getValue().toString());
		}
		BFS(0);
		System.out.println();
		DFS(0);
	}

	private void initializeGraph(int size) {
		for (int i = 0; i < size; i++) {
			map.put(i, new LinkedList<>());
		}
	}

	private void addEdge(int v1, int v2) {

		if (v1 >= map.size() || v2 >= map.size())
			return;

		map.get(v1).add(v2);
		map.get(v2).add(v1);

	}

	private void deleteVertex(Integer v) {
		LinkedList<Integer> edges = map.get(v);

		for (Integer i : edges) {
			map.get(i).remove(v);
		}
		map.remove(v);

	}

	private void BFS(int s) {
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[map.size()];

		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {

			int temp = queue.poll();
			System.out.print(temp + " ");

			for (Integer i : map.get(temp)) {
				if (!visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}

		}

	}

	private void DFS(int s) {

		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		boolean visited[] = new boolean[map.size()];
		visited[s] = true;

		while (!stack.isEmpty()) {
			int item = stack.pop();
			System.out.print(item + " ");

			for (Integer i : map.get(item)) {
				if (!visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}

		}

	}

}
