package encryptdecrypt;

public class Main {
    private static final int CHARACTER_SPACE_IN_ASCII = ' '; // 32
    private static final int SUM_OF_CHARACTERS_FROM_SPACE_TO_TILDE = '~' + 1 - ' '; // 95 = 126 + 1 - 32

    public static void main(String[] args) {
        String operation = "enc";
        String message = "";
        int key = 0;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    message = args[i + 1];
                    break;
            }
        }

        String ciphertext = "";
        switch (operation) {
            case "enc":
                ciphertext = encrypt(message, key);
                break;
            case "dec":
                ciphertext = decrypt(message, key);
                break;
        }
        System.out.println(ciphertext);
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
