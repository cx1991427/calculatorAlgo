import java.util.*;

public class Solution {
   public int calculate(String infix){
	   
	   String postfix = infix2Postfix(infix);
	   
	   int res = evaluatePostfixExpression(postfix);
	   
	   return res;
   }
   private String infix2Postfix(String str){
	   Stack<Character> stack = new Stack<>();
	   StringBuilder sb = new StringBuilder();
	   
	   for(int i = 0; i < str.length(); i++){
		   char ch = str.charAt(i);
		   
		   if(ch >= '0' && ch <= '9' ){  //Character.isDigit(ch)
			   sb.append(ch);
		   }else if(ch == '('){
			   stack.push(ch);
		   }else if(ch == ')'){
			   while(stack.peek() != '('){
				   sb.append(stack.pop());
			   }
			   stack.pop();
			   sb.append(" ");
		   }else{
			   while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()) ){
				   sb.append(stack.pop());
			   }
			   stack.push(ch);
			   sb.append(" ");
		   }
	   }
	   while(!stack.isEmpty()){
		   sb.append(stack.pop());
	   }
	 return sb.toString();  
   } 
   
   private int precedence(Character c){
	   Map<Character, Integer> map = new HashMap<>();
	   map.put('(', 0);
	   
	   map.put('+', 1);
	   map.put('-', 1);
	   map.put('*', 2);
	   map.put('/', 2);
	   
	   map.put('^', 3);
	   
	   return map.get(c);
   }
   
   private int evaluatePostfixExpression(String str){
	   Stack<Integer> stack = new Stack<>();
	   int num = 0;
	   
	   for(int i = 0; i < str.length(); i++){
		   char ch = str.charAt(i);
		
		   if(ch >= '0' && ch <= '9'){
			   num = num*10 + ch-'0';
		   }else{
			   if(num != 0){
				   stack.push(num);
				   num = 0;
			   }	  
			 
			   if( ch == ' '){
				   continue;
			   }else if(ch == '+'){
				   int right = stack.pop();
				   int left = stack.pop();
				   stack.push(left + right);
			   }else if(ch == '-'){
				   int right = stack.pop();
				   int left = stack.pop();
				   stack.push(left - right);
			   }else if(ch == '*'){
				   int right = stack.pop();
				   int left = stack.pop();
				   stack.push(left * right);
			   }else if(ch == '/'){
				   int right = stack.pop();
				   int left = stack.pop();
				   stack.push(left / right);
			   }
		   }
	   }
	   return stack.pop();
   }
}
