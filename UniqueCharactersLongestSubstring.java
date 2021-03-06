package uc.longestuniquesubstring;

import java.util.Arrays;

public class UniqueCharactersLongestSubstring {

	static final int NO_OF_CHARS = 256;

	public static void main(String[] a) {
		dotestPass();
	}

	static void dotestPass() {
		boolean flag = largestSubstring("abcdefa") == 6 && largestSubstring("edcbdehiejafgaaindexingyz") == 8
				&& largestSubstring("abdefgabef") == 6 && largestSubstring("aaa") == 1
				&& largestSubstring("zzywxabcxrtyus") == 9;

		if (flag) {
			System.out.println("\ntest Passed");
		} else {
			System.out.println("\ntest failed");
		}
	}

	static int largestSubstring(String str) {
		int[] az = new int[26];
		Arrays.fill(az, -1);

		int len = 1, c = 1;

		char ch = str.charAt(0);
		az[ch - 97] = 0;

		for (int i = 1; i < str.length(); i++) {
			ch = str.charAt(i);

			if (az[ch - 97] == -1) {
				az[ch - 97] = i;
				c++;
			} else {
				if (len < c)
					len = c;
				i = az[ch - 97];
				c = 0;
				Arrays.fill(az, -1);
			}
		}
		if (len < c)
			len = c;

		System.out.println("\n" + str + "->" + len);
		return len;
	}
}
