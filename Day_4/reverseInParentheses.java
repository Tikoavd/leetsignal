String solution(String inputString) {
    ListString myList = new ListString("", false);
    ListString ptr = myList;
    int brcount = 0;
    int startindex = 0;
    int len = inputString.length();
for(int i = 0; i < len; i++) {
    switch(inputString.charAt(i)){
        case '(':
        ptr.next = new ListString(inputString.substring(startindex, i), brcount == 0 ? false : true);
        ptr = ptr.next;
        startindex = i + 1;
        brcount++;
        break;
        case ')':
        brcount--;
        ptr.next = new ListString(inputString.substring(startindex, i), true);
        ptr = ptr.next;
        startindex = i + 1;
        break;
    }
    if(i + 1 == len) ptr.next = new ListString(inputString.substring(startindex, len), false);
}
ptr = myList;
inputString = "";

while(ptr != null){
    if(!ptr.bracket){
        inputString += ptr.val;
        ptr = ptr.next;
    }    
    else{
    if((ptr.next != null && !ptr.next.bracket) || ptr.next == null){
        ptr.reverse();
        inputString += ptr.val;
        ptr = ptr.next;
    }
    else if(ptr.next != null){
        ListString nextptr = ptr.next;
        ListString newptr = ptr;
        while(nextptr.next != null && nextptr.next.bracket){
            newptr = nextptr;
            nextptr = nextptr.next;
        }
        nextptr.reverse();
        newptr.val += nextptr.val;
        newptr.next = nextptr.next;
    }
    }
}
return inputString;
}

public class ListString {
    String val;
    boolean bracket;
    ListString next;
    
    ListString(String val, boolean bracket){
        this.val = val;
        this.bracket = bracket;
    }
    
    public void reverse(){
        char ch[]=val.toCharArray();  
        String rev="";  
        for(int i=ch.length-1;i>=0;i--){  
            rev+=ch[i];  
        }
        val = rev;  
    }
}
