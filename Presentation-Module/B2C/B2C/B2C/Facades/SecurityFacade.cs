using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Agents;
using System.Xml;
using System.Xml.Serialization;

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
            XmlDocument xml = this.securityService.loginUser(body);

            if (xml != null && xml.GetElementsByTagName("email").Item(0) != null)
            {
                Handlers.HandlerSession.setUser(xml);
                return true;
            }else
            {
                return false;
            }
        }
    }
}