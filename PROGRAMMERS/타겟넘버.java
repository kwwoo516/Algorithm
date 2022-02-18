class Solution {
  static int len;
  static int count;
  static int t;

  public int solution(int[] numbers, int target) {
    len = numbers.length;
    count = 0;
    t = target;
    perm(0, new int[len], numbers);
    return count;
  }

  public void perm(int cnt, int[] nums, int[] numbers) {
    if (cnt == len) {
      int sum = 0;
      for (int i = 0; i < len; i++) {
        sum += nums[i];
      }
      if (sum == t) {
        count++;
      }
      return;
    }
    nums[cnt] = numbers[cnt];
    perm(cnt + 1, nums, numbers);

    nums[cnt] = numbers[cnt] * -1;
    perm(cnt + 1, nums, numbers);
  }
}