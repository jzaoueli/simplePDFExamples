package base;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;

public class ReadModifyPdf {
    public static void main(String[] args) {
        try {
            //Read file using PdfReader
            PdfReader pdfReader = new PdfReader("generatedPDF/HelloWorld.pdf");

            //Modify file using PdfReader
            PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("generatedPDF/HelloWorld-modified.pdf"));

            Image image = Image.getInstance("tempFiles/image.png");
            image.scaleAbsolute(100, 50);
            image.setAbsolutePosition(100f, 700f);

            for (int i = 1; i <= pdfReader.getNumberOfPages(); i++) {
                PdfContentByte content = pdfStamper.getUnderContent(i);
                content.addImage(image);
            }

            pdfStamper.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
