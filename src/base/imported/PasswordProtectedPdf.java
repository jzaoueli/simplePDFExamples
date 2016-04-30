package base.imported;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 */

public class PasswordProtectedPdf {
    private static String USER_PASSWORD = "password";
    private static String OWNER_PASSWORD = "lokesh";

    public static void main(String[] args) {
        try {
            OutputStream file = new FileOutputStream(new File("PasswordProtected.pdf"));
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);

            writer.setEncryption(USER_PASSWORD.getBytes(),
                    OWNER_PASSWORD.getBytes(), PdfWriter.ALLOW_MODIFY_CONTENTS,
                    PdfWriter.ENCRYPTION_AES_128);

            document.open();
            document.add(new Paragraph("Password Protected pdf example !!"));
            document.close();
            file.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
