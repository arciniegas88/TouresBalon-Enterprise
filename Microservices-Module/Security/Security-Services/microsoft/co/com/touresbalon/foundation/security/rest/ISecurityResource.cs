using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using System.ServiceModel.Web;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ISecurityResource" in both code and config file together.
    [ServiceContract]
    public interface ISecurityResource
    {
        /*
        [OperationContract]
        [WebInvoke(Method = "POST",
           ResponseFormat = WebMessageFormat.Json,
           BodyStyle = WebMessageBodyStyle.Wrapped,
           UriTemplate = "authenticationResource")]
        bool authenticationResource(string userName, string password);
        */

        [OperationContract]
        [WebInvoke(Method = "GET",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "authenticationResource/userName={userName};password={password}")]
        bool authenticationResource(string userName, string password);

    }
}
