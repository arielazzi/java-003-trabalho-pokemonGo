import java.io.File;
import java.io.IOException;

/*
 * Classname             IPokemonGo
 *
 * Version information   1.0.0
 *
 * Date                  06/04/2017
 *
 * author                Ariel S. Azzi
 *
 * Copyright notice      Responsável pela definição da classe PokemonGo
 *
 */

public interface IPokemonGo {

	/* Método responsável pelo carregamento de uma matriz adjacente */
	public void loadMatrix(File file) throws IOException;

	/* Método responsável por gerar um novo cromossomo de forma aleatória */
	public Chromosome generateChromosome();

	/*
     *
     * Método responsável pela inserção ordenada(de forma crescente) em um array dos melhores cromossomos
     * Caso o cromossomo seja pior aos já inseridos, o mesmo é desconsiderado
     * Caso o cromossomo já esteja no array, o mesmo é desconsiderado
     * Caso o cromossomo seja melhor que algum do array, o mesmo é inserido, e o pior é retirado
     *
     */
	public void insertOrderedChromosome(Chromosome chromosome);

	/* Método responsável por calcular a distância total do cromossomo, ou seja, o fitness. */
	public int distance(int[] genes);

	/* Método responsável pela evolução/seleção dos melhores cromosssomos. */
	public void evolve();

    /* Método responsável pela impressão dos melhores cromossomos */
	public void print();
}
