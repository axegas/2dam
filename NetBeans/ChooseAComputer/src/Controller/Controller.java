/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author peixe
 */
public class Controller {

    public void createPDF(String str) {
        try {
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter.getInstance(doc, new FileOutputStream("Factura.pdf"));
            doc.open();
            Paragraph p = new Paragraph("Total factura:\n" + str);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
