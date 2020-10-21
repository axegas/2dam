/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqltest;

import DAO.Client;
import DAO.ClientDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.DefaultListModel;

/**
 *
 * @author peixe
 */
public class ControllerJList {

    private final ClientDAO conn;
    private final DefaultListModel<Client> clients;

    private Client clienteActual;

    public ControllerJList() {
        this.conn = new ClientDAO();
        this.clients = conn.loadClientsModel();
    }

    public DefaultListModel getListModel() {
        return clients;
    }

    public void createPDF(DefaultListModel dlmRight) {
        try {
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream("Lista Clientes.pdf"));
            doc.open();

            Client c;
            String text = "Lista de clientes:\n";
            for (int k = 0; k < dlmRight.size(); k++) {
                c = (Client) dlmRight.get(k);
                text += c.muestraCliente();
            }
            Paragraph p = new Paragraph(text);
            p.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(p);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
