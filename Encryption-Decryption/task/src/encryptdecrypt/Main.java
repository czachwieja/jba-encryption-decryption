package encryptdecrypt;

public class Main {
    private static final int SUM_OF_A_AND_Z_CHARACTERS = 'a' + 'z'; //219

    public static void main(String[] args) {
        String message = "we found a treasure!";
        String encryptedMessage = encrypt(message);
        System.out.println(encryptedMessage);
    }

    private static String encrypt(String message) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if (String.valueOf(character).matches("[a-z]")) {
                stringBuilder.append((char) (SUM_OF_A_AND_Z_CHARACTERS - message.charAt(i)));
            } else
                stringBuilder.append(character);
        }
        return stringBuilder.toString();
    }
}
