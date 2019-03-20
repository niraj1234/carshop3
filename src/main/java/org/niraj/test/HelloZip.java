package org.niraj.test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
*/
public class HelloZip {
 public static final String RESULT = "W:\\FilesByCode\\NirajPdfZipped1.zip";

 public static void main(String[] args) {
/*	try {
	  ZipOutputStream zipOutStream = new ZipOutputStream(new FileOutputStream(RESULT));
	  for (int i = 1; i < 50; i++) {
		ZipEntry entry = new ZipEntry("Niraj" + i + ".pdf");
		zipOutStream.putNextEntry(entry);

		Document document = new Document();
		PdfWriter pWriter = PdfWriter.getInstance(document, zipOutStream);
		pWriter.setCloseStream(false);
		document.open();
		document.add(new Paragraph("Hi Niraj" + i));
		document.add(new Paragraph("Your Account Balance is " + Math.random() * 100));
		document.close();
		zipOutStream.closeEntry();
		System.out.println("File Completed ====>" + i);
	  }
	 zipOutStream.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (DocumentException e) {
		e.printStackTrace();
	}*/
 }
}
