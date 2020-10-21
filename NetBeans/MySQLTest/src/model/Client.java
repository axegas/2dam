/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author peixe
 */
public class Client {

    private String id;
    private String notes;

    public Client() {
        id = "";
        notes = "";
    }

    public Client(String id, String notes) {
        this.id = id;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return id;
    }

    public String muestraCliente() {
        String text = "";
        text += "Cliente ID: " + id + "\n";
        text += "Notas: " + notes + "\n";
        return text;
    }

}
