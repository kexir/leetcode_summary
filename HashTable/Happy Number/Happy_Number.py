class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        dict_buff = {}
        while True:
            dict_buff[n] = True;
            n = sum(int(x)*int(x) for x in list(str(n)));
            if n == 1 or n in dict_buff:
                break;
        return n == 1;