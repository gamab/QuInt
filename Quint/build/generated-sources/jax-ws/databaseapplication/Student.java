
package databaseapplication;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for student complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="student"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="admin" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="adresse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="code_postal" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="commune" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="conducteur" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="cv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="notif" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="prenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "student", propOrder = {
    "admin",
    "adresse",
    "codePostal",
    "commune",
    "conducteur",
    "cv",
    "email",
    "nom",
    "notif",
    "password",
    "prenom",
    "tel"
})
public class Student {

    protected int admin;
    protected String adresse;
    @XmlElement(name = "code_postal")
    protected int codePostal;
    protected String commune;
    protected int conducteur;
    protected String cv;
    protected String email;
    protected String nom;
    protected int notif;
    protected String password;
    protected String prenom;
    protected String tel;

    /**
     * Gets the value of the admin property.
     * 
     */
    public int getAdmin() {
        return admin;
    }

    /**
     * Sets the value of the admin property.
     * 
     */
    public void setAdmin(int value) {
        this.admin = value;
    }

    /**
     * Gets the value of the adresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresse() {
        return adresse;
    }

    /**
     * Sets the value of the adresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresse(String value) {
        this.adresse = value;
    }

    /**
     * Gets the value of the codePostal property.
     * 
     */
    public int getCodePostal() {
        return codePostal;
    }

    /**
     * Sets the value of the codePostal property.
     * 
     */
    public void setCodePostal(int value) {
        this.codePostal = value;
    }

    /**
     * Gets the value of the commune property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommune() {
        return commune;
    }

    /**
     * Sets the value of the commune property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommune(String value) {
        this.commune = value;
    }

    /**
     * Gets the value of the conducteur property.
     * 
     */
    public int getConducteur() {
        return conducteur;
    }

    /**
     * Sets the value of the conducteur property.
     * 
     */
    public void setConducteur(int value) {
        this.conducteur = value;
    }

    /**
     * Gets the value of the cv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCv() {
        return cv;
    }

    /**
     * Sets the value of the cv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCv(String value) {
        this.cv = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
    }

    /**
     * Gets the value of the notif property.
     * 
     */
    public int getNotif() {
        return notif;
    }

    /**
     * Sets the value of the notif property.
     * 
     */
    public void setNotif(int value) {
        this.notif = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the prenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Sets the value of the prenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrenom(String value) {
        this.prenom = value;
    }

    /**
     * Gets the value of the tel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTel() {
        return tel;
    }

    /**
     * Sets the value of the tel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTel(String value) {
        this.tel = value;
    }

}
