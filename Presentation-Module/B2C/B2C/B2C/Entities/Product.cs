using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;
using B2C.Handlers;
using System.Text;

namespace B2C.Entities
{
    public class Product
    {
        private int id;
        private string name;
        private string image;
        private string description;
        private string code;
        private DateTime spectacleDate;
        private DateTime arrivalDate;
        private DateTime departureDate;
        private Type transport;
        private Type spectacle;
        private Type lodging;

        public Product(DataContractProduct contract)
        {
            this.id = contract.id;

            byte[] data;

            if (contract.name != null)
            { 
                data = Encoding.Default.GetBytes(contract.name);
                this.name = Encoding.UTF8.GetString(data);
            }

            if(contract.description != null )
            { 
                data = Encoding.Default.GetBytes(contract.description);
                this.description = Encoding.UTF8.GetString(data);
            }
            if ( contract.imageRef != null)
                this.image = HandlerImage.convertStreamToImage(contract.imageRef);

            this.code = contract.code;
            this.spectacleDate = contract.spectacleDate;
            this.departureDate = contract.departureDate;

            if( contract.transportType != null)
                this.Transport = new Type(contract.transportType);

            if (contract.lodgingType != null)
                this.Lodging = new Type(contract.lodgingType);

            if ( contract.spectacleType != null)
                this.Spectacle = new Type(contract.spectacleType);

        }

        public Product (DataContractTopFive contract)
        {
            this.id = contract.idProduct;
            this.name = contract.nameProduct;
        }

        public Product(int _id, string _name, string _image, string _description)
        {
            this.id = _id;
            this.name = _name;
            this.image = _image;
            this.description = _description;
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

        public string Image
        {
            get
            {
                return image;
            }

            set
            {
                image = value;
            }
        }

        public string Description
        {
            get
            {
                return description;
            }

            set
            {
                description = value;
            }
        }

        public string Code
        {
            get
            {
                return code;
            }

            set
            {
                code = value;
            }
        }

        public DateTime SpectacleDate
        {
            get
            {
                return spectacleDate;
            }

            set
            {
                spectacleDate = value;
            }
        }

        public DateTime ArrivalDate
        {
            get
            {
                return arrivalDate;
            }

            set
            {
                arrivalDate = value;
            }
        }

        public DateTime DepartureDate
        {
            get
            {
                return departureDate;
            }

            set
            {
                departureDate = value;
            }
        }

        public Type Transport
        {
            get
            {
                return transport;
            }

            set
            {
                transport = value;
            }
        }

        public Type Spectacle
        {
            get
            {
                return spectacle;
            }

            set
            {
                spectacle = value;
            }
        }

        public Type Lodging
        {
            get
            {
                return lodging;
            }

            set
            {
                lodging = value;
            }
        }
    }
}