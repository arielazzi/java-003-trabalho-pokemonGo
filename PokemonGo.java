import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Classname             PokemonGo
 *
 * Version information   1.0.0
 *
 * Date                  06/04/2017
 *
 * author                Ariel S. Azzi
 *
 * Copyright notice      Classe responsável por carregar a matriz adjacente, gerar cromossomo, inserir em um array os cromossomos de forma ordenada,
 *                       calcular a distancia e exibir os menores passos.
 *
 */
public class PokemonGo implements IPokemonGo {

    private int[][]      matrix;         // Atributo que armazena a matriz adjacente
    private Chromosome[] topChromosome;  // Atributo que armazena os melhores cromossomos


    public PokemonGo() {
    	matrix        = new int[16][16];
        topChromosome = new Chromosome[10];
    }

    /*
     * @see IPokemonGo#loadMatrix(java.io.File)
     *
     * Método responsável pelo carregamento de uma matriz adjacente
     *
     */
    public void loadMatrix(File file) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line = null;

            int row = 0;
            while ((line = br.readLine()) != null) {

                String[] cols = line.split(";");

                for (int i = 0; i < cols.length; i++) {
                	int valor = Integer.parseInt(cols[i]);
                	matrix[row][i] = valor;
				}

                row++;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    };



}
