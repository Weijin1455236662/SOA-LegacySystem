
package com.proto.service.client.erpservice.goods;

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
@WebService(name = "Goods", targetNamespace = "http://Goods.ERPService/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Goods {


    /**
     * 
     * @return
     *     returns java.util.List<erpservice.goods.GoodsItem>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllGoods", targetNamespace = "http://Goods.ERPService/", className = "erpservice.goods.GetAllGoods")
    @ResponseWrapper(localName = "getAllGoodsResponse", targetNamespace = "http://Goods.ERPService/", className = "erpservice.goods.GetAllGoodsResponse")
    @Action(input = "http://Goods.ERPService/Goods/getAllGoodsRequest", output = "http://Goods.ERPService/Goods/getAllGoodsResponse")
    public List<GoodsItem> getAllGoods();

}
