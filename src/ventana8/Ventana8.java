package ventana8;

import java.awt.*;
import java.awt.event.*;

class Ventana8 extends Frame {
    SelecPueblo cs; // ciudad de salida
    SelecPueblo cl; // ciudad de llegada
    DiaPartida dp; // día de salida
    Button ok; // botón de compra de pasajes
    boolean enApplet; // para indicar si es un applet o no

    Ventana8(String titulo, boolean enApplet) { // un constructor
        super(titulo); // llama al de Frame
        this.enApplet = enApplet; // guardamos esto

        setLayout(new BorderLayout(20, 20));

        dp = new DiaPartida(); // DIA DE SALIDA
        add(dp, BorderLayout.WEST);

        cs = new SelecPueblo("SALIDA"); // CIUDAD DE SALIDA
        add(cs, BorderLayout.CENTER);

        cl = new SelecPueblo("LLEGADA"); // CIUDAD DE LLEGADA
        add(cl, BorderLayout.EAST);

        ok = new Button("Viaje: de ? a ? el ?/?/?");
        add(ok, BorderLayout.SOUTH);

        // Añadir listeners para actualizar el botón
        cs.listaPueblos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ActualizaBoton();
            }
        });

        cl.listaPueblos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                ActualizaBoton();
            }
        });

        dp.hoy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dp.elDia.setText(dp.getHoy());
                ActualizaBoton();
            }
        });

        dp.diasiguiente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dp.elDia.setText(dp.getManana());
                ActualizaBoton();
            }
        });

        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String salida = cs.getDescription();
                String llegada = cl.getDescription();
                String dia = dp.getDescription();
                String texto = "Viaje de " + salida + " a " + llegada + " el " + dia;
                new Result8("Resultado del Viaje", texto);
            }
        });

        pack(); // dimensionamos la ventana
        setVisible(true); // y la mostramos

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    void ActualizaBoton() {
        StringBuilder b = new StringBuilder("Viaje: de ");
        if (cs.getDescription() != null) b.append(cs.getDescription());
        else b.append("?");
        b.append(" a ");
        if (cl.getDescription() != null) b.append(cl.getDescription());
        else b.append("?");
        b.append(" el ");
        if (dp.getDescription() != null) b.append(dp.getDescription());
        else b.append("?/?/?");
        ok.setLabel(b.toString());
    }

    public static void main(String[] args) {
        new Ventana8("Compra de Pasajes", false);
    }
}
