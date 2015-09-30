using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.dao;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using System;
using System.Collections.Generic;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary
{
    public class CustomerBoundary
    {
        private CustomerDAO customerDAO;

        public Customer getCustomer(string id)
        {
            try
            {
                customerDAO = new CustomerDAO();
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
            }
        }

        public IList<Customer> getCustomers(int pagina, int regPagina)
        {
            try
            {
                customerDAO = new CustomerDAO();
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
            }
        }

        public string createCustomer(Customer customer)
        {
            try
            {
                customerDAO = new CustomerDAO();
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
            }

        }

        public string deleteCustomer(string id)
        {
            try
            {
                customerDAO = new CustomerDAO();
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
            }

        }

        public string updateCustomer(Customer customer)
        {
            try
            {
                customerDAO = new CustomerDAO();
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
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
            catch (Exception e)
            {
                throw new PlatformException(e.Message);
            }
        }
    }
}