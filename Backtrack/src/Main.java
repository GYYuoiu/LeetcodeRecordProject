import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LC_126 s = new LC_126();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wl = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<String>(){
            {
                add("hot");
                add("dot");
                add("dog");
                add("lot");
                add("log");
                add("cog");
            }
        };
        s.findLadders(beginWord, endWord, wordList);
    }
}
