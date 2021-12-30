import java.util.*;

public class lco752 {
    public String addRes(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        } else {
            chars[j] = (char) (chars[j] + 1);
        }
        return String.valueOf(chars);
    }

    public String redRes(String s, int j) {
        char[] chars = s.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        } else {
            chars[j] = (char) (chars[j] - 1);
        }
        return String.valueOf(chars);
    }

    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.offer("0000");
        visited.add("0000");
        int len = 0;
        while (!qu.isEmpty()) {
            int si = qu.size();
            for (int i = 0; i < si; i++) {
                String s = qu.poll();
                if (dead.contains(s)) {
                    continue;
                }
                if (target.equals(s)) {
                    return len;
                }
                for (int j = 0; j < 4; j++) {
                    String addRes = addRes(s, j);
                    if (!visited.contains(addRes)) {
                        qu.offer(addRes);
                        visited.add(addRes);
                    }
                    String redRes = redRes(s, j);
                    if (!visited.contains(redRes)) {
                        qu.offer(redRes);
                        visited.add(redRes);
                    }
                }
            }
            len++;
        }
        return -1;
    }
}
