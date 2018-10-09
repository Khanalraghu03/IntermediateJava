/**
 * 
 */
package chapter12;

import java.io.IOException;

/**
 * @author Raghu Khanal
 *
 */
public class TestFileReadWrite 
{

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException 
	{
		
		FileReadWrite fileReadWrite = new FileReadWrite();
//		fileReadWrite.createFile();
//		fileReadWrite.writeFile();
//		fileReadWrite.readFile();
//		fileReadWrite.typeLinesToFile();
//		fileReadWrite.parseFile();
//		fileReadWrite.copyFile();
		fileReadWrite.parseDataFile();
	}

}
