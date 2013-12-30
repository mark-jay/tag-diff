
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.XMLTestCase;

import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;

public class MyXMLTestCase extends XMLTestCase {
    public MyXMLTestCase(String name) {
        super(name);
    }

    public static Reader fromResource(String name) throws Exception {
        return new FileReader(new File(Thread.currentThread().getContextClassLoader().getResource(name).toURI()));
    }

    public void testXmlsEquals() throws Exception{
        assertXmlsEquals("KDT_wellformed.xml", "buggedKDT-imported-namespace.xml");
    }

    public void assertXmlsEquals(String xmlName1, String xmlName2) throws Exception {
        assertXMLEqual("comparing xmls", fromResource(xmlName1), fromResource(xmlName2));
    }
}
