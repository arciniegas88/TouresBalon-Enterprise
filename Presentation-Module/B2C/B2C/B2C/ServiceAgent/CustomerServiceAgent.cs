using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;

namespace B2C.AgentsService
{
    public class CustomerAgentsService
    {
        public Customer registerCustomer(Customer customer )
        {
            Random rnd = new Random();
            customer.UserID = rnd.Next(1, 500);
            return customer;
        }

        public Customer getCustomer(Customer customer)
        {
            Random rnd = new Random();
            customer.UserID = rnd.Next(1, 500);
            return customer;
        }
    }
}