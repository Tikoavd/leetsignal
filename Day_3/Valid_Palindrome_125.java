class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        String str = "";
        for(int i = s.length() - 1; i >= 0; i--) str = str + s.charAt(i);
        if(s.equals(str)) return true;
        else return false;
    }
}
