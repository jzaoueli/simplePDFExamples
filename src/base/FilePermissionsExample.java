package base;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * generate a Limited Access PDF file (generatedPDF/LimitedAccess.pdf) -AES_128 with- 'Limited Access File !!' as Text.
 */

public class FilePermissionsExample {
	public static void main(String[] args) {
		try {
			OutputStream file = new FileOutputStream(new File("generatedPDF/LimitedAccess.pdf"));
			Document document = new Document();
			PdfWriter writer = PdfWriter.getInstance(document, file);

			writer.setEncryption("".getBytes(), "".getBytes(),
					PdfWriter.ALLOW_SCREENREADERS , //Only printing allowed; Try to copy text !!
					PdfWriter.ENCRYPTION_AES_128);

			document.open();
			document.add(new Paragraph("Limited Access File !!"));
			document.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
