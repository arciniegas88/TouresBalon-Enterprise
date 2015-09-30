using Security_Services.microsoft.co.com.touresbalon.foundation.security.boundary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;


namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "SecurityResource" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select SecurityResource.svc or SecurityResource.svc.cs at the Solution Explorer and start debugging.
    public class SecurityResource : ISecurityResource
    {

        private SecurityBoundary securityBoundary = new SecurityBoundary();

        public bool authenticationResource(string userName, string password)
        {
            bool isAuthetication=true;
            try
            {
                isAuthetication=securityBoundary.authenticateBoundary(userName, password);
             }
            catch {
                isAuthetication = false;
            }
            return isAuthetication;
        }
              
    }
}
