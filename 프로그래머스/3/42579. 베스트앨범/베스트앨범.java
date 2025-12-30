import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, int[]> maxTwo = new HashMap<>();
        Map<String, Integer> totalPlays = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);       
            int[] arr = maxTwo.getOrDefault(genres[i], new int[4]);
            if (plays[i] <= arr[1] && plays[i] > arr[3]) {
                arr[2] = i;
                arr[3] = plays[i];
            }
            if (plays[i] > arr[1]) {
                arr[2] = arr[0];
                arr[3] = arr[1];
                arr[0] = i;
                arr[1] = plays[i];
                
            }

            maxTwo.put(genres[i], arr);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(totalPlays.entrySet());
        
        list.sort(
            Map.Entry.<String, Integer>comparingByValue().reversed()
        );        
        
        String[] result = list.stream().map(Map.Entry::getKey).toArray(String[]::new);
        
        for (String key : result) {
            if (maxTwo.get(key)[1] != 0) {
                answer.add(maxTwo.get(key)[0]);
            }
            if (maxTwo.get(key)[3] != 0) {
                answer.add(maxTwo.get(key)[2]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}