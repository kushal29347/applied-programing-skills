import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        
        // Split path by slashes '/'
        String[] components = path.split("/");
        
        for (String dir : components) {
            // Ignore empty strings (from consecutive slashes) and current directory '.'
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            }
            
            // Go up one directory level for '..'
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory or file name (including '...', '....', etc.)
                stack.push(dir);
            }
        }
        
        // Construct the canonical path
        StringBuilder result = new StringBuilder();
        
        // ArrayDeque iterates from bottom to top (oldest to newest) when using descendingIterator
        var it = stack.descendingIterator();
        while (it.hasNext()) {
            result.append("/").append(it.next());
        }
        
        // Return "/" if stack was empty, otherwise return the joined string
        return result.length() == 0 ? "/" : result.toString();
    }
}