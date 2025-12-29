import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        
        Map<Integer, Set<String>> map = new HashMap<>();
        
        // 길이 기준 정렬
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        
        for (String phone : phone_book) {
            for (Integer key : map.keySet()) {
                if (key < phone.length()) {
                    if (map.get(key).contains(phone.substring(0, key))) {
                        return false;
                    }
                }
            }
            map.computeIfAbsent(phone.length(), k -> new HashSet<>()).add(phone);
            
        }
        return true;
    }
}