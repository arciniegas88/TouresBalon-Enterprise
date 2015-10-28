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

        /** Just for transport **/
        private DateTime travelDate;
        private int travelOutTime;
        private String businessProvider;

        public Type(DataContractType type)
        {
            this.id = type.id;
            this.name = type.name;

            byte[] data = Encoding.Default.GetBytes(type.name);
            this.name = Encoding.UTF8.GetString(data);

            this.cost = type.cost;

            if (type.travelDate != null)
                this.TravelDate = type.travelDate;

            if (type.travelOutTime != null && type.travelOutTime != 0)
                this.TravelOutTime = type.travelOutTime;

            if (type.businessProvider != null)
                this.businessProvider = type.businessProvider;
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

        public DateTime TravelDate
        {
            get
            {
                return travelDate;
            }

            set
            {
                travelDate = value;
            }
        }

        public int TravelOutTime
        {
            get
            {
                return travelOutTime;
            }

            set
            {
                travelOutTime = value;
            }
        }

        public string BusinessProvider
        {
            get
            {
                return businessProvider;
            }

            set
            {
                businessProvider = value;
            }
        }
    }
}