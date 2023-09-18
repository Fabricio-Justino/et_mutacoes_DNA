import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    
    private static boolean makeSample() {
        final String FILE_PATH = "./sample_xy.txt";
        final File FILE = new File(FILE_PATH);
        
        char D_N_A[] = {'D', 'N', 'A'};
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < ((int) (5 + Math.random() * (1000 - 5))); j++) {
                char ch = D_N_A[(int) Math.floor(Math.random() * 3)];
                builder.append(ch);
            }
            sb.append(builder.toString()).append('\n');
        }

        try (FileWriter writer = new FileWriter(FILE)) {
            writer.append(sb.toString());
            return true;
        } catch (IOException ex) {
            System.out.println("Arquivo inexistente");
            return false;
        }
    }

    private static void readFile(File file) {
        try (Scanner reader = new Scanner(file)) {

            String line = null;
            StringBuilder builder = new StringBuilder();
            while (reader.hasNextLine()) {
                line = reader.nextLine();
                DNAAnalysis.checkDNA(line);
                DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue = new DoubleLinkedQueue<>();
               
                double start = System.nanoTime();
                DNAAnalysis.makeDNA(line, queue);
                DNAAnalysis.apllyDegenerations(queue);
                double end = System.nanoTime();

                builder.append(String.format("-> degeneração: %s%n", queue.toString().replaceAll("[{}, ]", "")))
                .append(String.format("tempo: %.2f s%n", ((end - start) / 1e9)));
            }
            System.out.println(builder);
        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }
    }

    public static void main(String[] args) {
        
        if (args.length < 1) {
            System.err.println("Inclua um diretório de arquivo!");
            System.exit(1);
        }

        if (args.length == 1 && args[0].equals("sample") && makeSample()) {
            System.out.println("File Example criado com sucesso");
            System.exit(1);
        }
        
        final String FILE_PATH = args[0];
        final File FILE = new File(FILE_PATH);
        if (FILE.exists()) readFile(FILE);
        else System.out.println("arquivo não encontrado");
    }
}
