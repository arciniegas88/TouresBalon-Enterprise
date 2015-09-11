using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Entities
{
    public class ProductCart
    {
        private int id;
        private string name;
        private int pos;
        private int state = 0;

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

        public ProductCart(int id, string name, int pos)
        {
            this.id = id;
            this.name = name;
            this.pos = pos;
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
    }
}