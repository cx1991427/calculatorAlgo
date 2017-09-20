import java.util.*;


//111 23+ 456 678 789 * -  10+
//

class Solution {
   public static void main(String[] args){
	   String str = "111+23-45*(678/789+10)-23";
	   String str2 = "(5/9)";
	   System.out.println(infix2Postfix(str));
   }
   
   public static int calculator(String infix){
	   
	   String postfix = infix2Postfix(infix);
	   
	   int res = evaluatePostfixExpression(postfix);
	   
	   return res;
   }
//   111+23-456*(678/789)+10
//111 23+ 456 678 789/ *- 10
//+
   private static String infix2Postfix(String str){
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
   
   private static int precedence(Character c){
	   Map<Character, Integer> map = new HashMap<>();
	   map.put('(', 0);
	   
	   map.put('+', 1);
	   map.put('-', 1);
	   map.put('*', 2);
	   map.put('/', 2);
	   
	   map.put('^', 3);
	   
	   return map.get(c);
   }
   
   private static int evaluatePostfixExpression(String str){
	   
	   return 0;
   }
}
