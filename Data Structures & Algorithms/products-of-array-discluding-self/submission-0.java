class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int totalProduct = 1;
        int totalExcludingZeroProduct = 1;
        int numberOfZeroNumber = 0;

        for (int num : nums) {
            if (num == 0) {
                totalProduct = 0;
                numberOfZeroNumber++;
            } else {
                totalProduct *= num;
                totalExcludingZeroProduct *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (numberOfZeroNumber == 0) {
                products[i] = totalProduct / nums[i];
            } else if (numberOfZeroNumber == 1) {
                products[i] = nums[i] == 0 ? totalExcludingZeroProduct : 0;
            } else break;
        }
        
        return products;
    }
}  
