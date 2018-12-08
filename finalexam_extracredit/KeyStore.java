package finalexam_extracredit;


import java.io.File;

/**
 * @author Raghu Khanal
 *
 */

public abstract class KeyStore {
    private java.io.File file;

    //Write constructor
    public KeyStore (File file) {
        this.file = file;
    }

    /**
     * @return
     */
    public File getFile() {
        return file;
    }
    /**
     * @param file
     */
    public void setFile(File file) {
        this.file = file;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "KeyStore [file=" + file + "]";
    }

    //Write abstract method
    public abstract void fileWrite();

}