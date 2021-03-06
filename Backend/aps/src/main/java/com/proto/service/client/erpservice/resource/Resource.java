
package com.proto.service.client.erpservice.resource;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Resource", targetNamespace = "http://Resource.ERPService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Resource {


    /**
     * 
     * @return
     *     returns java.util.List<erpservice.resource.ResourceItem>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getHumanResource", targetNamespace = "http://Resource.ERPService/", className = "erpservice.resource.GetHumanResource")
    @ResponseWrapper(localName = "getHumanResourceResponse", targetNamespace = "http://Resource.ERPService/", className = "erpservice.resource.GetHumanResourceResponse")
    @Action(input = "http://Resource.ERPService/Resource/getHumanResourceRequest", output = "http://Resource.ERPService/Resource/getHumanResourceResponse")
    public List<ResourceItem> getHumanResource();

    /**
     * 
     * @return
     *     returns java.util.List<erpservice.resource.ResourceItem>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getLineResource", targetNamespace = "http://Resource.ERPService/", className = "erpservice.resource.GetLineResource")
    @ResponseWrapper(localName = "getLineResourceResponse", targetNamespace = "http://Resource.ERPService/", className = "erpservice.resource.GetLineResourceResponse")
    @Action(input = "http://Resource.ERPService/Resource/getLineResourceRequest", output = "http://Resource.ERPService/Resource/getLineResourceResponse")
    public List<ResourceItem> getLineResource();

}
