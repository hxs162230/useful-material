1153. String Transforms Into Another String
Hard

267

77

Add to List

Share
Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2.

 

Example 1:

Input: str1 = "aabcc", str2 = "ccdee"
Output: true
Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
Example 2:

Input: str1 = "leetcode", str2 = "codeleet"
Output: false
Explanation: There is no way to transform str1 to str2.
 

Note:

1 <= str1.length == str2.length <= 10^4
Both str1 and str2 contain only lowercase English letters.


// I would recommend putting two words in two columns vertically, something like this,

// s1="ace", s2="cea", draw arrows between each transformation
// key  -> value
// a    ->    c
// c    ->    e
// e    ->    a
// If a value shows up later as a key, then it makes a linkedlist structure,
// and if a value has already been a key, then there is a cycle (in this case, the last "a" is the key in the first row).

// For linkedlist without cycle we can just backward substitute the key with the value, there exists a way of converting s1 to s2 for sure.
// For linkedlist with a cycle, such as "a -> c -> e -> a", we need to break the loop and use a temporary variable to cache the point of break,
// in this case, it becomes the transformation with two steps: "a -> tmp" and "tmp -> c -> e -> a".
// Now the bottleneck is if we can find a temporary variable to carry the conversion, if there is one, then the conversion is viable.

class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.length()!=str2.length()) return false;
        if(str1.equals(str2)) return true;
        HashMap<Character,Character> map = new HashMap<>();
        for(int i=0;i<str1.length();i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            //out degree = 1
            if(map.containsKey(c1)&&map.get(c1)!=c2) return false;
            map.put(c1,c2);
        }
        return new HashSet<Character>(map.values()).size()<26;
    }
}