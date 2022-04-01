public class App {
    public static void main(String[] args) throws Exception {
       DeterminanteMatriz Matriz1 = new DeterminanteMatriz();
       Matriz1.InserirMatriz();
        int[][] matriz;
        matriz = Matriz1.matriz;
        System.out.println("O Valor da Determinante é: " + Matriz1.CalcularDeterminante(matriz, matriz[0].length ));
       
    }
}
