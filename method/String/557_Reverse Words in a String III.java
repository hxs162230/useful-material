557. Reverse Words in a String III
Easy

737

74

Favorite

Share
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
class Solution {
    public String reverseWords(String s) {
        String[] word = s.split("\\ ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length;i++){
            word[i] = new StringBuilder(word[i]).reverse().toString();
        }
        for(int i=0;i<word.length;i++){
            sb.append(word[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}