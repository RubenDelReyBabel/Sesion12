package es.neesis.client.client;

import es.neesis.client.api.NumberToDollars;
import es.neesis.client.api.NumberToDollarsResponse;
import es.neesis.client.api.NumberToWords;
import es.neesis.client.api.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberConversionClient extends WebServiceGatewaySupport {

    public NumberToDollarsResponse numberToDollars(double number){
        NumberToDollars request = new NumberToDollars();

        if(number < 0)
            throw new IllegalArgumentException("Number must be positive");

        request.setDNum(BigDecimal.valueOf(number));

        return (NumberToDollarsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }

    public NumberToWordsResponse numberToWords(int number){
        NumberToWords request = new NumberToWords();
        request.setUbiNum(new BigInteger(String.valueOf(number)));

        if(number < 0)
            throw new IllegalArgumentException("Number must be positive");

        return (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(request);
    }
}
