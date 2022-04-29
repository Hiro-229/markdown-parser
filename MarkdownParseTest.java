import static org.junit.Assert.*; //import the needed Junit assert class
import org.junit.*; //import the org.Junit class files
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
public class MarkdownParseTest { //class header/new class creation
    @Test //singlas there is a new test
    public void addition() { //test method created
        assertEquals(2, 1 + 1); //compares the expected with the actual, 
                                        //and will only work if they match
    }

    @Test
    public void MarkdownParseTest(){
        ArrayList<String> testResutl= MarkdownParse.getLinks("test-file.md");
        

    }
}