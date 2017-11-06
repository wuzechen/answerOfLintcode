public class Solution {
    /*
     * @param source: source string to be scanned.
     * @param target: target string containing the sequence of characters to match
     * @return: a index to the first occurrence of target in source, or -1  if target is not part of source.
     */
    public int strStr(String source, String target) {
        int result = -1;
        //1.check the edge of the param
        if (source == null || target == null) {
            return result;
        }
        
        if (source.length() < target.length()) {
            return result;
        }
        
        if (source == "" || target == "") {
            return 0;
        }
        
        //2.loop the source str
        for (int i = 0; i < source.length(); i++) {
            //skip when head is not equal
            if (source.charAt(i) != target.charAt(0)) {
                continue;
            } else {
                //when head is equal then loop the target str
                int flag = 0;
                for (int j = 1; j < target.length(); j++) {
                    if (source.length() - i < target.length()) {
                        return result;
                    } else {
                        if (source.charAt(i + j) == target.charAt(j)) {
                            flag++;
                            continue;                        
                        } else {
                            break;
                        }
                    }
                    
                }
                //log the loaction of source str when all target str is fitting
                if (flag == target.length() - 1) {
                    result = i;
                    break;
                }
            }
        }
        
        //return the result
        return result;
    }
}