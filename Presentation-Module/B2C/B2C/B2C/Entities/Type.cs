using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;
using System.Text;

namespace B2C.Entities
{
    public class Type
    {
        private int id;
        private string name;
        private double cost;

        public Type(DataContractType type)
        {
            this.id = type.id;
            this.name = type.name;

            byte[] data = Encoding.Default.GetBytes(type.name);
            this.name = Encoding.UTF8.GetString(data);

            this.cost = type.cost;
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