package encryptdecrypt;

import java.util.Scanner;

public class Main {
    private static final int CHARACTER_SPACE_IN_ASCII = ' '; // 32
    private static final int SUM_OF_CHARACTERS_FROM_SPACE_TO_TILDE = '~' + 1 - ' '; // 95 = 126 + 1 - 32

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String message = scanner.nextLine();
        int key = scanner.nextInt();
        String encryptedMessage = "";
        if ("enc".equals(operation)) {
            encryptedMessage = encrypt(message, key);
        } else if ("dec".equals(operation)) {
            encryptedMessage = decrypt(message, key);
        }
        System.out.println(encryptedMessage);
    }

    private static String encrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            stringBuilder.append((char) (((character + key - CHARACTER_SPACE_IN_ASCII) % SUM_OF_CHARACTERS_FROM_SPACE_TO_TILDE) + CHARACTER_SPACE_IN_ASCII));
        }
        return stringBuilder.toString();
    }

    private static String decrypt(String message, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            stringBuilder.append((char) (((character - key - CHARACTER_SPACE_IN_ASCII) % SUM_OF_CHARACTERS_FROM_SPACE_TO_TILDE) + CHARACTER_SPACE_IN_ASCII));
        }
        return stringBuilder.toString();
    }

}
