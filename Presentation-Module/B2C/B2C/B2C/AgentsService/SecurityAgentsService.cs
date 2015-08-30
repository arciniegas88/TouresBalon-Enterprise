using System;
using System.Collections.Generic;
using System.Web;
using B2C.Entities;
using B2C.Handlers;

namespace B2C.Agents
{
    public class SecurityService
    {

        public Customer loginUser(Customer customer)
        {
            //HandlerRequest request = new HandlerRequest();
            //customer.Email = "test " + request.doRequest("http://jsonplaceholder.typicode.com/posts/1", "GET");

            Random random = new Random();
            customer.UserID = random.Next(1, 150);
            customer.First_name = "Nombre 1";
            return customer;
        }


    }
}