import java.util.Scanner;

public class DeterminanteMatriz {
    public int linhas;
    public int colunas;
    public int linhaTrava;
    public int[][] matriz;
    private Scanner input = new Scanner(System.in);

    void InserirMatriz() {
        System.out.println("Digite a quantidade de linhas da matriz: ");
        this.linhas = input.nextInt();
        System.out.println("Digite a quantidade de colunas da matriz: ");
        this.colunas = input.nextInt();

        int[][] matrizAux = new int[this.linhas][this.colunas];
        for (int i = 0; i < this.linhas; i++) {
            for (int j = 0; j < this.colunas; j++) {
                System.out.println("Digite o elemento na linha " + (i + 1) + " coluna " + (j + 1));
                matrizAux[i][j] = input.nextInt();
            }
        }
        matriz = matrizAux;
    }

    int[][] NovaMatriz (int linhas, int colunas, int linhaExcluir, int colunaExcluir) {
        // Diminuir a ordem da matriz
        // Inserir os dados
        int[][] novaMatriz = new int[linhas][colunas]; 
        for(int i = 0; i < this.linhas; i++) {
            for(int j = 0; j < this.colunas; j++) {
                if(i != linhaExcluir && j != colunaExcluir){
                novaMatriz[i][j] = matriz[i][j]; // Mesma linha e a mesma coluna - erro
            }
            }
        }
        return novaMatriz; 
    }

    double CalcularDeterminante (int[][] matriz) {
        double determinante = 0;
        for(int j = 0; j < this.colunas; j++) {
            double valor = Math.pow(-1, 0 + j) * matriz[0][j];
            double newMatriz = CalcularDeterminante(NovaMatriz(matriz.length - 2, matriz[0].length - 2, 0, j));
            valor *= newMatriz;
            determinante += valor;
        }
        System.out.println("O valor da determinante é: ");
        return determinante;
    }
}