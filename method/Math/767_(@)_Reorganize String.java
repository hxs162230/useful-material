767. Reorganize String

Given a string S, check if the letters can be rearranged 

so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

下面这种解法的原理和上面的很类似，就是写法上很秀，堪比陈独秀。
这里使用了一个长度为26的一位数组cnt来代替上面的HashMap进行统计字母的出现次数，
然后比较秀的一点是，把上面的映射对儿压缩成了一个整数，做法是将次数乘以了100，
再加上当前字母在一位数字中的位置坐标i，这样一个整数就同时encode了次数和对应字母的信息了，
而且之后decode也很方便。数组cnt更新好了后，需要排个序，
这一步就是模拟上面解法中最大堆的自动排序功能。不过这里是数字小的在前面，
即先处理出现次数少的字母。这里除了和上面一样检测次数不能大于总长度的一半的操作外，
还有一个小trick，就是构建字符串的时候，是从第二个位置开始的。
这里我们构建的字符串是直接对原字符串S进行修改的，因为cnt数组建立了之后，字符串S就没啥用了。
我们用一个变量idx来表示当前更新字母的位置，初始化为1，表示我们要从第二个位置开始更新。
因为出现次数最多的字母一定要占据第一个位置才行，这就是我们留出第一个位置的原因。
这里很叼的一点，就是隔位更新，这样能保证相同的字母不相邻，而且当idx越界后，拉回到起始位置0，
这就有点遍历循环数组的感觉。举个栗子来说吧，比如"aaabbc"，我们的更新顺序为：
_ c _ _ _ _

_ c _ b _ _

_ c _ b _ b

a c _ b _ b

a c a b _ b

a c a b a b

#621

class Solution {
    public String reorganizeString(String S) {
        int len = S.length();
        int ini_idx = 1;
        char[] arr = S.toCharArray();
        int[] cnt = new int[26];
        for(int i=0;i<len;i++){
            cnt[S.charAt(i)-'a']+=100;
        }
        for(int i=0;i<=25;i++){
            cnt[i]+=i;
        }
        Arrays.sort(cnt);
        for(int i=0;i<=25;i++){
            int size = cnt[i]/100;
            char ch = (char)('a' + (cnt[i]%100));
            if(size>(len+1)/2) return "";
            for(int j=0;j<size;j++){
                if(ini_idx>len-1) ini_idx = 0;
                arr[ini_idx] = ch;
                ini_idx+=2;
            }
        }
        return String.valueOf(arr);
    }
}