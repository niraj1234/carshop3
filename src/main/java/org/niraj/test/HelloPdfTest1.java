package org.niraj.test;

import java.io.FileOutputStream;
import java.io.IOException;
/*
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloPdfTest1 {

    *//** Path to the resulting PDF file. *//*
    public static final String RESULT = "W:\\FilesByCode\\helloA8size.pdf";

    public static void main(String[] args) throws DocumentException, IOException {
    	new HelloPdfTest1().createPdf(RESULT);
    	System.out.println("Processing of PDF file is done ==>");
    }

    public void createPdf(String filename) throws DocumentException, IOException {
    	Rectangle pageSize = new Rectangle(300f, 400f);
//	    	Document document = new Document();
//	    	Document document = new Document(pageSize.rotate(), 2f, 3f, 5f, 5f);

    	Document document = new Document();
    	document.setPageSize(PageSize.A8);
    	
    	PdfWriter.getInstance(document, new FileOutputStream(filename));
        document.open();
        document.add(new Paragraph("Hello Niraj !"));
        document.add(new Paragraph("This is first paragraph in Rotate mode"));
        document.add(new Paragraph("Another Paragraph"));
        document.add(new Paragraph("Will add new paragraph webservices"));
        document.add(new Paragraph("This is End the paragraph "));
        document.close();
    }
}
*/