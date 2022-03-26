3public class App {
    public static void main(String[] args) throws Exception {
       DeterminanteMatriz Matriz1 = new DeterminanteMatriz();
       Matriz1.InserirMatriz();

       Matriz1.CalcularDeterminante(Matriz1.matriz);
    }
}
