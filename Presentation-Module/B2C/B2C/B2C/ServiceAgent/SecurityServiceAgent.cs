using System;
using System.Collections.Generic;
using System.Web;
using B2C.Entities;
using B2C.Handlers;
using System.Text;
using B2C.Contracts;
using Newtonsoft.Json;
using System.Xml;

namespace B2C.Agents
{
    public class SecurityService
    {

        public XmlDocument loginUser(String body)
        {
            HandlerRequest request = new HandlerRequest();
            StringBuilder builder = new StringBuilder(HandlerResource.getServiceAgentLocation("login"));

            String response =  request.doRequest(builder.ToString(), HandlerRequest.POST, HandlerRequest.XML, body);


            //This service return XML
            XmlDocument xml = new XmlDocument();
            xml.LoadXml(response); // suppose that myXmlString contains "<Names>...</Names>"

            return xml;
        }


    }
}