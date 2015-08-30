using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;
using B2C.Contracts;

namespace B2C.Facades
{
    public class OrderFacade
    {

        private static OrderFacade instance = null;
        private OrderService orderService;

        private OrderFacade()
        {
            this.orderService = new OrderService();
        }

        public static OrderFacade Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new OrderFacade();
                }
                return instance;
            }
        }

        public List<Campaign> getCampaigns()
        {
            List<Campaign> campaigns = new List<Campaign>();

            foreach (DataContractCampaigns temp in this.orderService.getCampigns())
            {
                campaigns.Add(new Campaign(temp));    
            }
            return campaigns;
        }

        public Product getProduct(int id)
        {
            return this.orderService.getProduct(id);
        }

        public List<Product> getProducts()
        {
            List<Product> products = new List<Product>();
            foreach( DataContractProduct item in this.orderService.getProducts())
            {
                products.Add(new Product(item));
            }
            return products;
        }

        public List<Product> getTopFive(int id)
        {
            return this.orderService.getTopFive(id);
        }

    }
}