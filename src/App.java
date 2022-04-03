//import javax.print.attribute.standard.JobHoldUntil;
//import javax.swing.Icon;
import javax.swing.JOptionPane;


public class App {
    public static void main(String[] args) throws Exception {
       DeterminanteMatriz Matriz1 = new DeterminanteMatriz();
       Matriz1.InserirMatriz();
        int[][] matriz;
        matriz = Matriz1.matriz;  
      
        Matriz1.PrintarMatriz(Matriz1.matriz, Matriz1.ordem);
        JOptionPane.showMessageDialog(null, "O Valor da Determinante é: " + Matriz1.CalcularDeterminante(matriz, matriz[0].length));
    }
}
