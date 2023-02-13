import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SpeechGen {
    abstract String TextToSpeech(String input);
}

class EngToSpeechGen extends SpeechGen {

    @Override
    String TextToSpeech(String input) {
        return input.replace("\"", "");
    }

}

class BanglaSpeechGen extends SpeechGen {
    SpeechGen engToSpeechGen;

    public BanglaSpeechGen(SpeechGen engToSpeechGen) {
        this.engToSpeechGen = engToSpeechGen;
    }

    @Override
    String TextToSpeech(String input) {
        input = input.replace("\"", "");
        String[] words = input.split(" ", 0);
        List<String> wordList = new ArrayList<String>();
        String output = "";

        
        for (String word : words) {
            if (word.equalsIgnoreCase("Ami")) {
                wordList.add("I");
            } else if (word.equalsIgnoreCase("Amra")) {
                wordList.add("We");
            } else if (word.equalsIgnoreCase("Bhat")) {
                wordList.add("rice");
            } else if (word.equalsIgnoreCase("Roti")) {
                wordList.add("bread");
            } else if (word.equalsIgnoreCase("Banai")) {
                wordList.add("prepare");
            } else if (word.equalsIgnoreCase("Khai")) {
                wordList.add("eat");
            } else {
                wordList.add(word);
            }
        }
        // for (String word : wordList) {
        //     // if (word )
        //     output += word + " ";
        // }
        for(int i = 0; i< wordList.size() - 1; i++) {
            if ( (wordList.get(i).equalsIgnoreCase("rice") || wordList.get(i).equalsIgnoreCase("bread") ) && ( wordList.get(i+1).equalsIgnoreCase("eat") || wordList.get(i+1).equalsIgnoreCase("prepare")) ) {
                String t = wordList.get(i+1);
                wordList.set(i+1, wordList.get(i));
                wordList.set(i, t);
            }
        }
        for (String word : wordList) {
            // if (word )
            output += word + " ";
        }
        return engToSpeechGen.TextToSpeech(output);
    }

}

class test {
    public static void main(String[] args) {
        SpeechGen engToSpeechGen = new EngToSpeechGen();
        SpeechGen banglaToSpeechGen = new BanglaSpeechGen(engToSpeechGen);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nEnter speech in quotes: \n");
            String input = scanner.nextLine();
            String output = banglaToSpeechGen.TextToSpeech(input);
            System.out.println("Output: ");
            System.out.println(output);
        }
    }
}
