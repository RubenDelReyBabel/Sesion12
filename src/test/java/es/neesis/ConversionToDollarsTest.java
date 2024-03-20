package es.neesis;

import es.neesis.client.api.NumberToDollarsResponse;
import es.neesis.client.api.NumberToWordsResponse;
import es.neesis.client.client.NumberConversionClient;
import es.neesis.client.config.NumberConversionClientConfig;
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
public class ConversionToDollarsTest {

    @Autowired
    private NumberConversionClient numberConversionClient;

    @Test
    public void testNumberToDollarsValid() {
        NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(1);
        assertEquals("one dollar", testNumber.getNumberToDollarsResult());
    }

    @Test
    public void testNumberToDollarsNegative() {
        try {
            NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(-1);
            fail();
        } catch (Exception e) {
            assertEquals("Number must be positive", e.getMessage());
        }

    }

    @Test
    public void testNumberToDollarsTooManyCents() {
        NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(1.55555);
        assertEquals("one dollar and fifty five cents", testNumber.getNumberToDollarsResult());
    }

    @Test
    public void testNumberToDollarsUpperLimit() {
        NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(1000000000);
        assertEquals("one billion dollars", testNumber.getNumberToDollarsResult());
    }

    @Test
    public void testNumberToDollarsLowerLimit() {
        NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(0);
        assertEquals("", testNumber.getNumberToDollarsResult());
    }
}
