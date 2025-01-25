public class PigLatin {
    
    public void tester() {
        String[] lines = new String[8]; 
        try {
            File myFile = new File("words.txt");
            Scanner myReader = new Scanner(myFile);
            int counter = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                lines[counter] = data;
                counter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("there are " + lines.length + " lines");
        for (int i = 0 ; i < lines.length; i++) {
            System.out.println(pigLatin(lines[i]));
        }
    }

    public int findFirstVowel(String sWord) {
        String vowels = "aeiou";
        for (int i = 0; i < sWord.length(); i++) {
            if (vowels.contains(Character.toString(sWord.charAt(i)))) {
                return i;
            }
        }
        return -1;
    }

    public String pigLatin(String sWord) {
        int firstVowel = findFirstVowel(sWord);

        // Rule 1: All consonants
        if (firstVowel == -1) {
            return sWord + "ay";
        }

        // Rule 2: Starts with a vowel
        if (firstVowel == 0) {
            return sWord + "way";
        }

        // Rule 3: Starts with "qu"
        if (sWord.startsWith("qu")) {
            return sWord.substring(2) + "quay";
        }

        // Rule 4: Starts with consonants
        return sWord.substring(firstVowel) + sWord.substring(0, firstVowel) + "ay";
    }
}
