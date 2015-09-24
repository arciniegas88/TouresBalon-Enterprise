using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary
{
    public class AddressBoundary
    {
        public string updateAddress(Address address)
        {
            try
            {
                AddressDAO addressDAO = new AddressDAO();
                return addressDAO.updateAddress(address);
            }
            catch (BusinessException e)
            {
                throw e;
            }
            catch (PlatformException e)
            {
                throw e;
            }
        }

        public string addAddress(string customer_id, Address address)
        {
            try
            {
                AddressDAO addressDAO = new AddressDAO();
                return addressDAO.addAddress(customer_id, address);
            }
            catch (BusinessException e)
            {
                throw e;
            }
            catch (PlatformException e)
            {
                throw e;
            }
        }

        public string deleteAddress(string id, string customer_id)
        {
            try
            {
                AddressDAO addressDAO = new AddressDAO();
                return addressDAO.deleteAddress(id, customer_id);
            }
            catch (BusinessException e)
            {
                throw e;
            }
            catch (PlatformException e)
            {
                throw e;
            }
        }
    }
}