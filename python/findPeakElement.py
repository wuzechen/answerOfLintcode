class Solution:
    """
    @param: A: An integers array.
    @return: return any of peek positions.
    """

    def findPeak(self, A):
        #first check the edge of input
        if A is None:
            return -1

        if len(A) < 3:
            return -1

        head = 1
        tail = len(A) - 2

        while head < tail - 1:
            mid = (head + tail ) / 2
            if A[mid] < A[mid - 1]:
                head = mid
            else:
                tail = mid

        if A[head] < A[tail]:
            return tail
        else:
            return head