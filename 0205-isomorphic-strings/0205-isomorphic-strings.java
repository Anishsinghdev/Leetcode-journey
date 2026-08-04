class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Character>fristvalue = new HashMap<>();
        Map<Character,Character>secondvalue = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if(fristvalue.containsKey(ch1)){
                if(fristvalue.get(ch1) != ch2){
                    return false;
                }
                }else{
                    fristvalue.put(ch1,ch2);
                }
            if(secondvalue.containsKey(ch2)){
                if(secondvalue.get(ch2) != ch1){
                    return false;
                }
            }
            else{
                secondvalue.put(ch2,ch1);
            }
        }
        return true;
    }
}