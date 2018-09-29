/**
 * 
 */
package chapter12;

import java.io.IOException;

/**
 * @author Raghu Khanal
 *
 */
public class TestFileReadWrite {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileReadWrite fileReadWrite = new FileReadWrite();
		fileReadWrite.createFile();
		fileReadWrite.writeFile();
		
	}

}
