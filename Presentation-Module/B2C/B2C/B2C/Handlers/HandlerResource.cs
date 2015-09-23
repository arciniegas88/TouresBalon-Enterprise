using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Handlers
{
    public class HandlerResource
    {
        
        private static Dictionary<String, String> serviceAgentLocation;
        
        public static void iniServiceAgentLocation()
        {
            HandlerResource.serviceAgentLocation = HandlerXML.loadXml("serviceAgents", "serviceAgent");
        }

        public static string getServiceAgentLocation(String nameService)
        {
            String value = "";

            if (HandlerResource.serviceAgentLocation.TryGetValue(nameService, out value))
            {
                return value;
            }
            else
            {
                return "";
            }

        }

    }
}