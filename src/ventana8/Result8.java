package ventana8;

import java.awt.*;
import java.awt.event.*;

class Result8 extends Frame {
    Button r_ok;

    Result8(String titulo, String texto) {
        super(titulo);
        setLayout(new BorderLayout());

        Label r_lbl = new Label(texto);
        r_ok = new Button("Ok");

        add(r_lbl, BorderLayout.CENTER);
        add(r_ok, BorderLayout.SOUTH);

        r_ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Result8("Resultado", "Este es un ejemplo de resultado.");
    }
}
