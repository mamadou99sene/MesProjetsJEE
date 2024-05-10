package tesseract;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Image {
	public static void main(String [] args)
	{
		Tesseract tess=new Tesseract();
		tess.setDatapath("C:\\Users\\FIS-TS\\Desktop\\Tess4J\\tessdata");
		try {
			String text=tess.doOCR(new File("src/main/java/tesseract/logo-text.png"));
			System.out.println(text);
		} 
		catch (TesseractException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
