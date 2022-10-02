class Solution {
    public int[] sortByBits(int[] arr) {
        int[] counts = new int[arr.length];
        for(int i = 0; i < counts.length; i++){
            int num = arr[i];
            while(num > 0){
                if((num & 1) == 1) counts[i]++;
                num >>= 1;
            }
        }
        
        for(int i = 0; i < counts.length; i++){
            boolean sorted = true;
            for(int j = 0; j < counts.length - i - 1; j++){
                if(counts[j] > counts[j + 1]){
                    sorted = false;
                    int c = counts[j];
                    counts[j] = counts[j + 1];
                    counts[j + 1] = c;
                    c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
            }
            if(sorted) break;
        }
        
        int start = 0, end = 0;
        while(start != arr.length){
            while(end != arr.length && counts[end] == counts[start]) end++;
            for(int i = start; i < end; i++){
            boolean sorted = true;
            for(int j = start; j < start + end - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    sorted = false;                    
                    int c = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = c;
                }
            }
            if(sorted) break;
        }
        start = end;
        }
        
        return arr;
    }
}
