# api-manager-custom-handler
Handler to retrieve the endpoint url of the API

Endpoint URL of an API can not be consumed by a custom insequence as custom in sequences are invoked prior to the InSequence in which the endpoint url is defined.
In order to overcome this this handler can be used to replace the custom insequence's logic.

endpoint URL property is being set to the custom handler by the velocity template, so that it will be available to use inside the handler.

## Steps
1. Build project using ```mvn clean install```
2. Paste the built artifact to below directory ```<APIM_HOME>/repository/components/dropins/```
3. Add the below changes to the velocity_template.xml ```<APIM_HOME>/repository/resources/api_templates/velocity_template.xml```
```
<handler class="org.wso2.CustomHanlder">
        #set( $pro_endpoints = $endpoint_config.get("production_endpoints"))
        <property name="productionEndpointAddress" value="$util.escapeXml($pro_endpoints.get("url"))"/>
</handler>
```
4. Redeploy the API for changes to get effect.

If you want the handler to be executed only for the chosen APIs, velocity_template.xml should be as follows.
```
#if ($apiName == 'admin--test')
<handler class="org.wso2.CustomHanlder">
        #set( $pro_endpoints = $endpoint_config.get("production_endpoints"))
        <property name="productionEndpointAddress" value="$util.escapeXml($pro_endpoints.get("url"))"/>
</handler>
#end
```
