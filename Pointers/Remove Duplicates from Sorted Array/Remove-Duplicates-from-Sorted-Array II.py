class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        end = 0
        for i in range(len(nums)):
            if i >= 2 and nums[i] == nums[end-2]:
                continue
            nums[end] = nums[i]
            end += 1
            
        return end

    def removeDuplicates2(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 2: return len(nums)
        
        end = 2
        for n in nums[2:]:
            if n > nums[end-2]:
                nums[end] = n
                end += 1
        
        return end