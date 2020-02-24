187. Repeated DNA Sequences

All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, 

for example: "ACGAATTCCG". When studying DNA, 

it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) 

that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

method rolling hash
A: 0100 0001　　C: 0100 0011　　G: 0100 0111　　T: 0101 0100  ASCII
T:O(N)
S:O(N)


//logic flow////////////////////////
mask  = 00 (30 x 1s) = 0x7fffffff; 
res = (res<<3) | (charAt(i)&7)
from and to init 0-8;
HashMap 
for(int i=9;;i++){
    (res&mask) << 3 | charAt(i)&7
};
return lst
////////////////////////////////////

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        int mask = 0x7ffffff;                               6*4+3 = 27(bits)
        int cur = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        List<String> lst = new ArrayList<>();
        if(s.length()<10) return lst;
        for(int i=0;i<9;i++){
            cur=(cur<<3)|(s.charAt(i)&7);
        }
        for(int i=9;i<s.length();i++){
            cur = (cur&mask)<<3 | s.charAt(i)&7;
            if(!map.containsKey(cur))
                map.put(cur,1);
            else{
                if(map.get(cur)==1) lst.add(s.substring(i-9,i+1));
                
                map.put(cur,map.get(cur)+1);
            }
                
        }
        return lst;
    }
}