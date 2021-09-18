import java.util.Scanner;

public class Caesar {
    // Given a String, encrypts the String with the Caesar cipher
    // and returns the encrypted String
    // Ex. encryptCaesar("Hello, World!") => "Khoor, Zruog!"
    public static String encryptCaesar(String message) {
        String res = "";
        char x;
        for (int i = 0; i<message.length(); i++){
            x = message.charAt(i);
            if ((x >= 'a' && x <= 'w')||(x >= 'A' && x <= 'W')){
                int num = x;
                int num2 = num + 3;
                char char1 = (char) num2;
                res += char1;
            }
            else if ((x >= 'x' && x <= 'z')||(x >= 'X' && x <= 'Z')){
                int num = x;
                int num2 = num - 23;
                char char1 = (char) num2;
                res += char1;
            }
            else {
                res += x;
            }
        }
        return res;
    }

    // Given a String, decrypts the String with the Caesar cipher
    // and returns the original String
    // Ex. decryptCaesar("Khoor, Zruog!") => "Hello, World!"
    public static String decryptCaesar(String message) {
        String res = "";
        char x;
        for (int i = 0; i<message.length(); i++){
            x = message.charAt(i);
            if ((x >= 'd' && x <= 'z')||(x >= 'D' && x <= 'Z')){
                int num = x;
                int num2 = num - 3;
                char char1 = (char) num2;
                res += char1;
            }
            else if ((x >= 'a' && x <= 'c')||(x >= 'A' && x <= 'C')){
                int num = x;
                int num2 = num + 23;
                char char1 = (char) num2;
                res += char1;
            }
            else {
                res += x;
            }
        }
        return res;
    }

    // Given a String and a key corresponding to a shift, encrypts
    // the String using the given key and returns the encrypted String
    // Ex. encryptCaesarKey("Hello, World!", 5) => "Mjqqt, Btwqi!".
    public static String encryptCaesarKey(String message, int key) {
        String res = "";
        char x;
        key = key % 26;
        for (int i = 0; i<message.length(); i++){
            x = message.charAt(i);
            if ((x >= 'a' && x <= 'z')){
                int num = x;
                int num2 = num + key;
                if (num2 <= 122){
                    char char1 = (char) num2;
                    res += char1;
                }
                else{
                    int num3 = num - (26-key);
                    char char1 = (char) num3;
                    res += char1;
                }
            }
            else if ((x >= 'A' && x <= 'Z')){
                int num = x;
                int num2 = num + key;
                if (num2 <= 90){
                    char char1 = (char) num2;
                    res += char1;
                }
                else{
                    int num3 = num - (26-key);
                    char char1 = (char) num3;
                    res += char1;
                }
            }
            else {
                res += x;
            }
        }
        return res;
    }

    // Given a String and a key corresponding to a shift, decrypts
    // the String using the given key and returns the original String
    // Ex. decryptCaesarKey("Mjqqt, Btwqi!", 5) => "Hello, World!"
    public static String decryptCaesarKey(String message, int key) {
        String res = "";
        char x;
        key = key % 26;
        for (int i = 0; i<message.length(); i++){
            x = message.charAt(i);
            if ((x >= 'a' && x <= 'z')){
                int num = x;
                int num2 = num - key;
                if (num2 >= 97 && num2 <= 122){
                    char char1 = (char) num2;
                    res += char1;
                }
                else{
                    int num3 = num + (26-key);
                    char char1 = (char) num3;
                    res += char1;
                }
            }
            else if ((x >= 'A' && x <= 'Z')){
                int num = x;
                int num2 = num - key; // 72 - 4
                if (num2 >= 65 && num2 <= 90){
                    char char1 = (char) num2;
                    res += char1;
                }
                else{
                    int num3 = num + (26-key);
                    char char1 = (char) num3;
                    res += char1;
                }
            }
            else {
                res += x;
            }
        }
        return res;
    }


    // The main method is already provided for you
    // You do not need to edit this code until Part 2
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
