using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;

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
    }
}