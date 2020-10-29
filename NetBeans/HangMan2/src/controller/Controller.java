/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.ImageIcon;

/**
 *
 * @author axegas
 */
public final class Controller {

    private ImageIcon[] images;
    private int index;
    private String wordToGuessString;
    private String wordResult;
    private boolean isLetter;

    public Controller() {
        start();
    }

    public void start() {
        index = -1;
        isLetter = false;
        images = new ImageIcon[5];
        for (int i = 0; i < images.length; i++) {
            images[i] = new ImageIcon(getClass().getResource("/images/foto" + i + ".png"));
        }
    }

    public String firstPlayer(char[] wordToGuessArray) {
        wordResult = "";
        wordToGuessString = "";
        for (int i = 0; i < wordToGuessArray.length; i++) {
            wordResult += "-";
            wordToGuessString += wordToGuessArray[i];
        }
        wordToGuessString = wordToGuessString.toUpperCase();
        return wordResult;
    }

    public String secondPlayer(char c) {
        isLetter = false;
        String aux = "";
        for (int i = 0; i < wordToGuessString.length(); i++) {
            if (wordToGuessString.charAt(i) == c) {
                isLetter = true;
                aux += c;
            } else {
                aux += wordResult.charAt(i);
            }
        }
        wordResult = aux;
        return wordResult;
    }

    public boolean getIsLetter() {
        return isLetter;
    }

    public int getIndex() {
        return index;
    }

    public ImageIcon nextImage() {
        index++;
        return images[index];
    }
}
