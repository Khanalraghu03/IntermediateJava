package chapter19;

import java.util.Random;

/**
 * @author Raghu Khanal
 *
 */


public class EncryptDecrypt {
    private int key;
    private Random random;

    public EncryptDecrypt() {
        //Creates a default Random object and assigns it to the instance variable
        random = new Random();
        //Randomly assigns a value between 0 to 99 (both inclusive) to the key
        key = random.nextInt(100);
    }

    //Getters
    public int getKey() {
        return key;
    }

    public Random getRandom() {
        return random;
    }

    //Setters
    public void setKey(int key) {
        this.key = key;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    //toString

    @Override
    public String toString() {
        return "EncryptDecrypt{" +
                "key=" + key +
                ", random=" + random +
                '}';
    }

    public String encrypt(String encrypt) {

        //Create an instance eDU of EncryptionDecryptionUtilities
        //      for class Character and pass a capacity of 25
        EncryptionDecryptionUtilities<Character> eDU = new EncryptionDecryptionUtilities<>(25);

        //Creates a Random object by passing to it the key as seed and assigns it to the instance variable
        //The seed will ensure the same pseudo random sequence
        //is generated for encryption and decryption
        random = new Random(key);
        //X-OR each character of the String with a pseudo random number between 5 to 99 (both inclusive)
        // to get an encrypted character and insert it into eDU using the method addElementToMiddleOfList
        //Use a loop to get and encrypt each character using
        //bitwise -XOR and a pseudo random number and add to middle of eDU

        for (int i = 0; i < encrypt.length(); i++) {
            eDU.addElementToMiddleOfList((char) (encrypt.charAt(i)
                    ^ (random.nextInt(95) + 5)));
        }
        //While eDU is not empty, remove the encrypted characters  using the method removeFirstElementFromList
        //      and return them as a String
        encrypt = "";

        while (!eDU.isListEmpty())
            encrypt += eDU.removeFirstElementFromList();

        return encrypt;
    }

    //+decrypt(decrypt: String): String
    public String decrypt(String decrypt) {
        //Create an instance eDU of EncryptionDecryptionUtilities for
        //      class Character and pass a capacity of 25

        EncryptionDecryptionUtilities<Character> eDU = new EncryptionDecryptionUtilities<>(25);
        //Creates a Random object by passing to it the key as seed
        //      and assigns it to the instance variable

        random = new Random(key);
        //Insert each character of the String into eDU
        //      using the method addAsLastElementToList
        for(int i = 0; i < decrypt.length(); i++) {
            eDU.addAsLastElementToList(decrypt.charAt(i));
        }
        decrypt ="";

        //While eDU is not empty, remove the characters
        //      using the method removeElementFromMiddleOfList and form a String
        while(!eDU.isListEmpty()) {
            decrypt+= eDU.removeElementFromMiddleOfList();
        }
        //Get each character in reverse from the above String and
        //      insert it into eDU using the method addAsLastElementToList
        for(int i = decrypt.length() -1; i >= 0; i--) {
            eDU.addAsLastElementToList(decrypt.charAt(i));
        }

        //While eDU is not empty, remove the characters using the method
        //      removeFirstElementFromList and decrypt them, and return them as a String
        decrypt = "";
        while(!eDU.isListEmpty()) {
            decrypt += (char)(eDU.removeFirstElementFromList()^
                    (random.nextInt(95)+5));
        }
        return decrypt;

    }
    public int[] encrypt(int[] encrypt) {
        EncryptionDecryptionUtilities<Integer> eDU = new EncryptionDecryptionUtilities<>(25);
        random = new Random(key);

        for (int i = 0; i < encrypt.length; i++) {
            eDU.addElementToMiddleOfList((encrypt[i]
                    ^(int)Math.pow (2,(random.nextInt(95) + 5))));
        }
        int i = 0;
        while(!eDU.isListEmpty()) {
            encrypt[i] = eDU.removeFirstElementFromList();
            i++;
        }
        return encrypt;
    }

    public int[] decrypt(int[] decrypt) {
        EncryptionDecryptionUtilities<Integer> eDU = new EncryptionDecryptionUtilities<>(25);
        random = new Random(key);

        for(int i = 0; i < decrypt.length; i++) {
            eDU.addAsLastElementToList((int)decrypt[i]);
        }
        int i = 0;
        while(!eDU.isListEmpty()) {

//            eDU.removeElementFromMiddleOfList();
            decrypt[i] = (eDU.removeElementFromMiddleOfList());
            i++;
        }

        for( i = decrypt.length -1; i >= 0; i--) {
            eDU.addAsLastElementToList((int)decrypt[i]);
        }
        i = 0;
        while(!eDU.isListEmpty()) {

//            eDU.removeFirstElementFromList();
            decrypt[i] = (eDU.removeFirstElementFromList()^(int)Math.pow(2,random.nextInt(95)+5));
            i++;
        }
        return decrypt;

    }
}
