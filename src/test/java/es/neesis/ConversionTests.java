package es.neesis;

import es.neesis.client.api.NumberToDollarsResponse;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NumberConversionClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ConversionTests {

    @Autowired
    private NumberConversionClient numberConversionClient;

    @Test
    public void testNumberToWords() {
        NumberToWordsResponse testNumber = numberConversionClient.numberToWords(1);
        assertEquals("one ", testNumber.getNumberToWordsResult());
    }

    @Test
    public void testNumberToDollars() {
        NumberToDollarsResponse testNumber = numberConversionClient.numberToDollars(1);
        assertEquals("one dollar", testNumber.getNumberToDollarsResult());
    }

}
