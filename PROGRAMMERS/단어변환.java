import java.util.*;

class Solution {
  static class Node {
    String word;
    int cnt;

    public Node(String word, int cnt) {
      this.word = word;
      this.cnt = cnt;
    }
  }

  public int solution(String begin, String target, String[] words) {
    Queue<Node> q = new LinkedList<>();
    boolean[] visit = new boolean[words.length];
    q.add(new Node(begin, 0));
    while (!q.isEmpty()) {
      Node temp = q.poll();
      if (temp.word.equals(target)) {
        return temp.cnt;
      }
      for (int i = 0; i < words.length; i++) {
        if (visit[i]) {
          continue;
        }
        if (changeable(temp.word, words[i])) {
          q.add(new Node(words[i], temp.cnt + 1));
          visit[i] = true;
        }
      }
    }

    return 0;
  }

  public boolean changeable(String from, String to) {
    int cnt = 0;
    for (int i = 0; i < from.length(); i++) {
      if (from.charAt(i) != to.charAt(i)) {
        cnt++;
      }
    }
    return cnt == 1 ? true : false;
  }
}