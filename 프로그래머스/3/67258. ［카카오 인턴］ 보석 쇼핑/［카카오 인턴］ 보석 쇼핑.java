import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int totalKinds = set.size();
        
        Map<String, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        
        int minLen = gems.length + 1;
        int ansStart = 0;
        int ansEnd = 0;
        
        while (true) {
            if (map.size() < totalKinds) {
                if (end == gems.length) break;
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end ++;
            } else {
                if (end - start < minLen) {
                    minLen = end - start;
                    ansStart = start + 1;
                    ansEnd = end;
                }
                
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
                
            }
        }
        
        return new int[]{ansStart, ansEnd};
    }
}