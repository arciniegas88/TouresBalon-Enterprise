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
            catch (PlatformException e)
            {
                throw e;
            }
        }

        public IList<Customer> getCustomers(int pagina, int regPagina)
        {
            try
            {
                CustomerDAO customerDAO = new CustomerDAO();
                return customerDAO.getCustomers(pagina, regPagina);
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

        public string createCustomer(Customer customer)
        {
            try
            {
                CustomerDAO customerDAO = new CustomerDAO();
                return customerDAO.createCustomer(customer);
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

        public string deleteCustomer(string id)
        {
            try
            {
                CustomerDAO customerDAO = new CustomerDAO();
                return customerDAO.deleteCustomer(id);
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

        public string updateCustomer(Customer customer)
        {
            try
            {
                CustomerDAO customerDAO = new CustomerDAO();
                return customerDAO.updateCustomer(customer);
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
    }
}