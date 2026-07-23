class Solution {
    public char kthCharacter(int k) {
        StringBuilder word = new StringBuilder ("a");
        while(word.length()< k) {
            int n = word.length();
            for(int i = 0; i < n; i++) {
                char c = word.charAt (i);
               word.append(c == 'z' ?'a' : (char) (c + 1)); 
            }
        }
        return word.charAt (k - 1);
    }
}