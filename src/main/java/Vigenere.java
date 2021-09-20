import java.util.Scanner;

public class Vigenere {
    public static char encryptCaesarLetter(char ch, int key) {
        if ((ch >= 'A' && ch <= 'Z')) {
            int num = ch;
            int num2 = num + key;
            if (num2 <= 90) {
                char char1 = (char) num2;
                return char1;
            } else {
                int num3 = num - (26 - key);
                char char2 = (char) num3;
                return char2;
            }
        }
        else if ((ch >= 'a' && ch <= 'z')) {
            int num = ch;
            int num2 = num + key;
            if (num2 <= 122) {
                char char1 = (char) num2;
                return char1;
            } else {
                int num3 = num - (26 - key);
                char char2 = (char) num3;
                return char2;
            }
        }
        else {
            return ch;
        }

    }

    public static char decryptCaesarLetter(char ch, int key) {
        if ((ch >= 'A' && ch <= 'Z')) {
            int num = ch;
            int num2 = num - key;
            if (num2 >= 65 && num2 <= 90) {
                char char1 = (char) num2;
                return char1;
            } else {
                int num3 = num + (26 - key);
                char char2 = (char) num3;
                return char2;
            }
        }
        if ((ch >= 'a' && ch <= 'z')) {
            int num = ch;
            int num2 = num - key;
            if (num2 >= 97 && num2 <= 122) {
                char char1 = (char) num2;
                return char1;
            } else {
                int num3 = num + (26 - key);
                char char2 = (char) num3;
                return char2;
            }
        }
        else {
            return ch;
        }
    }

    public static String encryptVigenere(String message, String key) {
            String res = "";
            char x;
            int keyIndex = 0;
            for (int i = 0; i<message.length(); i++) {
                int keyletter = key.charAt(keyIndex);
                keyletter -= 'A';
                x = message.charAt(i);
                if ((x >= 'A' && x <= 'Z') || (x >= 'a' && x <= 'z')) {
                    char add = encryptCaesarLetter(x, keyletter);
                    res += add;
                    if (keyletter < 3) {
                        keyletter += 1;
                    }
                    else {
                        keyletter = 0;
                    }
                }
                else {
                    char add = encryptCaesarLetter(x, keyletter);
                    res += add;
                }
            }
            return res;
        }


    public static String decryptVigenere(String message, String key) {
        return message;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
            System.out.println("Encrypting 'a' by 5 should give 'f', and got: " + encryptCaesarLetter('a', 5));
            System.out.println("Encrypting 'y' by 8 should give 'g', and got: " + encryptCaesarLetter('y', 8));
            System.out.println("Encrypting 'A' by 4 should give 'E', and got: " + encryptCaesarLetter('A', 4));
            System.out.println("Encrypting 'Z' by 3 should give 'C', and got: " + encryptCaesarLetter('Z', 3));
            System.out.println("Encrypting '#' by 5 should give '#', and got: " + encryptCaesarLetter('#', 5));
            System.out.println();
            System.out.println("Decrypting 'f' by 5 should give 'a', and got: " + decryptCaesarLetter('f', 5));
            System.out.println("Decrypting 'g' by 8 should give 'y', and got: " + decryptCaesarLetter('g', 8));
            System.out.println("Decrypting 'E' by 4 should give 'A', and got: " + decryptCaesarLetter('E', 4));
            System.out.println("Decrypting 'C' by 3 should give 'Z', and got: " + decryptCaesarLetter('C', 3));
            System.out.println("Decrypting '#' by 5 should give '#', and got: " + decryptCaesarLetter('#', 5));

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
