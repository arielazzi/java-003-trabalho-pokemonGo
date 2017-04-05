import java.io.File;
import java.io.IOException;

public interface IPokemonGo {

	public void loadMatrix(File file) throws IOException;
		
	public Chromosome generateChromosome();

	public void insertOrderedChromosome(Chromosome chromosome);

	public int distance(int[] genes);

	public void evolve();

	public void print();
}
