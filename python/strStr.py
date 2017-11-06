class Solution:
    """
    @param: source: source string to be scanned.
    @param: target: target string containing the sequence of characters to match
    @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
    """

    def strStr(self, source, target):
        result = -1
        # first check the edge of the param
        if source == None or target == None:
            return result

        if len(source) < len(target):
            return result

        if source == "" or target =="":
            return 0

        # then loop the source string
        for i in range(len(source)):
            if source[i] == target[0]:
                # check the length is not over the source
                if len(source) - i >= len(target):
                    flag = 0
                    #loop the target string
                    for j in range(1,len(target)):
                        if source[i + j] == target[j]:
                            flag += 1
                            continue
                        else:
                            break
                    if flag == len(target) - 1:
                        result = i
                        return result
                else:
                    return result
            else:
                continue
        return result
