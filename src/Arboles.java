
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Arboles {

    public static void main(String[] args) {
        int opcion = 0, elemento;
        ArbolBinario bt = new ArbolBinario();

        do {
            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1-Ver Nodo En PreOrden\n"
                        + "2-Ver Nodo En InOrden\n"
                        + "3-Insertar Nodo\n"
                        + "4-Salir\n","Arboles Binarios", JOptionPane.QUESTION_MESSAGE));
                if (opcion == 1) {

                    if (bt.vacio() == true) {
                        JOptionPane.showMessageDialog(null, "El Arbol esta vacio");
                    } else {
                        bt.mostrarInOrden(bt.raiz);

                    }
                } else if (opcion == 2) {
                    if (bt.vacio() == true) {
                        JOptionPane.showMessageDialog(null, "El Arbol esta vacio");
                    } else {
                        bt.mostrarPreOrden(bt.raiz);

                    }
                } else if (opcion == 3) {

                    elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Ingresa el Numero para el nodo"
                    ,"Ingresa El Numero",JOptionPane.QUESTION_MESSAGE));
                    bt.agregar(elemento);
                } else if (opcion == 4) {
                    JOptionPane.showMessageDialog(null, "Finalizado");
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion Invalida");
                }

            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } while (opcion != 4);
    }

}

class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {

        raiz = null;
    }

    public void agregar(int numero) {

        Nodo nuevo = new Nodo(numero);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Nodo auxiliar = raiz;
            Nodo padre;
            while (true) {
                padre = auxiliar;
                if (numero < auxiliar.value) {
                    auxiliar = auxiliar.izq;
                    if (auxiliar == null) {
                        padre.izq = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean vacio() {
        return raiz == null;
    }

    public void mostrarInOrden(Nodo r) {
        if (r != null) {
            mostrarInOrden(r.izq);
            System.out.println(r.value);
            mostrarInOrden(r.der);
        }
    }

    public void mostrarPreOrden(Nodo r) {
        if (r != null) {
            System.out.println(r.value);
            mostrarPreOrden(r.izq);
            mostrarPreOrden(r.der);
        }
    }
}

class Nodo {
    //NO MODIFICAR

    int value;
    Nodo izq;
    Nodo der;

    public Nodo(int value, Nodo izq, Nodo der) {
        this.value = value;
        this.izq = izq;
        this.der = der;
    }

    public Nodo(int value) {

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {

        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

}
