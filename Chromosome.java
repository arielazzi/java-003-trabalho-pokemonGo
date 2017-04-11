
/*
 * Classname             Chromosome
 *
 * Version information   1.0.0
 *
 * Date                  06/04/2017
 *
 * author                Ariel S. Azzi
 * Copyright notice      Um cromossomo é composto por 6 genes em função do comprimento entre o vértice A e o vértice P.
 *
 */

public class Chromosome {

    private int[] genes;
    private int fitness; /* distancia do cromossomo */

    public Chromosome() {}

    public Chromosome(int[] genes, int fitness) {
        this.genes = genes;
        this.fitness = fitness;
    }

    public int[] getGenes() {
        return genes;
    }

    public void setGenes(int[] genes) {
        this.genes = genes;
    }

    public int getFitness() {
        return fitness;
    }

    public void setfitness(int fitness) {
        this.fitness = fitness;
    }

    public String toString() {

        String retorno = fitness+" ";
        for (int i = 0; i < genes.length; i++) {
            retorno += verificaLetra(genes[i]) + " ";
        }
        return retorno;
    }


    private char verificaLetra(int posicao) {
        char letra = 'A';
        if(posicao == 1)
            letra = 'B';
        else if(posicao == 2)
            letra = 'C';
        else if(posicao == 3)
            letra = 'D';
        else if(posicao == 4)
            letra = 'E';
        else if(posicao == 5)
            letra = 'F';
        else if(posicao == 6)
            letra = 'G';
        else if(posicao == 7)
            letra = 'H';
        else if(posicao == 8)
            letra = 'I';
        else if(posicao == 9)
            letra = 'J';
        else if(posicao == 10)
            letra = 'K';
        else if(posicao == 11)
            letra = 'L';
        else if(posicao == 12)
            letra = 'M';
        else if(posicao == 13)
            letra = 'N';
        else if(posicao == 14)
            letra = 'O';
        else if(posicao == 15)
            letra = 'P';

        return letra;
    }
}
