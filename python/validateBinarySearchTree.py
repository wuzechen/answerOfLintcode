"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""
import sys

class resultType:
    def __init__(self, isBst, min, max):
        self.isBst = isBst
        self.min = min
        self.max = max

class Solution:
    """
    @param: root: The root of binary tree.
    @return: True if the binary tree is BST, or false
    """
    def isValidBST(self, root):
        # write your code here
        return self.helper(root).isBst


    def helper(self, root):
        if root is None:
            return resultType(True, sys.maxsize, -sys.maxsize)

        left = self.helper(root.left)
        right = self.helper(root.right)

        if not left.isBst or not right.isBst:
            return resultType(False, 0, 0)

        if root.left is not None and left.max >= root.val or root.right is not None and right.min <= root.val:
            return resultType(False, 0, 0)

        return resultType(True, min(left.min, root.val), max(right.max, root.val))