using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Contracts;
using System.Text;
using System.IO;
using System.Drawing;
using System.Web.Mvc;
using System.Web.Helpers;
using B2C.Handlers;

namespace B2C.Entities
{
    public class Campaign
    {
        private string name;
        private DateTime effective_date_up;
        private string image_ref;
        private int id;
        private int product_id;

        public Campaign(DataContractCampaigns campaing)
        {
            this.id = campaing.id;
            this.image_ref =  HandlerImage.convertStreamToImage(campaing.imageRef);
            this.name = campaing.name;
            this.product_id = campaing.product.id;
        }

        public Campaign()
        {

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

        public DateTime Effective_date_up
        {
            get
            {
                return effective_date_up;
            }

            set
            {
                effective_date_up = value;
            }
        }

        public string Image_ref
        {
            get
            {
                return image_ref;
            }

            set
            {
                image_ref = value;
            }
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
    }
}