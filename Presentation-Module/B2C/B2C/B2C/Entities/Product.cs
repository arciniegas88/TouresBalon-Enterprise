using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Entities
{
    public class Product
    {
        private int id;
        private string name;
        private string image;
        private string description;

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

    }
}