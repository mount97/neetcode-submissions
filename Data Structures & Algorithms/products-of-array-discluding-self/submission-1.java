class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int replacement = 1;
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            nums[i] = replacement;
            int product = Arrays.stream(nums).reduce(1, (x, y) -> x * y);
            products[i] = product;
            nums[i] = original;
        }
        return products;
    }
}  
