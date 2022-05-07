import java.util.*;

public class LC_126 {
    List<List<String>> res;
    List<String> path;
    Map<String, Integer> map;
    List<Set<String>> adj;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        res = new ArrayList<>();
        map = new HashMap<>();
        for(int i = 0; i < wordList.size(); i ++){
            map.put(wordList.get(i), i);
        }
        if(!map.containsKey(endWord))  return res;
        if(!map.containsKey(beginWord)){
            wordList.add(wordList.size(), beginWord);
            map.put(beginWord, wordList.size() - 1);
        }
        // BFS 求 最短路径下的 AdjacencyArray
        adj = new ArrayList<>();
        for(int i = 0; i < map.size(); i ++){
            adj.add(new HashSet<String>());
        }
        Queue<String> queue = new LinkedList<>();
        int[] level = new int[map.size()];
        queue.offer(beginWord);
        level[map.get(beginWord)] = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                String curStr = queue.poll();
                Set<String> set = adj.get(map.get(curStr));
                StringBuffer nxt = new StringBuffer(curStr);
                for(int k = 0; k < curStr.length(); k ++){
                    for(int j = 0; j < 26; j ++){
                        nxt.setCharAt(k, (char)('a' + j));
                        String nxtStr = nxt.toString();
                        if(map.containsKey(nxtStr)){
                            if(level[map.get(nxtStr)] == 0){
                                queue.offer(nxtStr);
                                level[map.get(nxtStr)] = level[map.get(curStr)] + 1;
                            }
                            if(level[map.get(nxtStr)] > level[map.get(curStr)]){
                                set.add(nxtStr);
                            }
                        }
                        nxt.setCharAt(k, curStr.charAt(k));
                    }
                }
            }
        }
        // DFS
        path = new ArrayList<>();
        path.add(beginWord);
        backtrack(beginWord, endWord);
        return res;
    }

    public void backtrack(String p, String end){
        if(p.equals(end)){
            res.add(new ArrayList(path));
            return;
        }
        for(String nxt : adj.get(map.get(p))){
            path.add(nxt);
            backtrack(nxt, end);
            path.remove(path.size() - 1);
        }
    }
}
