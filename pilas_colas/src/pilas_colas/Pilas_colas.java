package pilas_colas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Pilas_colas implements ActionListener{
    private JFrame frame;
    private JButton pilaButton, colaButton;
    private JTextArea outputArea;
    private Stack<Integer> pila;
    private Queue<Integer> cola;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pilas_colas window = new Pilas_colas();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Pilas_colas() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Pilas y Colas UMG");

        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        

        pilaButton = new JButton("Procesar con Pila");
        pilaButton.addActionListener(this);
        buttonPanel.add(pilaButton);

        colaButton = new JButton("Procesar con Cola");
        colaButton.addActionListener(this);
        buttonPanel.add(colaButton);

        outputArea = new JTextArea();
        frame.getContentPane().add(outputArea, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent event) {
        outputArea.setText("");
        pila = new Stack<Integer>();
        cola = new LinkedList<Integer>();

        int[] numeros = new int[1000000];
        Random rand = new Random();
        for (int i = 0; i < 1000000; i++) {
            numeros[i] = rand.nextInt(20000001) - 10000000;
        }
        outputArea.append("¡Generación de números aleatorios completada!\n\n");

        if (event.getSource() == pilaButton) {
            for (int i = 0; i < 1000000; i++) {
                pila.push(numeros[i]);
            }
            outputArea.append("Extracción de números de la pila:\n");
            while (!pila.isEmpty()) {
                outputArea.append(pila.pop() + "\n");
            }
        } else if (event.getSource() == colaButton) {
            for (int i = 0; i < 1000000; i++) {
                cola.add(numeros[i]);
            }
            outputArea.append("Extracción de números de la cola:\n");
            while (!cola.isEmpty()) {
                outputArea.append(cola.remove() + "\n");
            }
        }
    }
}



