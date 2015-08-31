using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary;
using System;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "AddressService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select AddressService.svc or AddressService.svc.cs at the Solution Explorer and start debugging.
    public class AddressService : IAddressService
    {
        public string addAddress(string customer_id, Address address)
        {
            AddressBoundary addressBoundary = new AddressBoundary();
            return addressBoundary.addAddress(customer_id, address);
        }

        public string deleteAddress(string id, string customer_id)
        {
            AddressBoundary addressBoundary = new AddressBoundary();
            return addressBoundary.deleteAddress(id, customer_id);
        }

        public string updateAddress(Address address)
        {
            AddressBoundary addressBoundary = new AddressBoundary();
            return addressBoundary.updateAddress(address);
        }
    }
}
