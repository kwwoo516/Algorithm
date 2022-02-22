import java.util.*;

class Solution {
  static char[] list;
  static int count;
  static ArrayList<Integer> numlist = new ArrayList<>();

  public int solution(String numbers) {
    list = numbers.toCharArray();
    count = 0;
    for (int i = 1; i <= numbers.length(); i++) {
      perm(0, new char[i], new boolean[list.length], i);
    }
    return count;
  }

  public void perm(int cnt, char[] nums, boolean[] v, int end) {
    if (cnt == end) {
      if (nums[0] == '0') {
        return;
      }
      int value = Integer.parseInt(String.valueOf(nums));
      System.out.println(value);
      if (isprime(value)) {
        if (!numlist.contains(value)) {
          numlist.add(value);
          count++;
        }
      }
      return;
    }
    for (int i = 0; i < list.length; i++) {
      if (v[i])
        continue;
      v[i] = true;
      nums[cnt] = list[i];
      perm(cnt + 1, nums, v, end);
      v[i] = false;
    }
  }

  public boolean isprime(int num) {
    if (num < 2) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    for (int i = 2; i < num; i++) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}