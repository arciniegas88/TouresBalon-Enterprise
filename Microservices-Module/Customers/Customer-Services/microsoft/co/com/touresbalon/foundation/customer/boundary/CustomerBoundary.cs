using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System.Collections.Generic;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary
{
    public class CustomerBoundary
    {
        public Customer getCustomer(string id)
        {
            try
            {
                CustomerDAO customerDAO = new CustomerDAO();
                Customer customer = customerDAO.getCustomer(id);

                AddressDAO addressDAO = new AddressDAO();
                customer.address = addressDAO.getCustomerAddress(id);

                return customer;
            }
            catch (BusinessException e)
            {
                throw e;
            }
        }

        public IList<Customer> getCustomers(int pagina, int regPagina)
        {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.getCustomers(pagina, regPagina);
        }

        public string createCustomer(Customer customer)
        {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.createCustomer(customer);
        }

        public string deleteCustomer(string id)
        {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.deleteCustomer(id);
        }

        public string updateCustomer(Customer customer)
        {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.updateCustomer(customer);
        }

        public string updateAddress(Address address)
        {
            AddressDAO addressDAO = new AddressDAO();
            return addressDAO.updateAddress(address);
        }
    }
}