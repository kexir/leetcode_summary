class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        hash = {}
        for i in range(len(nums)):
        	if nums[i] in hash:
        		return [hash[nums[i]], i]
        	hash[target - nums[i]] = i 
        return [-1, -1]

    def twoSum2(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if(len(nums) == 0):
        	return False;
        k = 0
        for i in range(len(nums)):
        	k += 1
        	j = target - nums[i]
        	temp = nums[k:]
        	if j in temp:
        		return [i, temp.index(j) + k]
        	
        return False
        
if __name__ == '__main__':
    print Solution().twoSum2([3,2,4], 6)
    	 
