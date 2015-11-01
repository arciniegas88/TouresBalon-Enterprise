using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Forms;
using B2C.Entities;
using B2C.AgentsService;
using B2C.Handlers;
using System.Text;
using System.Xml;

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

        public bool registerCustomer(string body)
        {
            this.agentService.registerCustomer(body);
            return true;
        }

    }
}