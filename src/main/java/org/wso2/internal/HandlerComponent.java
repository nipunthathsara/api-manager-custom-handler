package org.wso2.internal;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;

/**
 * @scr.component name="org.wso2.carbon.apimgt.migration.client" immediate="true"
 */
public class HandlerComponent {

    public static final Log log = LogFactory.getLog(HandlerComponent.class);
    protected void activate(ComponentContext context){
        log.debug("custom handler successfully activated");
    }
}