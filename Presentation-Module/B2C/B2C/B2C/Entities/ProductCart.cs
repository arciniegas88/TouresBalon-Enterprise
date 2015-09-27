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

        public string toXml()
        {
            XElement product =
            new XElement("Product",
                    new XElement("id", this.id),
                    new XElement("name", this.name),
                    new XElement("account", this.account),
                    new XElement("cost", this.cost)
                );
            return product.ToString();
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