package base;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

import static com.itextpdf.text.BaseColor.BLACK;
import static com.itextpdf.text.BaseColor.BLUE;
import static com.itextpdf.text.BaseColor.RED;
import static com.itextpdf.text.Font.ITALIC;
import static com.itextpdf.text.Font.UNDERLINE;
import static com.itextpdf.text.FontFactory.COURIER_BOLD;
import static com.itextpdf.text.FontFactory.HELVETICA;

/**
 * generate a simple PDF file (generatedPDF/TableExample.pdf) with Table of three columns and two rows.
 */

public class TablePDF {

    //private static final Font titleFont = FontFactory.getFont(BASE_FONT_BOLD, 30, Font.UNDERLINE);
    private static final Font titleFont = FontFactory.getFont(COURIER_BOLD, 30, UNDERLINE);
    private static final Font textFont = FontFactory.getFont(HELVETICA, 15, ITALIC);

    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("generatedPDF/TableExample.pdf"));
            document.open();

            PdfPTable table = createPDFTable();

            Paragraph firstTitleParagraph = new Paragraph("Title 1\n\n", titleFont);
            PdfPCell firstTitleCell = createCell(firstTitleParagraph, BLUE);
            table.addCell(firstTitleCell);

            Paragraph secondTitleParagraph = new Paragraph("Title 2\n\n", titleFont);
            PdfPCell secondTitleCell = createCell(secondTitleParagraph, BLACK);
            table.addCell(secondTitleCell);

            Paragraph thirdTitleParagraph = new Paragraph("Title 3\n\n", titleFont);
            PdfPCell thirdTitleCell = createCell(thirdTitleParagraph, RED);
            table.addCell(thirdTitleCell);

            Paragraph firstDescriptionParagraph = new Paragraph("this is the first description\n\n", textFont);
            PdfPCell firstDescriptionCell = createCell(firstDescriptionParagraph, BLUE);
            table.addCell(firstDescriptionCell);

            Paragraph secondDescriptionParagraph = new Paragraph("this is the second description\n\n", textFont);
            PdfPCell secondDescriptionCell = createCell(secondDescriptionParagraph, BLACK);
            table.addCell(secondDescriptionCell);

            Paragraph thirdDescriptionParagraph = new Paragraph("this is the third description\n\n", textFont);
            PdfPCell thirdDescriptionCell = createCell(thirdDescriptionParagraph, RED);
            table.addCell(thirdDescriptionCell);

            document.add(table);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static PdfPTable createPDFTable() throws DocumentException {
        PdfPTable table = new PdfPTable(3); // 3 columns.
        table.setWidthPercentage(100); //Width 100%
        table.setSpacingBefore(10f); //Space before table
        table.setSpacingAfter(10f); //Space after table

        //Set Column widths
        float[] columnWidths = {1f, 1f, 1f};
        table.setWidths(columnWidths);
        return table;
    }

    private static PdfPCell createCell(Paragraph phrase, BaseColor color) {
        PdfPCell cell1 = new PdfPCell(phrase);
        cell1.setBorderColor(color);
        cell1.setPaddingLeft(10);
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
        return cell1;
    }
}
