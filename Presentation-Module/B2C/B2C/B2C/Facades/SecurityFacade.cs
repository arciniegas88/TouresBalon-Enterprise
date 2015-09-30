using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;

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
            return this.securityService.loginUser(customer).authenticationResourceResult;
        }
    }
}