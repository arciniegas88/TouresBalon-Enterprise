using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Forms;
using B2C.Entities;
using B2C.AgentsService;

namespace B2C.Facades
{
    public class CustomerFacade
    {
        private static CustomerFacade instance = null;
        private CustomerAgentsService agentService;

        private CustomerFacade()
        {
            this.agentService = new CustomerAgentsService();
        }

        public static CustomerFacade Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new CustomerFacade();
                }
                return instance;
            }
        }

        public Customer registerCustomer(Customer customer)
        {
            customer = this.agentService.registerCustomer(customer);
            return customer;
        }

    }
}