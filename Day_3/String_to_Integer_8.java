class Solution {
    public int myAtoi(String s) {
        int num = 0;
        boolean positive = true;
        boolean sign = false;
        boolean finded = false;
        loop: for(char n : s.toCharArray()){
            if((num > Integer.MAX_VALUE / 10 && Character.isDigit(n)) || (num == Integer.MAX_VALUE/10 && Character.getNumericValue(n) > Integer.MAX_VALUE%10 && Character.isDigit(n))) {
            if (!positive) {
                return Integer.MIN_VALUE;
            }
            else {
                return Integer.MAX_VALUE;
            }
            }
            
            switch(n){
                case ' ':
                    if(sign || finded) {
                        if(!positive) return -num;
                        else return num;
                    }
                    break;
                case '0':
                    finded = true;
                    if(num != 0) num *= 10;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    finded = true;
                    num *= 10;
                    num += Character.getNumericValue(n);
                    break;
                case '+':
                    if(sign || finded) {
                        if(!positive) return -num;
                        else return num;
                    }
                    sign = true;
                    break;
                case '-':
                    if(sign || finded) {
                        if(!positive) return -num;
                        else return num;
                    }
                    positive = false;
                    sign = true;
                    break;
                default:
                    break loop;
            }            
        }
        if(!positive) return -num;
        else return num;
    }
}
