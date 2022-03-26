public class App {
    public static void main(String[] args) throws Exception {
       DeterminanteMatriz Matriz1 = new DeterminanteMatriz();
       Matriz1.InserirMatriz();
        int[][] matriz;
        matriz = Matriz1.matriz;
       Matriz1.CalcularDeterminante(matriz, matriz[0].length );
    }
}
