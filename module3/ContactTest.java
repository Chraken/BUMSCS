import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    private Contact contact;

    @BeforeEach
    void setUp() {
        contact = new Contact("Ada Lovelace", "+1 617 555 0101");
    }

    @Test
    void getName_returnsCorrectName() {
        assertEquals("Ada Lovelace", contact.getName());
    }

    @Test
    void getPhone_returnsCorrectPhone() {
        assertEquals("+1 617 555 0101", contact.getPhone());
    }
    @Test
    void toString_containsName() {
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("Alan Turing"));
    }

    @Test
    void toString_containsPhone() {
        Contact c = new Contact("Alan Turing", "555-0001");
        assertTrue(c.toString().contains("555-0001"));
    }
}