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

        private OrderFacade()
        {

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
            OrderService service = new OrderService();
            return service.getProduct(id);
        }

        public List<Product> getProducts()
        {
            OrderService service = new OrderService();
            return service.getProducts();
        }

    }
}