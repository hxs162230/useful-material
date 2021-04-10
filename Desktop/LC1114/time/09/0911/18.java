class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lol = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int left=j+1;
                int right=nums.length-1;
                int t = target-nums[i]-nums[j];
                while(left<right){
                    if(nums[left]+nums[right]<t){
                        left++;
                    }
                    else if(nums[left]+nums[right]>t){
                        right--;
                    }
                    else{
                        lol.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                }
                while(j+1<nums.length-2 && nums[j]==nums[j+1]) j++;
            }
            while(i+1<nums.length-3 && nums[i]==nums[i+1]) i++;
        }
        return lol;
    }
}