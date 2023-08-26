public class Main {

    /**
     * Verifica se a string passada tem um formato válido, ou seja, contenha apenas os caracteres 'D', 'N' e 'A'
     *
     * @param DNA: String que contem a sequência de DNA
     */
    private static void checkDNA(final String DNA) {
        if (!DNA.matches("[DNA]+")) throw new IllegalArgumentException("DNA com formato inválido!");
    }

    /**
     * método responsável por separa e agrupar sequencia de caracteres
     * <br/>
     * complexidade O(N)
     *
     * @param DNA: String contendo o DNA
     * @param queue: Fila que será atribuída a sequencia
     */
    private static void makeDNA(String DNA, DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue) {
        char before, now;
        now = DNA.charAt(0);
        before = '$';

        DoubleLinkedQueue<Character> ruptSpot = null;

        for (int i = 0; i < DNA.length(); ++i) {
            now = DNA.charAt(i);

            if (now == before) {
                queue.showLast().addLast(now);
            } else {
               ruptSpot = new DoubleLinkedQueue<>();
               ruptSpot.addLast(now);
               queue.addLast(ruptSpot);
            }

            before = now;
        }

    }

    /**
     * Método responsável por mutar o DNA seguindo as normas do trabalho
     * <br/>
     * complexidade: O(1)
     *
     * @param first: primeiro base da cadeia de DNA
     * @param second: segunda base da cadeia de DNA
     * @return A degeneração ocorrida em formato de Character
     */
    private static char permute(char first, char second) {
        final char D = 'D';
        final char N = 'N';
        final char A = 'A';

        if ((first + second) == (D + N)) return A;
        if ((first + second) == (D + A)) return N;
        if ((first + second) == (N + A)) return D;

        return first;
    }

    private static void degen(DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue) {
        DoubleLinkedQueue<Character> firstSequence = null;
        DoubleLinkedQueue<Character> secondSequence = null;

        if (queue.size() <= 1) {
            System.out.println("Sem degeneração Nesta cadeia");
            return;
        }

        int deepStep = 1;
        System.out.println("passo 0: " + queue);
        while (queue.size() > 1) {
            if (firstSequence == null)  firstSequence = queue.shift();
            if (secondSequence == null) secondSequence = queue.shift();

            char lastCharacterOutFirst = firstSequence.pull();
            char firstCharacterOutLast = secondSequence.shift();

            char degeneratedCharacter = permute(lastCharacterOutFirst, firstCharacterOutLast);

            if (!secondSequence.isEmpty())
                queue.addFirst(secondSequence);

            if (!firstSequence.isEmpty())
                queue.addFirst(firstSequence);
            
            if (!queue.isEmpty() && queue.showLast().showLast() == degeneratedCharacter) {
                queue.showLast().addLast(degeneratedCharacter);
            } else {
                DoubleLinkedQueue<Character> characterDoubleLinkedQueue = new DoubleLinkedQueue<>();
                characterDoubleLinkedQueue.addLast(degeneratedCharacter);
                queue.addLast(characterDoubleLinkedQueue);
            }

            System.out.println("passo " + (deepStep++) + ": " + queue);
            firstSequence = null;
            secondSequence = null;
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
            DNA.append(args[0].toUpperCase());
        }

        checkDNA(DNA.toString());

        System.out.println(DNA);
        DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue = new DoubleLinkedQueue<>();
        makeDNA(DNA.toString(), queue);
        //System.out.println("agora: " + queue);
        degen(queue);
        System.out.println("DNA degenerado: " + queue.toString().replaceAll("[{}, ]", ""));
    }




}
