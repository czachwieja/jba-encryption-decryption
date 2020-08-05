package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static final int CHARACTER_A_IN_ASCII = 'a'; //97
    private static final int SUM_OF_CHARACTERS_FROM_A_TO_Z = 'z' + 1 - 'a'; //26

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        String encryptedMessage = encrypt(message, key);
        System.out.println(encryptedMessage);
    }

    private static String encrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (String.valueOf(character).matches("[a-z]")) {
                stringBuilder.append((char) (((key + character - CHARACTER_A_IN_ASCII) % SUM_OF_CHARACTERS_FROM_A_TO_Z) + CHARACTER_A_IN_ASCII));
            } else
                stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
