
package ucad.fst.stubgenere;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de sch�ma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intA" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="intB" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "intA",
    "intB"
})
@XmlRootElement(name = "Subtract")
public class Subtract {

    protected int intA;
    protected int intB;

    /**
     * Obtient la valeur de la propri�t� intA.
     * 
     */
    public int getIntA() {
        return intA;
    }

    /**
     * D�finit la valeur de la propri�t� intA.
     * 
     */
    public void setIntA(int value) {
        this.intA = value;
    }

    /**
     * Obtient la valeur de la propri�t� intB.
     * 
     */
    public int getIntB() {
        return intB;
    }

    /**
     * D�finit la valeur de la propri�t� intB.
     * 
     */
    public void setIntB(int value) {
        this.intB = value;
    }

}
