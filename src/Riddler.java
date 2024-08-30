/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
import java.util.ArrayList;
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        int length = encrypted.length();
        int shiftValue = 9;
        // Loop through the entire string, one number at a time
        for (int i = 0; i < length; i++) {
            char letter = encrypted.charAt(i);
            // If letter is uppercase, perform caesar shift for uppercase
            if (Character.isUpperCase(letter)) {
                char shifted = (char) ((letter - 'A' + shiftValue) % 26 + 'A');
                decrypted = decrypted + shifted;
            }
            else if (Character.isLowerCase(letter)) {
                char shifted = (char) ((letter - 'a' + shiftValue) % 26 + 'a');
                decrypted = decrypted + shifted;
            }
            // If character is not a letter, add character to decrypted string as is
            else {
                decrypted = decrypted + letter;
            }
        }
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Create copy of string
        String copy = encrypted;
        int spaceIndex = copy.indexOf(" ");
        boolean spaceInString = (spaceIndex != -1);
        int count = 0;
        // Count spaces in copy, chopping off from string as you go through
        while (spaceInString) {
            count++;
            // Cut off copy to after space
            copy = copy.substring(spaceIndex + 1);
            spaceIndex = copy.indexOf(" ");
            spaceInString = (spaceIndex != -1);
        }
        // Initialize array to contain all ascii values
        String[] arr = new String[count + 1];
        // Split string by delimeter space and add to new array
        arr = encrypted.split(" ");
        // Loop through each ascii value in the list
        for (String asciiVal : arr) {
            int num = Integer.parseInt(asciiVal);
            // Convert the ascii value to a letter
            char letter = (char) num;
            // Add letter to new string
            decrypted = decrypted + letter;
        }
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        // Loop through entire string until empty
        while (!encrypted.isEmpty()) {
            // Get the next 8 digits, convert to integer using bit-shifting
            String binaryString = encrypted.substring(0, 8);
            int length = binaryString.length();
            int sum = 0;
            // Loop through each number in the byte
            for (int i = 0; i < length; i++) {
                // Add value of that 1 to ongoing sum
                if (binaryString.charAt(i) == '1') {
                    sum += 1 << length - i - 1;
                }
            }
            // Get the letter value of the binary number
            char letter = (char) sum;
            // Add letter to new string, then remove binary value from original string
            decrypted = decrypted + letter;
            encrypted = encrypted.substring(8);
        }

        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";
        // Loop through each emoji
        int length = encrypted.length();
        for (int i = 0; i < length; i++) {
            // Get unicode value of emoji
            int unicode = encrypted.codePointAt(i);
            // perform caesar shift on unicode value, then convert to letter
            char letter = (char) (unicode - 9984 + 'A');
            // Add char to string
            decrypted = decrypted + letter;
        }
        return decrypted;
    }
}
