import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedQueueTest {
    private DoubleLinkedList<Character> queue;

    @BeforeEach
    void setUp() {
        this.queue = new DoubleLinkedList<>();
    }

    @Test
    void addLast() {
        queue.addLast('a');
        assertEquals(1, queue.size());
        assertEquals('a', queue.showLast());

        queue.addLast('b');
        assertEquals(2, queue.size());
        assertEquals('b', queue.showLast());

        queue.addLast('c');
        assertEquals(3, queue.size());
        assertEquals('c', queue.showLast());

        queue.addFirst('j');
        assertEquals(4, queue.size());
        assertEquals('c', queue.showLast());
    }

    @Test
    void addFirst() {
        queue.addFirst('a');
        assertEquals(1, queue.size());
        assertEquals('a', queue.showFirst());

        queue.addFirst('b');
        assertEquals(2, queue.size());
        assertEquals('b', queue.showFirst());

        queue.addFirst('c');
        assertEquals(3, queue.size());
        assertEquals('c', queue.showFirst());

        queue.addLast('j');
        assertEquals(4, queue.size());
        assertEquals('c', queue.showFirst());
    }

    @Test
    void pull() {
        String test = "Fabricio";

        for (int i = 0; i < test.length(); i++) {
            queue.addLast(test.charAt(i));
        }

        queue.addFirst('H');

        assertEquals(test.length() + 1, queue.size());

        for (int i = 0; i < test.length(); i++) {
            assertEquals(test.charAt(test.length() - 1 - i), queue.pull());
        }

        assertEquals('H', queue.pull());
        assertEquals(0, queue.size());

        assertThrowsExactly(NoSuchElementException.class, () -> queue.pull());
    }

    @Test
    void shift() {
        String test = "Fabricio";

        for (int i = 0; i < test.length(); i++) {
            queue.addLast(test.charAt(i));
        }

        queue.addFirst('H');

        assertEquals(test.length() + 1, queue.size());
        assertEquals('H', queue.shift());

        for (int i = 0; i < test.length(); i++) {
            assertEquals(test.charAt(i), queue.shift());
        }

        assertEquals(0, queue.size());

        assertThrowsExactly(NoSuchElementException.class, () -> queue.pull());
    }
}