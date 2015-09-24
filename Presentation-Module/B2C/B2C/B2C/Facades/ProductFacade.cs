using B2C.Contracts;
using B2C.Entities;
using B2C.ServiceAgent;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Facades
{
    public class ProductFacade
    {

        private static ProductFacade instance = null;
        private ProductServiceAgent productService;


        private ProductFacade()
        {
            this.productService = new ProductServiceAgent();
        }

        public static ProductFacade Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new ProductFacade();
                }
                return instance;
            }
        }

        public List<Campaign> getCampaigns()
        {
            List<Campaign> campaigns = new List<Campaign>();

            foreach (DataContractCampaigns temp in this.productService.getCampigns())
            {
                campaigns.Add(new Campaign(temp));
            }
            return campaigns;
        }

        public Product getProduct(int id)
        {
            return new Product(this.productService.getProduct(id));
        }

        public List<Product> getProducts(string search, string search_by, int page, int byPage)
        {
            if (search == null)
                search = "";

            if (search_by == null)
                search_by = "";

            List<Product> products = new List<Product>();
            foreach (DataContractProduct item in this.productService.getProducts(search, search_by, page, byPage))
            {
                products.Add(new Product(item));
            }
            return products;
        }

        public int getTotalProducts(string search, string search_by, int page, int byPage)
        {
            return this.productService.getTotalProducts(search, search_by, page, byPage).total;
        }


        public List<Product> getTopFive(int id)
        {
            List<Product> products = new List<Product>();
            foreach (DataContractTopFive item in this.productService.getTopFive(id))
            {
                products.Add(new Product(item));
            }
            return products;
        }

    }
}