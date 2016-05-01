public class Solution {
	public int ladderLength(Stirng beginWord, String endWord, Set<String> wordList) {
		if (wordList.size () == 0) {
			return 0;
		}
		wordList.add(beginWord);
		wordList.add(endWord);
		HashSet<String> set = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		set.add(beginWord);
		q.offer(beginWord);
		int length = 1;
		while (!q.isEmpty()) {
			++length;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				String crt = q.poll();
				for (String next : getNext(crt, wordList)) {
					if (set.contains(next)) {
						continue;
					} 
					if (next.equals(endWord) {
						return length;
					} 
					q.offer(next);
					set.add(next);
				}
			}
		}
		return 0;
	}
	private List<Sring> getNext(Stirng crt, Set<String> wordList) {
		List<String> expansion = new ArrayList<>();
		for (int i = 0; i < crt.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != crt.charAt(i)) {
					String expanded = crt.substring(0, i) + ch 
									+ crt.substring(i + 1);
					if (wordList.contains(expanded)) {
						expansion.add(expanded);
					}
				}
			}
		}
		return expansion;
	}

}