68. Text Justification

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lst =new ArrayList<>();
        int i=0,j=0;
        int len=0;
        while(i<words.length){
            j=i;
            len=0;
            while(j<words.length&&(len+words[j].length()+j-i)<=maxWidth){
                len+=words[j++].length();
            }
            int space = maxWidth - len;
            StringBuilder sb = new StringBuilder();
            
            int tmp=0;
            for(int k=i;k<j;k++){
                    
                sb.append(words[k]);
                if(space>0){    
                if(j==words.length){
                        if(j-1-k==0) tmp=space; 
                        else tmp=1;
                    }
                    else{
                        if(j-1-k>0){
                            if(space%(j-1-k)==0) tmp= space/(j-1-k);
                            else tmp= space/(j-1-k)+1;
                        }
                        else
                            tmp= space;
                    }
                    space-=tmp;
                    while(tmp-->0) sb.append(" ");
                }
            }
            lst.add(sb.toString());
            i=j;
        }
        return lst;
    }
}