class TrieNode {
    private final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }
}

public class Test41 {
    private TrieNode root;

    public Test41() {
        root = new TrieNode();
    }

    public void insert(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public boolean search(String key) {
        TrieNode pCrawl = root;
        for (int level = 0; level < key.length(); level++) {
            int index = key.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                return false;
            }
            pCrawl = pCrawl.children[index];
        }
        return (pCrawl != null && pCrawl.isEndOfWord);
    }

    public boolean isLastNode(TrieNode root) {
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public void suggestionsRec(TrieNode node, StringBuilder currentPrefix) {
        if (node.isEndOfWord) {
            System.out.println(currentPrefix);
        }
        if (isLastNode(node)) {
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                currentPrefix.append((char) (97 + i));
                suggestionsRec(node.children[i], currentPrefix);
                currentPrefix.deleteCharAt(currentPrefix.length() - 1);
            }
        }
    }

    public int printAutoSuggestions(String query) {
        TrieNode pCrawl = root;
        int length = query.length();
        for (int level = 0; level < length; level++) {
            int index = query.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                System.out.println("No suggestions available for prefix");
                return 0;
            }
            pCrawl = pCrawl.children[index];
        }
        boolean isWord = (pCrawl.isEndOfWord == true);
        boolean isLast = isLastNode(pCrawl);
        if (isWord && isLast) {
            System.out.println(query);
            return -1;
        }
        if (!isLast) {
            StringBuilder prefix = new StringBuilder(query);
            suggestionsRec(pCrawl, prefix);
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Test41 trie = new Test41();
        trie.insert("hello");
        trie.insert("hell");
        trie.insert("helicopter");
        trie.insert("helix");
        trie.insert("hero");

        //String query = "hell";
        String query = "h";
        System.out.println("Suggestions for prefix \"" + query + "\":");
        trie.printAutoSuggestions(query);
    }
}
