import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CatToXMLTest {

    @Test
    public void serializeXML() throws JsonProcessingException {
        // Arrange
        XmlMapper xmlMapper = new XmlMapper();
        String expectedCat = "<Cat><name>Barsick</name><weight>20</weight></Cat>";

        // Act
        String actualCat = xmlMapper.writeValueAsString(new Cat());

        // Assert
        assertEquals(actualCat, expectedCat);
    }

    @Test
    public void deserializeXML() throws JsonProcessingException {
        // Arrange
        XmlMapper xmlMapper = new XmlMapper();
        String expectedCatString = "<Cat><name>Barsick</name><weight>20</weight></Cat>";
        Cat expectedCat = new Cat();

        // Act
        Cat actualCat = xmlMapper.readValue(expectedCatString, Cat.class);

        // Assert
        assertEquals(actualCat, expectedCat);
    }

}
