using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;
using System.Xml;

namespace B2C.Facades
{
    public class SecurityFacade
    {

        private static SecurityFacade instance = null;
        private SecurityService securityService;

        private SecurityFacade()
        {
            this.securityService = new SecurityService();
        }

        public static SecurityFacade Instance
        {
            get
            {
                if (instance == null)
                {
                    instance = new SecurityFacade();
                }
                return instance;
            }
        }



        public bool getLoginUser(Customer customer)
        {
            string body = customer.toXMLLogin();
            return this.securityService.loginUser(body).authenticationResourceResult;
        }
    }
}