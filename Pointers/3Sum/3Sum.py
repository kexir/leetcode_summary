class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums.sort()
        ans = []
        for i in range(0, len(nums)-2):
        	if i and nums[i] == nums[i-1]:
        		continue
        	left = i+1
        	right = len(nums)-1
        	while left < right:
        		if nums[left] + nums[right] + nums[i] == 0:
        			ans.append([nums[i], nums[left], nums[right]])
        			left += 1
        			right -= 1
        			while left < right and nums[left] == nums[left-1]:
        				left += 1
        			while left < right and nums[right] == nums[right+1]:
        				right -= 1
        		elif nums[left] + nums[right] + nums[i] < 0:
        			left += 1
        		elif nums[left] + nums[right] + nums[i] > 0:
        			right -= 1

        return ans
        
if __name__ == "__main__":
	print Solution().threeSum([-1, 0, 1, 2, -1, -4])