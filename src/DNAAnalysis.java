public class DNAAnalysis {
    public static int op = 0;

    /**
     * Verifica se a string passada tem um formato válido, ou seja, contenha apenas os caracteres 'D', 'N' e 'A'
     *
     * @param DNA: String que contem a sequência de DNA
     */
    public static void checkDNA(final String DNA) {
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
    public static void makeDNA(String DNA, DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue) {
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
            op++;
        }

    }

    /**
     * Método responsável por mutar o DNA seguindo as normas do trabalho
     * <br/>
     * complexidade: O(1)
     *
     * @param base1: primeiro base da cadeia de DNA
     * @param base2: segunda base da cadeia de DNA
     * @return A degeneração ocorrida em formato de Character
     */
    public static char applyMutation(char base1, char base2) {
        final char D = 'D';
        final char N = 'N';
        final char A = 'A';

        if ((base1 + base2) == (D + N)) return A;
        if ((base1 + base2) == (D + A)) return N;
        if ((base1 + base2) == (N + A)) return D;

        return base1;
    }

    public static void apllyDegenerations(DoubleLinkedQueue<DoubleLinkedQueue<Character>> queue) {
        DoubleLinkedQueue<Character> firstSequence = null;
        DoubleLinkedQueue<Character> secondSequence = null;

        if (queue.size() <= 1) {
            System.out.println("Sem degeneração Nesta cadeia");
            return;
        }

        int deepStep = 1;
        //System.out.println("passo 0: " + queue);
        while (queue.size() > 1) {
            if (firstSequence == null)  firstSequence = queue.shift();
            if (secondSequence == null) secondSequence = queue.shift();

            char lastCharacterOutFirst = firstSequence.pull();
            char firstCharacterOutLast = secondSequence.shift();

            char degeneratedCharacter = applyMutation(lastCharacterOutFirst, firstCharacterOutLast);

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

            //System.out.println("passo " + (deepStep++) + ": " + queue);
            firstSequence = null;
            secondSequence = null;
            op++;
        }
    }
}
