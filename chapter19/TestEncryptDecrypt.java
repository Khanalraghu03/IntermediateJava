package chapter19;

import java.util.Arrays;

/**
 * @author Raghu Khanal
 *
 */

public class TestEncryptDecrypt {
    public static void main(String[] args) {
        //Create an instance of EncryptDecrypt
        EncryptDecrypt encryptDecrypt = new EncryptDecrypt();

        String original = "Generics in Java";

        //Display the original String
        System.out.println("The original String: " + original);
        //Encrypt the original String using the encrypt method for Strings
        String encrypted = encryptDecrypt.encrypt(original);
        //Display the encrypted String
        System.out.println("The encrypted String is: " + encrypted);
        //Decrypt the encrypted String using the decrypt method for Strings
        String decrypted = encryptDecrypt.decrypt(encrypted);



        //Display the decrypted String
        System.out.println("The decrypted message: "+ decrypted);
        //Initialize the original array as [26362, 53723, 93473]
        //Display the original array
        //Encrypt the original array using the encrypt method for arrays
        //Display the encrypted array
        //Decrypt the encrypted array using the decrypt method for arrays
        //Display the decrypted array

        int[] originalArray = {26362, 53723, 93473};
        System.out.println("Printing original arrays "+Arrays.toString(originalArray));




        int[] encryptedArray = encryptDecrypt.encrypt(originalArray);
        System.out.println("Printing encrypted arrays "+Arrays.toString(encryptedArray));



        int[] decryptedArray = encryptDecrypt.decrypt(encryptedArray);
        System.out.println("Printing decrypted arrays "+Arrays.toString(decryptedArray));



    }
}
