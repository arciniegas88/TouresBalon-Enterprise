﻿using System;
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
            return new Product( this.orderService.getProduct(id));
        }

        public List<Product> getProducts(string search, string search_by, int page, int byPage)
        {
            List<Product> products = new List<Product>();
            foreach( DataContractProduct item in this.orderService.getProducts(search, search_by, page, byPage))
            {
                products.Add(new Product(item));
            }
            return products;
        }

        public int getTotalProducts(string search, string search_by, int page, int byPage)
        {
            return this.orderService.getTotalProducts(search, search_by, page, byPage).total;
        }

        public List<Product> getTopFive(int id)
        {
            List<Product> products = new List<Product>();
            foreach (DataContractTopFive item in this.orderService.getTopFive(id))
            {
                products.Add(new Product(item));
            }
            return products;
        }

        public List<Order> getOrdersCustomer(Customer customer)
        {
            List<Order> orders = new List<Order>();

            foreach( DataContractOrder temp in this.orderService.getOrdersCustomer(customer) )
            {
                orders.Add(new Order(temp));
            }

            return orders;
        }

        public List<ItemOrder> getItemsOrder(int order)
        {
            List<ItemOrder> items = new List<ItemOrder>();

            foreach (DataContractItemOrder temp in this.orderService.getOrder(order)) 
            {
                items.Add(new ItemOrder(temp));
            }

            return items;
        }

    }
}