package finalexam_extracredit;

import java.io.File;
import java.util.ArrayList;

public class TestIntegerKeyStore {
    public static void main(String[] args) {
        File filePath = new File(System.getProperty("user.home") + File.separatorChar
                + "desktop" + File.separatorChar + "KeyStoreFolder" + File.separatorChar
                + "keystore.txt");

        //pathfolder: KeyStoreFolder
        //name: keystore.txt
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123454321);
        list.add(234565432);
        list.add(345676543);
        list.add(456787654);
        list.add(567898765);

        KeysUtility<Integer> utility = new KeysUtility<>();
        utility.reverseKeyList(list);

        KeyStore keyStore = new IntegerKeyStore(filePath,list);

        keyStore.fileWrite();


        System.out.println(((IntegerKeyStore) keyStore).minKeyHelper(list));


    }
}
