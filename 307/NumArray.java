public class NumArray {
	private int[] tree;
    private int[] array;
    public NumArray(int[] nums) {
        tree = new int[nums.length+1];
        array = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }
    
    public void update(int i, int val) {
        int diff = val-array[i+1];
        for(int k = i+1; k < tree.length; k += (k&-k)) {
            tree[k] += diff;
        }
        array[i+1] = val;
    }
    
    public int sumRange(int i, int j) {
        return getSum(j+1)-getSum(i);
    }
    
    private int getSum(int i){
        int ans = 0;
        for(int k = i; k > 0; k -= (k&-k)) {
            ans += tree[k];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,5};
        NumArray obj = new NumArray(nums);
        int param_1 = obj.sumRange(0,2);
        System.out.println(param_1);
        obj.update(1,2);
        int param_2 = obj.sumRange(0,2);
        System.out.println(param_2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */