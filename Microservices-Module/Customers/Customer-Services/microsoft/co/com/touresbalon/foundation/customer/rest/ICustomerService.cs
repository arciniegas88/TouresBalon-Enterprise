using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System.Collections.Generic;
using System.ServiceModel;
using System.ServiceModel.Web;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "ICustomerService" in both code and config file together.
    [ServiceContract(Namespace = "")]
    public interface ICustomerService
    {
        [OperationContract]
        [WebInvoke(Method = "GET",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "/customer/id={id}")]
        [FaultContract(typeof(GeneralResponse))]
        Customer getCustomer(string id);

        [OperationContract]
        [WebInvoke(Method = "GET",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "/customerByEmail/email={email}")]
        [FaultContract(typeof(GeneralResponse))]
        Customer getCustomerByEmail(string email);

        [OperationContract]
        [WebInvoke(Method = "GET",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "customers/pag={pagina};regPag={regPagina}")]
        IList<Customer> getCustomers(string pagina, string regPagina);

        [OperationContract]
        [WebInvoke(Method = "POST",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            RequestFormat = WebMessageFormat.Xml,
            UriTemplate = "createCustomer")]
        string createCustomer(Customer customer);

        [OperationContract]
        [WebInvoke(Method = "DELETE",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "deleteCustomer/id={id}")]
        string deleteCustomer(string id);

        [OperationContract]
        [WebInvoke(Method = "PUT",
            ResponseFormat = WebMessageFormat.Xml,
            BodyStyle = WebMessageBodyStyle.Wrapped,
            UriTemplate = "updateCustomer")]
        string updateCustomer(Customer customer);
    }
}
