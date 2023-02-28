package com.mycompany.concesionaria;

import com.mycompany.concesionaria.igu.Principal;

public class Concesionaria {

    public static void main(String[] args) {
        
        //llamamos y hacemos visible a nuestra igu
        Principal princi = new Principal();
        princi.setVisible(true);
        princi.setLocationRelativeTo(null);
    }
}
