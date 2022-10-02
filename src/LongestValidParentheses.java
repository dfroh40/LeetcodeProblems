public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            int revert = 0;
            int balance  = 0;
            int j = i;
            while(j < s.length() && 0 <= balance){
                count++;
                balance  += (s.charAt(j) == '(') ? 1 : -1;
                if(balance == 0) revert = count;
                j++;
            }
            if(balance != 0) count = revert;
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
