394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

T:O(N)
S:O(N)


class Solution {
    public String decodeString(String s) {
        Stack<Integer> numstk = new Stack<>();
        Stack<String> stk =new Stack<>();
        int n=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                n=n*10+c-'0';
            }
            else if(c=='['){
                numstk.push(n);
                n=0;
                stk.push(sb.toString());
                sb=new StringBuilder();
            }
            else if(c==']'){
                StringBuilder pre = new StringBuilder(stk.pop());
                StringBuilder cur = new StringBuilder();
                int k = numstk.pop();
                while(k-->0) cur.append(sb.toString());
                pre.append(cur.toString());
                sb = pre;
            }
            else
                sb.append(c);
        }
        return sb.toString();
    }
}