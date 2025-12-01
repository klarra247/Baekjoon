import java.util.Arrays;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if (sticker.length == 1) {
            return sticker[0];
        }
        if (sticker.length == 2){
            return Math.max(sticker[0], sticker[1]);
        }
        
        
        // 첫번째 스티커 포함
        int[] case1 = Arrays.copyOfRange(sticker, 0, sticker.length - 1);
        // 첫번째 미포함
        int[] case2 = Arrays.copyOfRange(sticker, 1, sticker.length);

        int[] dp1 = new int[case1.length];
        int[] dp2 = new int[case2.length];
        
        dp1[0] = case1[0];
        dp1[1] = Math.max(case1[0], case1[1]);
        dp2[0] = case2[0];
        dp2[1] = Math.max(case2[0], case2[1]);
        
        for (int i = 2; i < case1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + case1[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + case2[i]);
            
        }
                                       
        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}