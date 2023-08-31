import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class GraphDots {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        
        double MAX_X = 0;
        if(args.length == 0){
            MAX_X = 1e4;
        } else if (args.length > 1) {
            System.err.println("Informe um número");
            System.exit(1);
        } else {
            try {
                MAX_X = Double.parseDouble(args[0]);
            } catch (NumberFormatException ex) {
                System.err.println("argumento deve ser um número");
                System.exit(1);
            }
        }

        System.out.println("-> Running ...");
        char[] DNAArray = {'D', 'N', 'A'};
        StringBuilder DNA = new StringBuilder();
        String dna = "";

        
        final double[] y = new double[(int) MAX_X];

        final DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue = new DoubleLinkedQueue<>();

        System.out.println("-> Gerando cadeias");
        for (int i = 0; i < MAX_X; i++) {
            for (int j = 0; j < i + 1; j++) {
                DNA.append(DNAArray[(int) Math.floor(Math.random() * DNAArray.length)]);
            }

            //System.out.println("dna: " + DNA);
            dna = DNA.toString();
            DNA = new StringBuilder();

            DNAAnalysis.makeDNA(dna, queue);
            DNAAnalysis.apllyDegenerations(queue);

            DNAAnalysis.checkDNA(dna);
            y[i] = DNAAnalysis.op;
            DNAAnalysis.op = 0;
        }
        System.out.println("-> Cadeias Geradas");

        File file = new File(".\\xy.txt");

        System.out.println("-> Escrevendo no arquivo ...");
        try (FileWriter writer = new FileWriter(file)) {
            for (int xx = 0; xx < MAX_X; xx++) {
                double yy = y[xx];
                writer.write(String.format("%.2f;%.2f%n", ((double) xx), yy));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-> Pontos Gerados");
    }
}
