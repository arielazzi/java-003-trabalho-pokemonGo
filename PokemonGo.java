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


    /*
     * @see IPokemonGo#generateChromosome()
     *
     * Método responsável por gerar um novo cromossomo de forma aleatória
     *
     */

    public Chromosome generateChromosome() {

        int[] genes = new int[6];

        genes[0] = 0;
        genes[1] = this.randomWithRange(1,3);
        genes[2] = this.randomWithRange(4,7);
        genes[3] = this.randomWithRange(8,11);
        genes[4] = this.randomWithRange(12,14);
        genes[5] = 15;

        int fitness = distance(genes);

        Chromosome chromosome = new Chromosome(genes, fitness);

        return chromosome;
    };


    /*
     * Método responsável por gerar um numero aleatório entre dois números
     *
     */
    private int randomWithRange(int min, int max) {
       int range = (max - min) + 1;
       return (int)(Math.random() * range) + min;
    }



    /*
     * @see IPokemonGo#insertOrderedChromosome(Chromosome)
     *
     * Método responsável pela inserção ordenada(de forma crescente) em um array dos melhores cromossomos
     * Caso o cromossomo seja pior aos já inseridos, o mesmo é desconsiderado
     * Caso o cromossomo já esteja no array, o mesmo é desconsiderado
     * Caso o cromossomo seja melhor que algum do array, o mesmo é inserido, e o pior é retirado
     *
     */
    public void insertOrderedChromosome(Chromosome chromosome) {

        for (int i = 0; i < topChromosome.length; i++) {

            if (topChromosome[i] == null) {

                topChromosome[i] = chromosome;
                break;

            } else if(chromosome.getFitness() == topChromosome[i].getFitness()) {

            	boolean chIdentico = true;
            	for (int j = 0; j < chromosome.getGenes().length; j++) {
            		if(chromosome.getGenes()[j] != topChromosome[i].getGenes()[j]){
            			chIdentico = false;
            		}
				}
            	if(chIdentico == true) break;

            } else if(chromosome.getFitness() < topChromosome[i].getFitness()) {

                Chromosome temp  = topChromosome[i];
                topChromosome[i] = chromosome;
                chromosome       = temp;
            }
        }


    };


    /*
     * @see IPokemonGo#distance(int[])
     *
     * Método responsável por calcular a distância total do cromossomo, ou seja, o fitness.
     *
     */
    public int distance(int[] genes) {
        int total = 0;
        for (int i = 0;i < genes.length; i++) {
            if (i < 5) {
            	total += matrix[genes[i]][genes[i+1]];
            }
        }

        return total;
    }


    /*
     * @see IPokemonGo#evolve()
     *
     * Método responsável pela evolução/seleção dos melhores cromosssomos.
     *
     */
    public void evolve() {

        for (int i = 0; i < 100; i++) {
            insertOrderedChromosome(generateChromosome());
        }
    };


    /*
     * @see IPokemonGo#print()
     *
     * Método responsável pela impressão dos melhores cromossomos
     *
     */
    public void print() {

        for (int i = 0; i < topChromosome.length; i++) {
            System.out.print("Short path -> " + topChromosome[i]);
            System.out.print("\n");
        }

    };




}
