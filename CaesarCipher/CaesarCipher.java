package CaesarCipher;

public class CaesarCipher {
    protected char[] encoder = new char[26];
    protected char[] decoder = new char[26];

    public CaesarCipher(int length) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char)(65 + (26 + i + length)%26);
            decoder[i] =  (char)(65 + (26 +  i - length) % 26);
        }
    }
    public String decrypt(String var3) { return transform(var3,decoder);}


    public String encrypt(String var2) { return transform(var2,encoder);}
    public String transform(String var3, char[] chars) {
        char[] arrRes = var3.toCharArray();
        for (int i = 0; i < var3.length(); i++) {
            if(Character.isUpperCase(arrRes[i])) arrRes[i] = chars[arrRes[i] - 65];
        }
        return new String(arrRes);
    }
    public static void main(String[] var0) {
        CaesarCipher var1 = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(var1.encoder));
        System.out.println("Decryption code = " + new String(var1.decoder));
        String var2 = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String var3 = var1.encrypt(var2);
        System.out.println("Secret:  " + var3);
        String var4 = var1.decrypt(var3);
        System.out.println("Message: " + var4);
    }

}
