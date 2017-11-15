class Solution:
    """
    @param: nums: A set of numbers
    @return: A list of lists
    """

    def subsets(self, nums):
    # write your code here
    # check the edge of input
        if nums is None:
            return None

        self.results = []

        # if len(nums) == 0:
        #     return self.results.append([])

        self.helper(0, [], sorted(nums))

        return self.results

    def helper(self, position, subWord, nums):
        if position == len(nums):
            self.results.append(subWord)
            return

        self.helper(position + 1, subWord + [nums[position]], nums)
        self.helper(position + 1, subWord, nums)
        # for index in range(position, len(nums) - 1):
        #     subWord.append(nums[position])
        #     self.helper(position + 1, subWord, nums, result)
        #     subWord.remove(len(subWord) - 1)