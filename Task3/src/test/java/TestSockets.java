import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSockets {
    @Test
    public void testSockets() {
        ClientSocket client = new ClientSocket();
        client.startConnection("127.0.0.1", 8080);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
