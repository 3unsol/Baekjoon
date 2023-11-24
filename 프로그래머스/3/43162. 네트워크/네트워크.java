class Solution {
    
    static boolean[] isVisited;
    static int count;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                dfs(i, computers, n);
                count++;
            }
        }
        
        answer = count;
        return answer;
    }
    
    public void dfs(int i, int[][] computers, int n){
        
        isVisited[i] = true;
        
        for(int j = 0; j < n; j++){
            if(computers[i][j] == 1 && !isVisited[j]){
                dfs(j, computers, n);
            }
        }
    }
}