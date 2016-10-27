package view;

import DAO.DAOPlayer;
import VO.Player;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class ViewPlayer {

    private DAOPlayer dao;
    private ArrayList<Player> players;

    public ViewPlayer() {
        this.players = new ArrayList<>();
        try {
            this.dao = new DAOPlayer();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "No Se Encuentra El Archivo");
        }

    }

    public void menu() {
        String opcion
                = JOptionPane.showInputDialog(null, "1. Crear \n2. Guardar \n3. Leer");
        if (opcion.equals("1")) {
            String name = JOptionPane.showInputDialog(null, "Name: ");
            String email = JOptionPane.showInputDialog(null, "emal: ");
            Player player = new Player(name, email);
            players.add(player);
        } else if (opcion.equals("2")) {
            try {
                this.dao.write(players);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error Escritura");
            }
        } else if (opcion.equals("3")) {
            try {
                ArrayList<Player> playerss = this.dao.read();
                for (Player p : playerss) {
                    System.out.println(p);
                }
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error Lectura");
            }
        } else {
        }

    }
}
