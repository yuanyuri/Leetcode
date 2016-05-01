public class Solution {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> ladders = new ArrayList<>();
		Map<String,List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		dict.add(start);
		dict.add(end);
		
		bfs(map, distance, start, end, dict);
		List<String> path = new ArrayList<>();
		dfs(ladders, path, end, start, map, distance);
		return ladders;
	}
	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start,
				String end, Set<String> dict) {
		Queue<String> q = new LinkedList<>();
		q.offer(start);
		distance.add(start, 0);
		for (String s : dict) {
			map.put(s, new ArrayList<String>());
		}
		while (!q.isEmpty()) {
			String crt = q.poll();
			List<String> nextList = expand(crt, dict);
			for (String next : nextList) {
				map.get(next).add(crt);
				if (!distance.containsKey(next)) {
					distance.put(next, distance.get(crt) + 1);
					q.offer(next);
				}
			}
		}
	}

	List<String> expand(Stirng crt, Set<String> dict) {
		List<String> expansion = new ArrayList<String>();
		for (int i = 0; i < crt.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != crt.charAt(i)) {
					String expanded = crt.subString(0, i) + ch + crt.subString(i + 1);
					if (dict.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}
	}

	private void dfs(List<List<String>> ladders, List<String> path, String crt, 
					String start, Map<String, List<String>> map, 
					Map<String, Integer> distance) {
		path.add(crt);
		if (crt.equals(start)) {
			Collections.reverse(path);
			ladders.add(new ArrayList<String>(path));
			Collections.reverse(path);
		} else {
			for (String next : map.get(crt)) {
				if (distance.get(crt) == distance.get(next) + 1) {
					dfs(ladders, path, next, start, map, distance);
				}
			}
		}
		path.remove(path.size() - 1);

	}

}