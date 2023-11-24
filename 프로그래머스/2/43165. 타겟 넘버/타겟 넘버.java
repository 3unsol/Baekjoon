class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        dfs(numbers, 0, target, 0);
        
        answer = count;
        
        return answer;
    }
    
    public void dfs(int[] numbers, int k, int target, int result){
        
        if(k == numbers.length){
            if(target == result){
                count++;
            }
            return;
        }
        
        int plus = result + numbers[k];
        int minus = result - numbers[k];
        
        dfs(numbers, k + 1, target, plus);
        dfs(numbers, k + 1, target, minus);
        
    }
}