class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][5];
        for(int j=0;j<5;j++){
            dp[1][j]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<5;j++){
                int sameVowel=dp[i-1][j];
                int prevVowel=(j>0)?dp[i][j-1]:0;
                dp[i][j]=sameVowel+prevVowel;
            }
        }
        int total=0;
        for(int j=0;j<5;j++){
            total+=dp[n][j];
        }
        return total;
    }
}