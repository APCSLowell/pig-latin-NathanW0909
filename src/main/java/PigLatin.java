public class PigLatin {

    public void tester() {
        String[] lines = {"beast", "dough", "happy", "question", "star", "three", "eagle", "try"};
        System.out.println("there are " + lines.length + " lines");
        for (String line : lines) {
            System.out.println(pigLatin(line));
        }
    }

    public int findFirstVowel(String sWord) {
        String vowels = "aeiou";
        sWord = sWord.toLowerCase(); // Handle case sensitivity
        for (int i = 0; i < sWord.length(); i++) {
            if (vowels.contains(Character.toString(sWord.charAt(i)))) {
                return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        if (sWord == null || sWord.isEmpty()) {
            return ""; // Handle empty strings
        }
        sWord = sWord.toLowerCase(); // Handle case sensitivity
        int firstVowel = findFirstVowel(sWord);

        if (firstVowel == -1) {
            return sWord + "ay"; // Rule 1
        }

        if (firstVowel == 0) {
            return sWord + "way"; // Rule 2
        }

        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay"; // Rule 3
        }

        return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay"; // Rule 4
    }
}
