class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        dict = {}
        ans = []
        for word in strs:
            key = ''.join(sorted(word))
            if key not in dict:
                dict[key] = [word]
            else:
                dict[key] += [word]
        for item in dict:
            ans.append(dict[item])
            print ans
        

if __name__ == "__main__":
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    Solution().groupAnagrams(strs)