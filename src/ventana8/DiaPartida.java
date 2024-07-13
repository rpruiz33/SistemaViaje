package ventana8;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;

class DiaPartida extends Panel {
    TextField elDia;
    Button hoy;
    Button diasiguiente;

    DiaPartida() {
        setLayout(new GridLayout(4, 1));
        elDia = new TextField();
        elDia.setText(getHoy());
        hoy = new Button("Hoy");
        diasiguiente = new Button("Mañana");
        add(new Label("Día salida: "));
        add(elDia);
        add(hoy);
        add(diasiguiente);
    }

    String getHoy() {
        Calendar cal = Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH) + 1; // Los meses comienzan desde 0 en Calendar
        int ano = cal.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + ano;
    }

    String getManana() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes = cal.get(Calendar.MONTH) + 1;
        int ano = cal.get(Calendar.YEAR);
        return dia + "/" + mes + "/" + ano;
    }

    public String getDescription() {
        return elDia.getText();
    }
}
