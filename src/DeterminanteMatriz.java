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

    void PrintarMatriz(int[][] matrizPrintar, int linhas, int colunas) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(matrizPrintar[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] NovaMatriz(int linhas, int colunas, int linhaExcluir, int colunaExcluir, int[][] matrizAnt) {
        // Diminuir a ordem da matriz
        // Inserir os dados
        int[][] novaMatriz = new int[linhas][colunas];
        System.out.println("Linhas: " + linhas + "\n Colunas: " + colunas);
        System.out.println("Nova Matriz");
        PrintarMatriz(novaMatriz, linhas, colunas);
        System.out.println("Matriz Anterior");
        PrintarMatriz(matrizAnt, linhas + 1, colunas + 1);
        int auxI = 1;
        int auxJ = 0;
        for (int i = 0; i < linhas; i++) {
            // for das linhas

            for (int j = 0; j < colunas; j++) {
                // For das colunas
                if (auxJ == colunaExcluir) {
                    auxJ++;
                }
                System.out.println("i " + i);
                System.out.println("j " + j);
                novaMatriz[i][j] = matrizAnt[auxI][auxJ]; // Mesma linha e a mesma coluna - erro
                auxJ++;
            }
            auxJ = 0;
            auxI++;
        }
        return novaMatriz;
    }

    double CalcularDeterminante (int[][] matriz, int colunas) {
        System.out.println("CALCULAR DETERMINANTE MATRIZ RECEBIDA");
        PrintarMatriz(matriz, matriz.length, matriz[0].length);
        double determinante = 0;
        int novaLinha = matriz.length - 1;
        int novaColuna = matriz[0].length - 1;
        System.out.println("Passou por aqui");
        double newMatriz = 0;

        for(int j = 0; j < colunas; j++) {
            double valor = Math.pow(-1, 1 + (j + 1)) * matriz[0][j];
            System.out.println("Linhas: " + matriz.length + " Colunas: " + matriz[0].length);
            if(matriz.length == 2 && matriz[0].length == 2){
                if(j == 0){
                    newMatriz = matriz[1][1];
                }
                else if(j == 1) {
                    newMatriz = matriz[1][0];
                }
            }
            else {
               newMatriz = CalcularDeterminante(NovaMatriz(novaLinha, novaColuna, 0, j, matriz), novaColuna);
            }
            valor = valor * newMatriz;
            determinante += valor;
        }
        System.out.println("O valor da determinante é: " + determinante);
        return determinante;
    }
}
