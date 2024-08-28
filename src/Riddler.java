/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {

    public String decryptOne(String encrypted) {
        String decrypted = "";
        int length = encrypted.length();
        // Loop through the entire string, one number at a time
        for (int i = 0; i < length; i++) {
            char letter = encrypted.charAt(i);
            // If not a letter, do not perform shift
            if (!Character.isLetter(letter)) {
                continue;
            }
            // Get integer value of current letter
            int letterVal = (int) letter;
            System.out.println("Letter before: " + letter);
            char newLetter;
            if (letterVal + 9 > 122) {
                newLetter = (char) (letterVal + 9 - 122 + 96);
            }
            else if (letterVal + 9 > 90) {
                newLetter = (char) ((letterVal + 9 - 90 + 64));
            }
            else {
                newLetter = (char) (letterVal + 9);
            }
            System.out.println(newLetter);
            // Perform a caesar shift on the current letter index, then add to decrypted
            decrypted = decrypted + (Character.toString((char) (letterVal + 9))).toString();
        }

        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        // Loop through entire string until empty
        while (!encrypted.isEmpty()) {
            // Find next space
            int nextSpace = encrypted.indexOf(" ");
            // Get the ascii value of the next ascii digits
            int asciiVal = Integer.parseInt(encrypted.substring(0, nextSpace));
            // Convert the ascii value to a letter
            String letter = Character.toString((char) asciiVal);
            // Add letter to new string, then remove ascii value from original string
            decrypted = decrypted + letter;
            encrypted = encrypted.substring(nextSpace + 1);
        }

        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        // Loop through entire string until empty
        while (!encrypted.isEmpty()) {
            // Get the next 8 digits, convert to integer
            int charCode = Integer.parseInt(encrypted.substring(0, 8), 2);
            // Get the letter value of the binary number
            char letter = (char) charCode;
            // Add letter to new string, then remove binary value from original string
            decrypted = decrypted + letter;
            encrypted = encrypted.substring(8);

        }

        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.

        return decrypted;
    }
}
