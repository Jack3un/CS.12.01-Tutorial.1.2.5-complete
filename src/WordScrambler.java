public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArray) {
        scrambledWords = mixedWords(wordArray);
    }

    private String recombine(String word1, String word2) {
        if (word1.contains(" ") || word2.contains(" ")) {
            throw new IllegalArgumentException("Word Array must contain single words only! Attack on Titan contains more than one word!");
        }
        String halfWord1 = word1.substring(0, word1.length()/2);
        String halfWord2 = word2.substring(word2.length()/2, word2.length());
        return halfWord1 + halfWord2;
    }

    private String[] mixedWords(String[] words) {
        if (words.length % 2 == 1) {
            throw new IllegalArgumentException("Word Array must contain an even number of elements");
        }
        String[] answer = new String[words.length];
        for (int i = 0; i < words.length; i += 2) {
            answer[i] = recombine(words[i], words[i+1]);
            answer[i+1] = recombine(words[i+1], words[i]);
        }
        return answer;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}