using B2C.Facades;
using B2C.Handlers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;
using System.Xml;
using System.Xml.Linq;
using System.Xml.Serialization;

namespace B2C.Entities
{
    [XmlRoot("product")]
    public class ProductCart
    {
        [XmlElement("id")]
        private int id;

        [XmlElement("name")]
        private string name;

        [XmlElement("accout")]
        private int account = 0;

        [XmlElement("cost")]
        private double cost;


        private int state = 0;
        private int pos = 0;

        public XmlDocument toXml()
        {
            Product product = ProductFacade.Instance.getProduct(this.id);
            XmlDocument item = HandlerResource.getXmlItem();
            
            
            item.GetElementsByTagName("productId").Item(0).InnerText = this.Id.ToString();
            item.GetElementsByTagName("productName").Item(0).InnerText = this.Name;
            item.GetElementsByTagName("price").Item(0).InnerText = this.Cost.ToString();

            /** Transport's Attributes **/
            item.GetElementsByTagName("travelBusinessProvider").Item(0).InnerText = product.Transport.Name;
            item.GetElementsByTagName("sourceCity").Item(0).InnerText = "NOT FOUND"; 
            item.GetElementsByTagName("targetCity").Item(0).InnerText = "NOT FOUND";
            item.GetElementsByTagName("travelDate").Item(0).InnerText = "NOT FOUND";
            item.GetElementsByTagName("travelOutTime").Item(0).InnerText = "NOT FOUND";


            /** Spectacle's Attributes **/
            XmlNode node_spectacle = item.GetElementsByTagName("spectacle").Item(0);
            foreach (XmlNode temp in node_spectacle.ChildNodes)
            {
                    if (temp.Name.Equals("id"))
                         node_spectacle.InnerText = product.Spectacle.Id.ToString();
            }

            /** Lodging's Attributes **/
            item.GetElementsByTagName("lodgingBusinessProvider").Item(0).InnerText = product.Lodging.Name;
            item.GetElementsByTagName("targetCity").Item(1).InnerText = "NOT FOUND";
            item.GetElementsByTagName("dateCheckIn").Item(0).InnerText = "NOT FOUND";
            item.GetElementsByTagName("dateCheckOut").Item(0).InnerText = "NOT FOUND";
            


            return item;
        }

        public Boolean isDelete()
        {
            if( this.state == 1)
            {
                return true;
            }
            return false;
        }

        public void delete()
        {
            this.state = 1;
        }

        public ProductCart(int id, string name, int pos, int account, double cost)
        {
            this.id = id;
            this.name = name;
            this.pos = pos;
            this.account = account;
            this.cost = cost;
        }

        public int Id
        {
            get
            {
                return id;
            }

            set
            {
                id = value;
            }
        }

        public string Name
        {
            get
            {
                return name;
            }

            set
            {
                name = value;
            }
        }

        public int Pos
        {
            get
            {
                return pos;
            }

            set
            {
                pos = value;
            }
        }

        public int Account
        {
            get
            {
                return account;
            }

            set
            {
                account = value;
            }
        }

        public double Cost
        {
            get
            {
                return cost;
            }

            set
            {
                cost = value;
            }
        }
    }
}