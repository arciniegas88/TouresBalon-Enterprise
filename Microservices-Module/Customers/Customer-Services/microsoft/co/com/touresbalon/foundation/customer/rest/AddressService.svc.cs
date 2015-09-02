using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary;
using System.ServiceModel;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using System.ServiceModel.Web;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity;
using System.Net;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "AddressService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select AddressService.svc or AddressService.svc.cs at the Solution Explorer and start debugging.

    [ServiceBehavior(ConcurrencyMode = ConcurrencyMode.Multiple)]
    public class AddressService : IAddressService
    {
        public string addAddress(string customer_id, Address address)
        {
            try
            { 
                AddressBoundary addressBoundary = new AddressBoundary();
                return addressBoundary.addAddress(customer_id, address);
            }
            catch(BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse { message = e.Message, status = GeneralResponse.STATUS_ERROR,
                        code = "400" }, HttpStatusCode.BadRequest);
            }
            catch (PlatformException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "500"
                    }, HttpStatusCode.BadRequest);
            }
        }

        public string deleteAddress(string id, string customer_id)
        {
            try
            { 
                AddressBoundary addressBoundary = new AddressBoundary();
                return addressBoundary.deleteAddress(id, customer_id);
            }
            catch(BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse { message = e.Message, status = GeneralResponse.STATUS_ERROR,
                        code = "400" }, HttpStatusCode.BadRequest);
            }
            catch (PlatformException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "500"
                    }, HttpStatusCode.BadRequest);
            }
        }

        public string updateAddress(Address address)
        {
            try
            { 
                AddressBoundary addressBoundary = new AddressBoundary();
                return addressBoundary.updateAddress(address);
            }
            catch(BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse { message = e.Message, status = GeneralResponse.STATUS_ERROR,
                        code = "400" }, HttpStatusCode.BadRequest);
            }
            catch(PlatformException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "500"
                    }, HttpStatusCode.BadRequest);
            }
        }
    }
}
