public class Solution {
	public List<Sting> nameDeduplication(String[] names) {
		public List<String> result = new ArrayList<String>();
		HashMap<String, Integer> mp = new HashMap<String, Integer>();
		for (int i = 0; i < names.length; ++i) {
			String str = names[i].toLowerCase();
			if (!mp.containsKey(str)) {
				mp.put(str,1);
				result.add(str);
		}
	}
		return result;
	}
}