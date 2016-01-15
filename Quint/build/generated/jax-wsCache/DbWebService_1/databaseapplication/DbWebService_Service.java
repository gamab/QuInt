
package databaseapplication;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "DbWebService", targetNamespace = "http://databaseApplication/", wsdlLocation = "http://localhost:8080/Quint/DbWebService?wsdl")
public class DbWebService_Service
    extends Service
{

    private final static URL DBWEBSERVICE_WSDL_LOCATION;
    private final static WebServiceException DBWEBSERVICE_EXCEPTION;
    private final static QName DBWEBSERVICE_QNAME = new QName("http://databaseApplication/", "DbWebService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/Quint/DbWebService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        DBWEBSERVICE_WSDL_LOCATION = url;
        DBWEBSERVICE_EXCEPTION = e;
    }

    public DbWebService_Service() {
        super(__getWsdlLocation(), DBWEBSERVICE_QNAME);
    }

    public DbWebService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), DBWEBSERVICE_QNAME, features);
    }

    public DbWebService_Service(URL wsdlLocation) {
        super(wsdlLocation, DBWEBSERVICE_QNAME);
    }

    public DbWebService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, DBWEBSERVICE_QNAME, features);
    }

    public DbWebService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public DbWebService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns DbWebService
     */
    @WebEndpoint(name = "DbWebServicePort")
    public DbWebService getDbWebServicePort() {
        return super.getPort(new QName("http://databaseApplication/", "DbWebServicePort"), DbWebService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns DbWebService
     */
    @WebEndpoint(name = "DbWebServicePort")
    public DbWebService getDbWebServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://databaseApplication/", "DbWebServicePort"), DbWebService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (DBWEBSERVICE_EXCEPTION!= null) {
            throw DBWEBSERVICE_EXCEPTION;
        }
        return DBWEBSERVICE_WSDL_LOCATION;
    }

}