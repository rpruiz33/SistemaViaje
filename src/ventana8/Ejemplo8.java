package ventana8;

// Archivo: Ejemplo8.java
// Compilar con "javac Ejemplo8.java"
import java.awt.*;
import java.applet.*;
public class Ejemplo8 extends Applet {
public static void main (String arg[]) { // para poder llamarla con "java Ejemplo8"
new Ventana8("Ejemplo Standalone", true);
}
public void init() { // se ejecuta al abrirse un applet
new Ventana8("Ejemplo Applet", false);
}
}