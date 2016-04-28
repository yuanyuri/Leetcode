import java.util.*;

public class GrayCode {
    public String[] getGray(int n) {
        String[] result = new String((int)Math.pow(2,n));
        String gray = new String;
        helper(result, gray, n);
        return result;
    }
    private void helper(String[] result, String gray, int n) {
    	if (result.length > (int)Math.pow(2,n)) {
    		return;
    	}
    	if (gray.length() == n) {
    		String tmp = new String(gray);
    		result[result.length] = tmp;
    		return;
    	}
    	for (int j = 0; j <= 1; j++) {
    		gray = gray + String.valuOf(j);
    		helper(result, gray, n);
    		gray = gray.substring(0, gray.length - 1);
    	}

    }
}