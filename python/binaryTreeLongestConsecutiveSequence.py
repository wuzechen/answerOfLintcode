"""
Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
"""


class Solution:
    """
    @param: root: the root of binary tree
    @return: the length of the longest consecutive sequence path
    """
    def longestConsecutive(self, root):
        # write your code here
        self.max = 1
        self.helper(root)

        return self.max

    def helper(self, root):
        if root is None:
            return 0

        left = self.helper(root.left)
        right = self.helper(root.right)

        if left == 0 and right == 0:
            return 1

        if left > 0 and left > right and root.val + 1 == root.left.val:
            if left + 1 > self.max:
                self.max = left + 1

            return left + 1

        if right > 0 and right > left and root.val + 1 == root.right.val:
            if right + 1 > self.max:
                self.max = right + 1

            return right + 1

        if left > 0 and left == right and root.val + 1 == root.left.val:
            if left + 1 > self.max:
                self.max = left + 1

            return left + 1

        return 1

