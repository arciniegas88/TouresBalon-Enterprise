using System.ServiceModel;
using System.ServiceModel.Web;
using Security_Services.microsoft.co.com.touresbalon.foundation.security.dto;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.rest
{
    [ServiceContract(Namespace = "")]
    public interface ISecurityResource
    {
        [OperationContract] 
        [WebInvoke(Method = "POST",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            RequestFormat = WebMessageFormat.Xml,
            UriTemplate = "authenticationResource")]
        User authenticationResource(string email, string password);

        [OperationContract]
        [WebInvoke(Method = "POST",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            RequestFormat = WebMessageFormat.Xml,
            UriTemplate = "createUserLdap")]
        string createUserLdap(User user);

    }
}
