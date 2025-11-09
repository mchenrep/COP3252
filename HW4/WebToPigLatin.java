
import java.io.*;

public class WebToPigLatin {
    private static String pigLatin(String s){
        /// Pig Latin Rules:
        /// 1. Contains AT LEAST 1 vowel (or y acting as a vowel)
        /// 2. If word starts with a vowel, end it with "way"
        /// 3. If word starts with consonant/series of consonants, transfer all consonants until vowel then end it with "ay"
        /// 4. y should be treated as a consonant if it is the first letter of a word, otherwise its a vowel
        /// 5. If the original word is capitalized, the translated Pig Latin word should be too (and add the non-capitalized one to the end)
        
        if(!hasVowels(s)){ // if has no vowels
            if(!s.contains("y") && !s.contains("Y")) // no y acting as vowel
                return s;
            return s;
        }
            

        StringBuilder sb = new StringBuilder(s);
        boolean capitalized = false;

        if(isVowel(sb.charAt(0), 0) || !Character.isLetter(sb.charAt(0))){ // if starts with a vowel, add "way" to the end
            sb.append("way");
            return sb.toString();
        }
        else{
            if(Character.isUpperCase(sb.charAt(0))) // check for capitalization
                capitalized = true;
            
            int consonants = 0;
            for(int i = 0; i < s.length(); i++){
                char c = sb.charAt(i);
                if(!isVowel(c, i)){ // if isn't vowel, transfer to end
                    sb.append(Character.toLowerCase(c));
                    consonants++;
                }
                else{
                    break; // if is vowel, end loop (all consonants moved)
                }
            }
            sb.append("ay"); // words that start with consonants, end with "ay"
            sb.delete(0, consonants); // delete consonants that I transfered in the loop
            if(capitalized)
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0))); // capitalization rule
            return sb.toString();
        }
    }

    private static boolean isVowel(char c, int i){ // helper function to check if character is a vowel
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for(char v : vowels){
            if(v == Character.toLowerCase(c))
                return true;
            if(i > 0 && Character.toLowerCase(c) == 'y') // y acting as a vowel
                return true;
        }
        return false;
    }

    private static boolean hasVowels(String s){ // helper function to check for vowels
        for(int i = 0; i < s.length(); i++){
            if(isVowel(s.charAt(i), i)){
                return true;
            }
        }
        return false;
    }

    
    public static void main(String[] args) throws IOException{
        if(args.length != 2){
            System.err.println("Usage: java WebToPigLatin inputFile outputFile");
            System.err.println("Must have two command-line parameters");
            return; // prevents opening any files
        }
        else{
            String inputFile = args[0];
            String outputFile = args[1];

            Reader in = new BufferedReader(new FileReader(inputFile));
            Writer out = new BufferedWriter(new FileWriter(outputFile));

            boolean skip = false;
            boolean special = false;
            String word = "";
            int i;

            while((i = in.read()) != -1){
                char c = (char) i;
                if(c == '<') // skip tag
                    skip = true;
                else if(c == '>') // end of tag
                    skip = false;
                if(c == '&') // if in special HTML marker
                    special = true;
                if(c == ';') // end of special HTML marker
                    special = false;
                if(!skip && !special){
                    if(Character.isLetter(c) || c == '\''){ // if current token is a letter (part of a word), start building the word
                        word += c;
                        continue; // (building the word, nothing needs to be written yet)
                    }
                }
                if(word.length() > 0){
                    out.write(pigLatin(word));
                    word = ""; // reset word to store next word after writing to file
                }
                out.write(c);  // automatically writes all html tags, special browser items, numbers, etc. (no translation) to output page  
            }
            if (word.length() > 0)
                out.write(pigLatin(word)); // in case file ends with a word (not delimited)

            in.close();
            out.close();
        }
    }

}
