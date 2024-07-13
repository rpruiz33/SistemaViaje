package ventana8;

import java.awt.*;
import java.awt.event.*;

class SelecPueblo extends Panel {
    List listaPueblos;

    SelecPueblo(String salidaOllegada) {
        setLayout(new BorderLayout(20, 20));

        // Armamos el título, que va a ser un Label:
        StringBuilder titulo = new StringBuilder();
        titulo.append("Seleccione ciudad de ");
        titulo.append(salidaOllegada);
        titulo.append(": ");
        add(new Label(titulo.toString()), BorderLayout.NORTH);

        // Armamos la lista de ciudades, que va a ser un List:
        listaPueblos = new List(4, false);

        // Añadimos las ciudades a la lista:
        listaPueblos.add("Buenos Aires");
        listaPueblos.add("La Plata");
        listaPueblos.add("Azul");
        listaPueblos.add("Rosario");
        listaPueblos.add("Córdoba");
        listaPueblos.add("Bahía Blanca");

        add(listaPueblos, BorderLayout.SOUTH);
    }

    public String getDescription() {
        return listaPueblos.getSelectedItem();
    }
}
