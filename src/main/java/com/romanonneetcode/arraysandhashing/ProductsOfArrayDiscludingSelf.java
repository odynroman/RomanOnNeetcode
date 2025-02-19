package com.romanonneetcode.arraysandhashing;

/**
 * <a href="https://neetcode.io/problems/products-of-array-discluding-self">https://neetcode.io/problems/products-of-array-discluding-self</a>
 */
public class ProductsOfArrayDiscludingSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        int[] post = new int[nums.length];

        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }

        post[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            post[i - 1] = post[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * post[i];
        }

        return res;
    }

    public static void main(String[] args) {
        ProductsOfArrayDiscludingSelf solution = new ProductsOfArrayDiscludingSelf();
        int[] result = solution.productExceptSelf(new int[]{-1, 0, 1, 2, 3});
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
