package DAO;

import VO.Player;
import java.io.*;
import java.util.*;

public class DAOPlayer {

    //1) Referencia A La Fuente de Imformacion  

    private File Player;

    public DAOPlayer() throws IOException {
        this.Player = new File("player.txt");
        if (!this.Player.exists()) {
            this.Player.createNewFile();
        }
    }

    public boolean write(ArrayList<Player> player)
            throws FileNotFoundException {

        PrintStream salida = new PrintStream(this.Player);
        for (Player p : player) {
            salida.println(p.getNombre() + " " + p.getEmail());
        }
        salida.close();
        return true;
    }

    public ArrayList<Player> read() throws FileNotFoundException {
        Scanner lectura = new Scanner(this.Player);
        lectura.useDelimiter(" ");
        ArrayList<Player> Players = new ArrayList<>();
        while (lectura.hasNext()) {
            String name = lectura.next();
            String email = lectura.next();
            Player p = new Player(name, email);
            Players.add(p);
        }
        lectura.close();
        return Players;
    }
}
