using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;

namespace B2C.Entities
{
    public class ItemOrder
    {

        private int id;
        private int productId;
        private string productName;
        private int partnum;
        private double price;
        private int quantity;

        public ItemOrder(DataContractItemOrder contract)
        {
            this.id = contract.id;
            this.productId = contract.productId;
            this.productName = contract.productName;
            this.partnum = contract.partnum;
            this.price = contract.price;
            this.quantity = contract.quantity;
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

        public int ProductId
        {
            get
            {
                return productId;
            }

            set
            {
                productId = value;
            }
        }

        public string ProductName
        {
            get
            {
                return productName;
            }

            set
            {
                productName = value;
            }
        }

        public int Partnum
        {
            get
            {
                return partnum;
            }

            set
            {
                partnum = value;
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

        public int Quantity
        {
            get
            {
                return quantity;
            }

            set
            {
                quantity = value;
            }
        }
    }
}