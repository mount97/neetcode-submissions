class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int prefixProduct = 1;

        // at the index of the first number, skip the product (cause it's the first index, 
        // so it does not have prefix product, and 1 is implicit as ignoring)
        prefix[0] = 1;
        // loop the arrays from the second index to the end
        // the value to store at current index is the prefix product of it's the prefix numbers
        // like:
        // index = 1 -> prefix product = nums[0] * 1
        // index = 2 -> prefix product = nums[1] * prefix product
        // index = 3 -> prefix product = nums[2] * prefix product
        
        // then we do the same things but in reverse for suffix product array

        // So, after all, what it is:
        // At index 0 of the result array, we have to calculate the product of
        // nums[1] * num[2] * ... * nums[n - 1] from the original array
        // -> in prefix array, we have the value at this index is 1
        // -> in suffix array, we have the value at this index is suffix product of num[2] (suffix product of num[2]
        // is equal to suffix product of num[3], and so on, util the suffix product of num[n - 1] as we calculated)

        // Move to index 1 of the result array, we have to calculate the product of
        // nums[0] * num[2] * ... * nums[n - 1] from the original array
        // -> in prefix array, we have the value at this index is prefix product of nums[1] (and it equals to num[0] * 1)
        // -> in suffix array, we have the value at this index is suffix product of num[3] (suffix product of num[3]
        // is equal to suffix product of num[4], and so on, util the suffix product of num[n - 1] as we calculated)

        // finally, the value at index i of the result array = prefix[i] * suffix[i]
        // simply we had the prefix product of the number at index [i] in prefix array
        // and the suffix product in suffix array, then we just need to multiply them
        
        for (int i = 1; i < nums.length; i++) {
            prefixProduct *= nums[i - 1];
            prefix[i] = prefixProduct;
        }

        int suffixProduct = 1;
        suffix[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixProduct *= nums[i + 1];
            suffix[i] = suffixProduct;
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }
        return result;
    }
}  
