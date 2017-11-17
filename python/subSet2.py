from functools import reduce

class Solution:
    def subsetsWithDup(self, nums):
        # write your code here
        nums.sort()
        p = [[nums[position] for position in range(len(nums)) if i>>position&1] for i in range(2**len(nums))]
        func = lambda x,y:x if y in x else x + [y]
        p = reduce(func, [[], ] + p)
        return list(reversed(p))