public class Main {

    private static void checkDNA(final String DNA) {
        if (!DNA.matches("[DNA]+")) throw new IllegalArgumentException("DNA com formato inválido!");
    }

    private static void makeDNA(String DNA, DoubleLinkedQueue<DoubleLinkedQueue<String>> queue) {
        char before, now;
        now = DNA.charAt(0);
        before = now;

        for (int i = 1; i < DNA.length(); ++i) {
            now = DNA.charAt(i);
            
            before = now;
        }
    }

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
            DNA.append(args[0]);
        }

        checkDNA(DNA.toString());

        System.out.println(DNA);


    }




}
