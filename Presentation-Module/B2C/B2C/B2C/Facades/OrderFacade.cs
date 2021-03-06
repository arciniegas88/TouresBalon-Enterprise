﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;
using B2C.Contracts;
using B2C.Utils;
using B2C.Handlers;

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

        public string proccessOrder()
        {
            string order_id = this.orderService.proccessOrder(HandlerSession.getProducts());
            return order_id;
        }

        public void cancelOrder(int id)
        {
            this.orderService.cancelOrder( HandlerXML.xmlToString(Order.toCancel(id)) );
        }

    }
}