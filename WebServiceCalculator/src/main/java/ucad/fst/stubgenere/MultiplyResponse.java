
package ucad.fst.stubgenere;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="MultiplyResult" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "multiplyResult"
})
@XmlRootElement(name = "MultiplyResponse")
public class MultiplyResponse {

    @XmlElement(name = "MultiplyResult")
    protected int multiplyResult;

    /**
     * Obtient la valeur de la propri�t� multiplyResult.
     * 
     */
    public int getMultiplyResult() {
        return multiplyResult;
    }

    /**
     * D�finit la valeur de la propri�t� multiplyResult.
     * 
     */
    public void setMultiplyResult(int value) {
        this.multiplyResult = value;
    }

}
