public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
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

    public int suggestionsRec(TrieNode node, StringBuilder currentPrefix) {
        int count = 0;
        if (node.isEndOfWord) {
            System.out.println(currentPrefix);
            count++;
        }
        if (isLastNode(node)) {
            return count;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                currentPrefix.append((char) (97 + i));
                count += suggestionsRec(node.children[i], currentPrefix);
                currentPrefix.deleteCharAt(currentPrefix.length() - 1);
            }
        }
        return count;
    }

    public int printAutoSuggestions(String query) {
        int count = 0;
        TrieNode pCrawl = root;
        int length = query.length();
        for (int level = 0; level < length; level++) {
            int index = query.charAt(level) - 'a';
            if (pCrawl.children[index] == null) {
                System.out.println("No suggestions available for prefix");
                return count;
            }
            pCrawl = pCrawl.children[index];
        }
        boolean isWord = (pCrawl.isEndOfWord == true);
        boolean isLast = isLastNode(pCrawl);
        if (isWord && isLast) {
            System.out.println(query);
            count = -1;
            return count;
        }
        if (!isLast) {
            StringBuilder prefix = new StringBuilder(query);
            count = suggestionsRec(pCrawl, prefix);
            return count;
        }
        return count;
    }

    public static void main(String[] args) {
        Test41_2 trie = new Test41_2();
        trie.insert("cab");
        trie.insert("cabala");
        trie.insert("cabin");
        trie.insert("cell");
        trie.insert("cedar");
        trie.insert("chronic");
        trie.insert("catharsis");
        trie.insert("cataclysm");
        trie.insert("category");
        trie.insert("caterpillar");
        //trie.insert("Target");

        //String query = "hell";
        //String query = "cate";
        String query = "cate";
        //System.out.println("Suggestions for prefix \"" + query + "\":");
        System.out.println("Number of lines that start with a prefix '" + query + "':" + trie.printAutoSuggestions(query));




    }





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
}
