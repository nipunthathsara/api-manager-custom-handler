package org.wso2;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.synapse.MessageContext;
import org.apache.synapse.rest.AbstractHandler;

public class CustomHanlder extends AbstractHandler {

    public static final Log log = LogFactory.getLog(CustomHanlder.class);
    private String productionEndpointAddress;
    public boolean handleRequest(MessageContext messageContext) {
        log.info("Production Endpoint Address : " + this.productionEndpointAddress);
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) {
        return true;
    }

    public void setProductionEndpointAddress(String productionEndpointAddress) {
        this.productionEndpointAddress = productionEndpointAddress;
    }

    public String getProductionEndpointAddress() {
        return productionEndpointAddress;
    }
}
