import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CatToBinaryTest {

    public static byte[] toStream(Cat cat) {
        byte[] stream = null;

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos);) {
            oos.writeObject(cat);
            stream = baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    public static Cat toCat(byte[] stream) {
        Cat cat = null;

        try (ByteArrayInputStream bais = new ByteArrayInputStream(stream);
             ObjectInputStream ois = new ObjectInputStream(bais);) {
            cat = (Cat) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cat;
    }

    @Test
    public void serializeBinary() {
//      Arrange
        Cat cat = new Cat();
        String expectedArr = "[-84, -19, 0, 5, 115, 114, 0, 3, 67, 97, 116, -41, 3, -8, -57, -39, 52, 110, 95, 2, 0, 2, 73, 0, 6, 119, 101, 105, 103, 104, 116, 76, 0, 4, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 0, 0, 0, 20, 116, 0, 7, 66, 97, 114, 115, 105, 99, 107]";

//      Act
        byte[] stream = toStream(cat);

//      Assert
        assertEquals(Arrays.toString(stream), expectedArr);
    }

    @Test
    public void deserializeBinary() {
//      Arrange
        Cat catToStream = new Cat();
        Cat expectedCat = new Cat();
        byte [] stream = toStream(catToStream);

//      Act
        Cat actualCat = toCat(stream);

//      Assert
        assertEquals(actualCat, expectedCat);
    }
}
