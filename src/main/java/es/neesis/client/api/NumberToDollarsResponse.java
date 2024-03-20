//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v2.3.7 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.03.20 a las 10:54:35 AM CET 
//


package es.neesis.client.api;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="NumberToDollarsResult" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numberToDollarsResult"
})
@XmlRootElement(name = "NumberToDollarsResponse")
public class NumberToDollarsResponse {

    @XmlElement(name = "NumberToDollarsResult", required = true)
    protected String numberToDollarsResult;

    /**
     * Obtiene el valor de la propiedad numberToDollarsResult.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }

    /**
     * Define el valor de la propiedad numberToDollarsResult.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberToDollarsResult(String value) {
        this.numberToDollarsResult = value;
    }

}
