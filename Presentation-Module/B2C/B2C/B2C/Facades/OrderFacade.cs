using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;

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

        public Product getProduct(int id)
        {
            return this.orderService.getProduct(id);
        }

        public List<Product> getProducts()
        {
            return this.orderService.getProducts();
        }

        public List<Product> getTopFive(int id)
        {
            return this.orderService.getTopFive(id);
        }

    }
}