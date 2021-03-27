import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class CatToJSONTest {

    @Test
    public void serializeJSON() {
//      Arrange
        Cat cat = new Cat();
        String expectedRes = "{\"name\":\"Barsick\",\"weight\":20}";
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

//      Act
        try {
            mapper.writeValue(writer, cat);
        } catch (IOException e) {
            e.printStackTrace();
        }

//      Assert
        String actualRes = writer.toString();
        assertEquals(actualRes, expectedRes);
    }

    @Test
    public void deserializeJSON() throws JsonProcessingException {
        // Arrange
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "{\"name\":\"Barsick\",\"weight\":20}";
        Cat expectedCat = new Cat();

        // Act
        Cat actualCat = mapper.readValue(jsonInString, Cat.class);

        // Assert
        assertEquals(actualCat, expectedCat);
    }
}
