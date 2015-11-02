using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;
using System.Xml;

namespace B2C.Entities
{
    public class Order
    {

        private int id;
        private double price;
        private string status;
        private string comments;

        public Order(DataContractOrder contract)
        {
            this.id = contract.id;
            this.price = contract.price;
            this.status = contract.status;
            this.comments = contract.comments;
        }


        public static XmlDocument toCancel(int Id)
        {
            XmlDocument xml = Handlers.HandlerResource.getXmlCancel();
            xml.GetElementsByTagName("ns:orderId").Item(0).InnerText = Id.ToString();

            return xml;
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

        public double Price
        {
            get
            {
                return price;
            }

            set
            {
                price = value;
            }
        }

        public string Status
        {
            get
            {
                return status;
            }

            set
            {
                status = value;
            }
        }

        public string Comments
        {
            get
            {
                return comments;
            }

            set
            {
                comments = value;
            }
        }

        public string statusShow()
        {
            if (this.status.Equals("IN_VALIDATION"))
                return "En validacion";
            if (this.status.Equals("PENDING"))
                return "Pendiente";
            if (this.status.Equals("CLOSED"))
                return "Cerrada";
            if (this.status.Equals("COMPLETED"))
                return "Completad";
            return "";
        }
    }
}