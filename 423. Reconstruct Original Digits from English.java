[200~423. Reconstruct Original Digits from English
Medium

497

1529

Add to List

Share
Given a string s containing an out-of-order English representation of digits 0-9, return the digits in ascending order.

 

 Example 1:

 Input: s = "owoztneoer"
 Output: "012"
 Example 2:

 Input: s = "fviefuro"
 Output: "45"
  

  Constraints:

  1 <= s.length <= 105
  s[i] is one of the characters ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"].
  s is guaranteed to be valid.




  class Solution {
    public String originalDigits(String s) {
        // one          ----> o
        // two  ----> w
        // three        ----> h
        // four ----> u
        // five         ----> f
        // six  ----> x
        // seven        ----> s
        // eight ---> g
        // nine
        // zero ----> z
        HashMap<Character,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int[] ans = new int[10];


        while(map.containsKey('w')){
            ans[2]++;
            remove("two",map);
        }
        while(map.containsKey('u')){
            ans[4]++;
            remove("four",map);
        }
        while(map.containsKey('x')){
            ans[6]++;
            remove("six",map);
        }
        while(map.containsKey('g')){
            ans[8]++;
            remove("eight",map);
        }
        while(map.containsKey('z')){
            ans[0]++;
            remove("zero",map);
        }
        while(map.containsKey('o')){
            ans[1]++;
            remove("one",map);
        }
        while(map.containsKey('h')){
            ans[3]++;
            remove("three",map);
        }
        while(map.containsKey('f')){
            ans[5]++;
            remove("five",map);
        }
        while(map.containsKey('s')){
            ans[7]++;
            remove("seven",map);
        }
        while(map.containsKey('n')){
            ans[9]++;
            remove("nine",map);
        }

        for(int i=0;i<ans.length;i++){
            // System.out.println(ans[i]);
            while(ans[i]>0){
                sb.append(i);
                ans[i]--;
            }
        }

        return sb.toString();
    }
    public void remove(String s,HashMap<Character,Integer> map){

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if((map.get(s.charAt(i))==0)) map.remove(s.charAt(i));
            }
        }

    }
}
