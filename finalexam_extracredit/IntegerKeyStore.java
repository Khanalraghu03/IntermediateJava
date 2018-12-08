package finalexam_extracredit;

import java.io.*;
import java.util.ArrayList;

public class IntegerKeyStore extends KeyStore {
    private ArrayList<Integer> keys;

    public IntegerKeyStore(File file, ArrayList<Integer> keys) {
        super(file);
        this.keys = keys;
    }


    public ArrayList<Integer> getKeys() {
        return keys;
    }

    public void setKeys(ArrayList<Integer> keys) {
        this.keys = keys;
    }


    @Override
    public String toString() {
        return super.toString() + "\nIntegerKeyStore{" +
                "keys=" + keys +
                '}';
    }


    @Override
    public void fileWrite() {
        // Creates a folder and file with the names specified
        // in the inherited instance variable file.
        // Uses java.io.PrintWriter and println() to write the integers
        // in the ArrayList keys to the file.
        // Implements Exception handling.

        boolean fileCreated = false;
        while(!fileCreated)
        {
            try
            {
                if(super.getFile().createNewFile()) {
                    System.out.println("File created in folder "+ "KeyStoreFolder");
                }
                else {
                    System.out.println("The file already exists");
                }
                fileCreated = true;
            }
            catch (IOException e)
            {
                e.printStackTrace();
                super.getFile().getParentFile().mkdir(); 	//obtain the path up to the folder, and will not include the file
                System.out.println("Folder KeyStoreFolder created");

                ////pathfolder: KeyStoreFolder
                //        //name: keystore.txt
            }

            PrintWriter printWriter = null;
            try {
                printWriter = new PrintWriter(new FileWriter(super.getFile(), true));
                printWriter.println("" + this.keys);
                System.out.println("Wrote to the File");
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to the file due to");
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (printWriter != null)
            {
                printWriter.close();
            }
        }

    }
    public int minKeyHelper(ArrayList<Integer> list){
        int [] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return minKey(array, array.length, Integer.MAX_VALUE);
    }

    public int minKey(int[] array, int arrayLength, int min) {
        if(arrayLength == 1) {
            return array[0];
        }
        else {
            return minKey(array, arrayLength -1, min);
        }

    }

}
