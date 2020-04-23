1268. Search Suggestions System
Medium

191

63

Add to List

Share
Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return list of lists of the suggested products after each character of searchWord is typed. 

 

Example 1:

Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
Output: [
["mobile","moneypot","monitor"],
["mobile","moneypot","monitor"],
["mouse","mousepad"],
["mouse","mousepad"],
["mouse","mousepad"]
]
Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
Example 2:

Input: products = ["havana"], searchWord = "havana"
Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
Example 3:

Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
Example 4:

Input: products = ["havana"], searchWord = "tatiana"
Output: [[],[],[],[],[],[],[]]
 

Constraints:

1 <= products.length <= 1000
There are no repeated elements in products.
1 <= Σ products[i].length <= 2 * 10^4
All characters of products[i] are lower-case English letters.
1 <= searchWord.length <= 1000
All characters of searchWord are lower-case English letters.


class Solution {
    class Trie{
        Trie[] children;
        TreeSet<String> wordSet;
        public Trie(){
            this.children = new Trie[26];
            this.wordSet = new TreeSet<>();
        }
    }
    Trie root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Trie();
        buildTrie(products);
        // for(String s:root.children['m'-'a'].wordSet)
        //     System.out.print(s+" ");
        Trie cur = root;
        List<List<String>> lol = new ArrayList<List<String>>();
        for(char c : searchWord.toCharArray()){
            //System.out.print(c);
            if(cur==null||cur.children[c-'a']==null){
                lol.add(new ArrayList<>());
                cur=null;
                continue;   
            }
            cur = cur.children[c-'a'];
            if(cur.wordSet.size()<3){
                lol.add(new ArrayList<>(cur.wordSet));
            }
            else{
                Iterator<String> iter = cur.wordSet.iterator();
                String x = iter.next();
                String y = iter.next();
                String z = iter.next();
                lol.add(Arrays.asList(x,y,z));
            }
        }
        return lol;
    }
    
    private void buildTrie(String[] products){
        Trie cur = root;
        for(String product:products){
            cur = root;
            for(char c:product.toCharArray()){
                if(cur.children[c-'a']==null) cur.children[c-'a'] = new Trie();
                cur = cur.children[c-'a'];
                cur.wordSet.add(product);
            }
        }
    }
}