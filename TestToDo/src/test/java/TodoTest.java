import com.codeborne.selenide.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;


public class TodoTest {
    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://localhost:3000";
    }

    @Test
    public void userCanAddNotes() {
        open("/");
        TodoPage page = new TodoPage();
        String noteText = "Test note 1";
        page.addNote(noteText);
        page.getNotes().shouldHave(sizeGreaterThan(0));
        page.getNotes().last().shouldHave(text(noteText));
    }

    @Test
    public void userCanMarkNoteComplete() {
        open("/");
        TodoPage page = new TodoPage();
        String noteText = "Test note 2";
        page.addNote(noteText);
        page.markComplete(noteText);
        page.getCompletedNotes().last().shouldHave(text(noteText));
    }

    @Test
    public void userCanRemoveNotes() {
        open("/");
        TodoPage page = new TodoPage();
        String noteText = "Test note 3";
        page.addNote(noteText);
        page.removeNote(noteText);
        sleep(5000);
        if (!page.getNotes().isEmpty())
            page.getNotes().last().shouldNotHave(text(noteText));
    }
}
