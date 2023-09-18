import java.util.NoSuchElementException;

/**
 *
 * @param <T> : tipo da fila
 */
public class DoubleLinkedList<T> {

    private class Node {
        Node next;
        Node prev;

        T value;

        Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        Node(T value) {
            this(value, null, null);
        }
    }

    private int size;
    private Node header;
    private Node trailer;

    DoubleLinkedList() {
        this.size = 0;
        this.header = null;
        this.trailer = null;
    }

    /**
     * Adiciona um elemento no final da fila.
     * <br>
     * complexidade: O(1)
     *
     * @param value o valor que será inserido
     */
    public void addLast(T value) {
        final Node node = new Node(value, null, this.header);

        if (this.isEmpty())
            this.trailer = node;
        else
            this.header.next = node;

        this.header = node;

        size++;
    }

    /**
     * Adiciona um elemento no começo da fila.
     * <br>
     * complexidade: O(1)
     *
     * @param value o valor que será inserido
     */
    public void addFirst(T value) {
        final Node node = new Node(value, this.trailer, null);

        if (this.isEmpty())
            this.header = node;
        else
            this.trailer.prev = node;

        this.trailer = node;

        size++;
    }

    /**
     * método que <strong>retorna e remove</strong> o elemento contido no {@link #header}, ou seja, o último elemento da fila.
     *<br>
     * complexidade: O(1)
     *
     * @return T: tipo de dado da fila
     * @throws NoSuchElementException se o <strong>tamanho da fila</strong> for <strong>0</strong>
     */
    public T pull() {
        if (this.isEmpty())
            throw new NoSuchElementException("The queue is empty", new Throwable("trying to remove non-element"));

        final Node node = this.header;
        this.header = node.prev;

        if (this.header != null)
            this.header.next = null;

        this.size--;

        return node.value;
    }

    /**
     * método que <strong>retorna e remove</strong> o elemento contido no {@link #trailer}, ou seja, o primeiro elemento da fila.
     *<br>
     * complexidade: O(1)
     *
     * @return T: tipo de dado da fila
     * @throws NoSuchElementException se o <strong>tamanho da fila</strong> for <strong>0</strong>
     */
    public T shift() {
        if (this.isEmpty())
            throw new NoSuchElementException("The queue is empty", new Throwable("trying to remove non-element"));

        final Node node = this.trailer;
        this.trailer = node.next;

        if (this.trailer != null)
            this.trailer.prev = null;

        this.size--;
        return node.value;
    }

    /**
     * método que <strong>somente retorna</strong> o elemento contido no {@link #header}, ou seja, o último
     * elemento da fila.
     * 
     * @return T: tipo de dado da fila ou null se a fila estiver vazia
     * @throws NoSuchElementException se o <strong>tamanho da fila</strong> for <strong>0</strong>
     * @complexity O(1)
     */
    public T showLast() {
        return !this.isEmpty() ? this.header.value : null;
    }


    public void concat(DoubleLinkedList<T> queue) {
        if (isEmpty()) {
            this.header = queue.header;
            this.trailer = queue.trailer;
        } else if (!queue.isEmpty()) {
           Node node = queue.trailer;
           this.header.next = node;
           node.prev = this.header;
           this.header = queue.header;
           queue.trailer = this.trailer;

           this.size += queue.size;
           queue.size += this.size;
        }
    }

    /**
     * método que <strong>somente retorna</strong> o elemento contido no {@link #trailer}, ou seja, o primeiro elemento da fila.
     *<br>
     *
     * @return T: tipo de dado da fila ou null se a fila estiver vazia
     * @throws NoSuchElementException se o <strong>tamanho da fila</strong> for <strong>0</strong>
     * @complexity O(1)
     */
    public T showFirst() {
        return !this.isEmpty() ? this.trailer.value : null;
    }

    public void clear() {
        this.size = 0;
        this.trailer = null;
        this.header  = null;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        builder.append("{");
        for (Node node = this.trailer; node != null; node = node.next)
            builder.append(String.format("%s%s", node.value.toString(), (node.next != null ? ", " : "")));
        builder.append("}");

        return builder.toString();
    }
}
