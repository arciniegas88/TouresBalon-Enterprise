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

        private SecurityFacade()
        {

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



        public User getLoginUser(string username, string password)
        {
            SecurityService service = new SecurityService();
            return service.loginUser(username, password);
        }
    }
}