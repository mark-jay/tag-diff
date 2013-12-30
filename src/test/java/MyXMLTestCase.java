
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

    public void testXmlsNotEquals() throws Exception {
        assertXMLNotEqual("comparing xmls",
                fromResource("KDT_wellformed.xml"), fromResource("buggedKDT-imported-namespace.xml"));
    }

    /**
     * regex '>[^<]+<' -> '><'
     * @throws Exception
     */
    public void testXmlsEquals() throws Exception {
        assertXMLEqual("comparing xmls",
                fromResource("NV_KDT_wellformed.xml"), fromResource("NV_buggedKDT-imported-namespace.xml"));
    }
}
