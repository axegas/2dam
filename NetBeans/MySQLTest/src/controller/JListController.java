/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Client;
import DAO.ClientDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author peixe
 */
public class JListController {

    private final ClientDAO conn;
    private final ArrayList<Client> clientsArray;

    public JListController() {
        this.conn = new ClientDAO();
        this.clientsArray = conn.loadClients();
    }

    public ArrayList<Client> getListArray() {
        return clientsArray;
    }

    public void createPDF(Object[] dlmRight) {//recibe un vector de objetos
        try {
            //crea el texto y lo inserta en la variable 'text'
            Client c;
            String text = "Lista de clientes:\n\n";
            for (Object dlmRight1 : dlmRight) {
                c = (Client) dlmRight1; //castea los elementos del vector a tipo 'Client'
                text += c.muestraCliente();
            }

            //esta parte es fija, no se cambia
            Document doc = new Document(PageSize.A4, 50, 50, 100, 72);
            PdfWriter.getInstance(doc, new FileOutputStream("Lista Clientes.pdf"));
            doc.open();
            Paragraph p = new Paragraph(text);
            p.setAlignment(Element.ALIGN_JUSTIFIED);

            doc.add(p);
            doc.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
