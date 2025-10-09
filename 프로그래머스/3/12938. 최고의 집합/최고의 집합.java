class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int idx = 0;
        int num;
        
        if (n > s) return new int[]{-1};
        
        while (s > 0) {
            num = s / n;
            answer[idx] = num;
            n--;
            s = s - num;
            idx++;   
        }
        return answer;

    }
}