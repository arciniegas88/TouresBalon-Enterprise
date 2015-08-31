using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System.ServiceModel;
using System.ServiceModel.Web;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IAddressService" in both code and config file together.
    [ServiceContract]
    public interface IAddressService
    {
        [OperationContract]
        [WebInvoke(Method = "PUT",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "updateAddress")]
        string updateAddress(Address address);

        [OperationContract]
        [WebInvoke(Method = "POST",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "addAddress/customer_id={customer_id}")]
        string addAddress(string customer_id, Address address);

        [OperationContract]
        [WebInvoke(Method = "DELETE",
            ResponseFormat = WebMessageFormat.Json,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "deleteAddress/id={id};customer_id={customer_id}")]
        string deleteAddress(string id, string customer_id);
    }
}
