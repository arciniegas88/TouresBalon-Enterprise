using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary
{
    public class AddressBoundary
    {
        public string updateAddress(Address address)
        {
            AddressDAO addressDAO = new AddressDAO();
            return addressDAO.updateAddress(address);
        }

        public string addAddress(string customer_id, Address address)
        {
            AddressDAO addressDAO = new AddressDAO();
            return addressDAO.addAddress(customer_id, address);
        }

        public string deleteAddress(string id, string customer_id)
        {
            AddressDAO addressDAO = new AddressDAO();
            return addressDAO.deleteAddress(id, customer_id);
        }
    }
}