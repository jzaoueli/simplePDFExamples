package base;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.net.URL;

/**
 * generate a simple PDF file (generatedPDF/ImagePDF.pdf) with :
 * - 'A generated PDF with Image Example.' as Text.
 * - image from tempFile (tempFiles/image.png)
 * - image from Internet (http://www.eclipse.org/xtend/images/java8_logo.png)
 */

public class ImagePDF {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("generatedPDF/ImagePDF.pdf"));
            document.open();
            document.add(new Paragraph("Generated PDF with Image Example"));

            //Add Image
            Image image1 = Image.getInstance("tempFiles/image.png");

            //For Fixed Positioning
            //image1.setAbsolutePosition(100f, 550f);

            //Scale to new height and new width of image
            image1.scaleAbsolute(200, 200);

            //Add to document
            document.add(image1);

            String imageUrl = "http://www.eclipse.org/xtend/images/java8_logo.png";
            Image image2 = Image.getInstance(new URL(imageUrl));
            document.add(image2);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
