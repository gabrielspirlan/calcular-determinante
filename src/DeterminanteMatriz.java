import java.util.Scanner;

public class DeterminanteMatriz {
    
    public int ordem;
    public int linhaTrava;
    public int[][] matriz;
    private Scanner input = new Scanner(System.in);

    /**
     * Inserir uma matriz
     * 
     * Esse método realiza a inserção dos valores de uma matriz com a ordem passada pelo usuário
     */
    void InserirMatriz() {
        System.out.println("Digite a ordem de sua matriz: ");

        // Atributo ordem recebe o dado passado pelo usuário
        this.ordem = input.nextInt();

        // Cria uma matriz quadrada com a ordem passada pelo usuário
        int[][] matrizAux = new int[this.ordem][this.ordem];

        //Realiza a inserção dos dados seguindo o for encadeado, onde o for mais abaixo controla as colunas que estão sendo inseridas enquanto o for mais acima controla a linha que está sendo inserida
        for (int i = 0; i < this.ordem; i++) {
            //For das linhas
            for (int j = 0; j < this.ordem; j++) {
                //For das colunas
                System.out.println("Digite o elemento na linha " + (i + 1) + " coluna " + (j + 1));
                matrizAux[i][j] = input.nextInt(); // Utiliza o atributo matrizAux para realizar a inserção
            }
        }
        matriz = matrizAux; // Atributo matriz a matriz inserida
    }

    /**
     * Método para mostrar no terminal uma matriz
     * @param matrizPrintar Matriz a ser mostrada ao usuário
     * @param ordem Ordem da Matriz
     */
    void PrintarMatriz(int[][] matrizPrintar, int ordem) {
        for (int i = 0; i < ordem; i++) {
            // for das linhas da matriz
            for (int j = 0; j < ordem; j++) {
                // for das colunas da matriz
                System.out.print(matrizPrintar[i][j] + " ");
            }
            System.out.println(); // Quebra de linha entre as matrizes
        }
    }
    /**
     * Método para criar uma NovaMatriz com a ordem menor que a anterior e que usa como base
     * uma matriz já existente
     * @param novaOrdem Ordem da nova matriz
     * @param colunaExcluir Coluna que será excluida na criação da nova matriz
     * @param matrizAnt Matriz anterior que será usada como base para a geração da nova matriz
     * @return Retorna a Matriz criada
     */
    int[][] NovaMatriz(int novaOrdem, int colunaExcluir, int[][] matrizAnt) {
        // Diminuir a ordem da matriz
        // Inserir os dados

        // Matriz criada com a nova ordem
        int[][] novaMatriz = new int[novaOrdem][novaOrdem];

        // As variáveis aux servem para controlar a posição do dado que está na matriz anterior e que será inserido na nova matriz

        // A primeira linha é sempre excluida da inserção já que esá travada
        int auxI = 1; 

        // auxJ iniciada como 0
        int auxJ = 0;

        // Método de repetição que gera a nova matriz
        for (int i = 0; i < novaOrdem; i++) {
            // for das linhas

            for (int j = 0; j < novaOrdem; j++) {
                // For das colunas
                if (auxJ == colunaExcluir) {
                    // Quando a variável auxiliar for igual a coluna a excluir é inserida +1 no valor da variável auxiliar para que seja "pulada" a inserção desse dado
                    auxJ++;
                }

                
                novaMatriz[i][j] = matrizAnt[auxI][auxJ]; // Insere o dado na nova matriz

                // Depois que é feita a inserção a variável auxJ, que controla os dados que estão nas colunas da matriz anteiror e que serão inseridos na nova matriz, tem seu valor acrescido em 1
                auxJ++;
            }
            auxJ = 0; // Zera a variável que controla as colunas da matriz
            auxI++; // Acresce em um a variável que controla as linhas da matriz
        }
        return novaMatriz; // Retorna a matriz criada
    }

    /**
     * Função recursiva que cálcula a determinante de uma matriz seguindo a fórmula
     * @param matriz Recebe uma matriz para calcular a
     * @param ordem recebe a ordem da matriz
     * @return Retorna a determinante cálculada da matriz
     */
    double CalcularDeterminante (int[][] matriz, int ordem) {
        // Calcula a determinante seguindo o teorema de laplace

        if(matriz.length == 1) {
            // Se a matriz tiver ordem 1 retorna o próprio elemento da matriz
            return matriz[0][0];
        }

        double determinante = 0; // Determinante é iniciada em 0
        int novaOrdem = matriz.length - 1; // variável para criação da novaMatriz com a ordem inferior que a matriz que está sendo calculada no momento
        double newMatriz = 0; // novaMatriz é iniciada em 0

        for(int j = 0; j < ordem; j++) {
            // Anda apenas nas colunas, pois a linha está travada na primeira

            // Pega a posição da matriz para descobrir se o valor será positivo ou negativo e multiplica pelo elemento da matriz
            double valor = Math.pow(-1, 1 + (j + 1)) * matriz[0][j];

            if(matriz.length == 2 && matriz[0].length == 2){
                // Se for uma matriz de ordem 2
                if(j == 0){
                    // Verifica se a coluna a ser excluida é a primeira
                    newMatriz = matriz[1][1];
                }
                else if(j == 1) {
                    // Verifica se a coluna a ser excluida é a segunda
                    newMatriz = matriz[1][0];
                }
            }
            else {
                // Se não é uma matriz de ordem 2
                // Calcula a determinante de uma nova matriz que usa como referência a matriz atual e a ordem menor que a atual
               newMatriz = CalcularDeterminante(NovaMatriz(novaOrdem, j, matriz), novaOrdem);
            }
            valor = valor * newMatriz; // Valor descoberto * nova matriz
            determinante += valor; // Somatório da função
        }
        return determinante;
    }
}
