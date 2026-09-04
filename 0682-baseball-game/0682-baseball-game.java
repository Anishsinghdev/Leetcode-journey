class Solution {
    public int calPoints(String[] operations) {
        int sum = 0;
        Stack<Integer>st = new Stack<>();
        for(int i= 0;i<operations.length;i++){
             if(operations[i].equals("+")){
                int a = st.pop();
                int b = st.pop();
                int sumab = a+b;
                st.push(b);
                st.push(a);
                st.push(sumab);
            }
            else if(operations[i].equals("D")){
                int mul = st.pop();
                int multiply2 = mul*2;
                st.push(mul);
                st.push(multiply2);

            }
            else if(operations[i].equals("C")){
                st.pop();
            }
            else{
                int num = Integer.parseInt(operations[i]);
                st.push(num);
            }
        }
        while(!st.empty()){
            int value = st.pop();
            sum += value;
        }
        return sum;
    }
}