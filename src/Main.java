public class Main {
    private static long op = 0;



    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Necessário a quantidade de cadeias ou a cadeia");
            System.exit(1);
        }

        final StringBuilder DNA = new StringBuilder();

        try {
           final int total = Integer.parseInt(args[0]);
           final char[] bas = {'D', 'N', 'A'};

           for (int i = 0; i < total; ++i) {
               DNA.append( bas[(int) Math.floor(Math.random() * bas.length)] );
           }
        } catch (NumberFormatException ignored) {
            DNA.append(args[0].toUpperCase());
        }

        DNAAnalysis.checkDNA(DNA.toString());

        System.out.println("Sua cedeia: " + DNA);
        DoubleLinkedList<DoubleLinkedList<Character>> queue = new DoubleLinkedList<>();
        DNAAnalysis.makeDNA(DNA.toString(), queue);
        //System.out.println("agora: " + queue);
        DNAAnalysis.apllyDegenerations(queue);
        System.out.println("DNA degenerado: " + queue.toString().replaceAll("[{}, ]", ""));
    }




}
