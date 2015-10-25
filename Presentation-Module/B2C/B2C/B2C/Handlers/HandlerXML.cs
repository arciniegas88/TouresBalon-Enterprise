using B2C.Entities;
using System;
using System.Collections.Generic;
using System.IO;
using System.Web;
using System.Xml;

namespace B2C.Handlers
{
    public class HandlerXML
    {

        public static Dictionary<String, String> loadXml(String name_parent, String name_children)
        {
            Dictionary<String, String> dictionary = new Dictionary<String, String>();

            XmlDocument xDoc = new XmlDocument();
            String xmlData = HttpContext.Current.Server.MapPath("~/Resources/protected/xml/resources.xml");
            xDoc.Load(xmlData);
            XmlNodeList parent = xDoc.GetElementsByTagName(name_parent);
            XmlNodeList lista = ((XmlElement)parent[0]).GetElementsByTagName(name_children);

            foreach(XmlElement nodo in lista)
            {
                dictionary.Add(nodo.GetAttribute("name"), nodo.GetAttribute("location"));
            }

            return dictionary;
        }

        public static XmlDocument loadXml(String path)
        {
            XmlDocument xDoc = new XmlDocument();
            String xmlData = HttpContext.Current.Server.MapPath(path);
            xDoc.Load(xmlData);
            return xDoc;
        }

        public static string buildMessage(List<ProductCart> objects, string franchise, string number_card)
        {
            XmlDocument order = HandlerResource.getXmlProcessingOrder();
            XmlDocument item;
            XmlNode root = order.DocumentElement;

            order.GetElementsByTagName("comments").Item(0).InnerText = "Testing from B2C";
            order.GetElementsByTagName("custFirstName").Item(0).InnerText = "NOT INTEGRATED";
            order.GetElementsByTagName("custLastName").Item(0).InnerText = "NOT INTEGRATED";
            order.GetElementsByTagName("email").Item(0).InnerText = "NOT INTEGRATED";
            order.GetElementsByTagName("custDocumentNumber").Item(0).InnerText = "NOT INTEGRATED";
            order.GetElementsByTagName("custDocumentType").Item(0).InnerText = "NOT INTEGRATED";
            order.GetElementsByTagName("customerType").Item(0).InnerText = franchise;
            order.GetElementsByTagName("creditCardNumber").Item(0).InnerText = number_card;

            double total = 0;

            foreach (ProductCart obj in objects)
            {
                total += obj.Cost * obj.Account;
                item = obj.toXml();
                order.FirstChild.FirstChild.AppendChild( order.ImportNode(item.FirstChild, true) );
            }

            order.GetElementsByTagName("price").Item(0).InnerText = total.ToString();

            StringWriter sw = new StringWriter();
            XmlTextWriter tx = new XmlTextWriter(sw);
            order.WriteTo(tx);

            string str = sw.ToString();
            return str;
        }
        
    }
}