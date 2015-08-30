using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;

namespace B2C.Entities
{
    public class Type
    {
        private int id;
        private string name;
        private double cost;

        public Type(DataContractType type)
        {
            /*if( type.id != null)
                this.id = type.id;

            if( type.name != null)
                this.name = type.name;

            if( type.cost != null)
                this.cost = type.cost;*/
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