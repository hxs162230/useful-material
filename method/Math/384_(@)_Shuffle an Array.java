384. Shuffle an Array

洗牌的正確姿勢

https://yjk94.wordpress.com/2017/03/17/%E6%B4%97%E7%89%8C%E7%9A%84%E6%AD%A3%E7%A1%AE%E5%A7%BF%E5%8A%BF-knuth-shuffle%E7%AE%97%E6%B3%95/

Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

class Solution {
    private int[] nums;
    public Solution(int[] nums) {
        this.nums=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr=new int[nums.length];
        Random rand = new Random(); 
        for(int i=0;i<nums.length;i++)
            arr[i]=nums[i];
        for(int i=0;i<nums.length;i++){
            int idx = rand.nextInt(i+1); //Knuth洗牌算法
                int tmp = arr[idx];
                arr[idx]=arr[i];
                arr[i]=tmp;
        }
        return arr;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */