package es.neesis;

import es.neesis.client.api.NumberToWordsResponse;
import es.neesis.client.config.NumberConversionClientConfig;
import es.neesis.client.client.NumberConversionClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NumberConversionClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ConversionToWordsTests {

    @Autowired
    private NumberConversionClient numberConversionClient;

    @Test
    public void testNumberToWordsValid() {
        NumberToWordsResponse testNumber = numberConversionClient.numberToWords(1);
        assertEquals("one ", testNumber.getNumberToWordsResult());
    }

    @Test
    public void testNumberToWordsNegative() {
        try {
            NumberToWordsResponse testNumber = numberConversionClient.numberToWords(-1);
            fail();
        } catch (Exception e) {
            assertEquals("Number must be positive", e.getMessage());
        }
    }

    @Test
    public void testNumberToDollarsUpperLimit() {
        NumberToWordsResponse testNumber = numberConversionClient.numberToWords(1000000000);
        assertEquals("one billion", testNumber.getNumberToWordsResult());
    }

    @Test
    public void testNumberToDollarsLowerLimit() {
        NumberToWordsResponse testNumber = numberConversionClient.numberToWords(0);
        assertEquals("zero", testNumber.getNumberToWordsResult());
    }
}
