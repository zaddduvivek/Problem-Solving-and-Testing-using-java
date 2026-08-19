lass Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean matches(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char wChar = word.charAt(i);
            char pChar = pattern.charAt(i);

            if (m1.containsKey(wChar) && m1.get(wChar) != pChar) {
                return false;
            }
            if (m2.containsKey(pChar) && m2.get(pChar) != wChar) {
                return false;
            }

            m1.put(wChar, pChar);
            m2.put(pChar, wChar);
        }

        return true;
    }
}
