using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
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
        
    }
}