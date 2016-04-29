package base;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

/**
 * generate a PDF file (generatedPDF/ListExample.pdf) with different kind of list.
 */

public class ListPDF {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("generatedPDF/ListExample.pdf"));
            document.open();
            document.add(new Paragraph("Example of PDF with different List"));

            //Add ordered list
            document.add(new Paragraph("\n*****************************ordered list*****************************\n"));
            List orderedList = new List(List.ORDERED);
            orderedList.add(new ListItem("Item 1"));
            orderedList.add(new ListItem("Item 2"));
            orderedList.add(new ListItem("Item 3"));
            document.add(orderedList);

            //Add un-ordered list
            document.add(new Paragraph("\n*****************************un-ordered list*****************************\n"));
            List unorderedList = new List(List.UNORDERED);
            unorderedList.add(new ListItem("Item 1"));
            unorderedList.add(new ListItem("Item 2"));
            unorderedList.add(new ListItem("Item 3"));
            document.add(unorderedList);

            //Add roman list
            document.add(new Paragraph("\n*****************************roman list*****************************\n"));
            RomanList romanList = new RomanList();
            romanList.add(new ListItem("Item 1"));
            romanList.add(new ListItem("Item 2"));
            romanList.add(new ListItem("Item 3"));
            document.add(romanList);

            //Add greek list
            document.add(new Paragraph("\n*****************************greek list*****************************\n"));
            GreekList greekList = new GreekList();
            greekList.add(new ListItem("Item 1"));
            greekList.add(new ListItem("Item 2"));
            greekList.add(new ListItem("Item 3"));
            document.add(greekList);

            //ZapfDingbatsList List Example
            document.add(new Paragraph("\n*****************************ZapfDingbatsList List Example*****************************\n"));
            ZapfDingbatsList zapfDingbatsList = new ZapfDingbatsList(43, 30);
            zapfDingbatsList.add(new ListItem("Item 1"));
            zapfDingbatsList.add(new ListItem("Item 2"));
            zapfDingbatsList.add(new ListItem("Item 3"));
            document.add(zapfDingbatsList);

            //List and Sublist Examples
            document.add(new Paragraph("\n*****************************List and Sublist Examples*****************************\n"));
            List nestedList = new List(List.UNORDERED);
            nestedList.add(new ListItem("Item 1"));

            List sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("A");
            sublist.add("B");
            nestedList.add(sublist);

            nestedList.add(new ListItem("Item 2"));

            sublist = new List(true, false, 30);
            sublist.setListSymbol(new Chunk("", FontFactory.getFont(FontFactory.HELVETICA, 6)));
            sublist.add("C");
            sublist.add("D");
            nestedList.add(sublist);

            document.add(nestedList);

            document.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
