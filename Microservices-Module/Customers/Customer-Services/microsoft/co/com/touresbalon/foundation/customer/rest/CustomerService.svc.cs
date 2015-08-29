using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary;
using System;
using System.Collections.Generic;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CustomerService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select CustomerService.svc or CustomerService.svc.cs at the Solution Explorer and start debugging.
    public class CustomerService : ICustomerService
    {
        public string createCustomer(Customer customer)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();

            return customerBoundary.createCustomer(customer);
        }

        public string deleteCustomer(string id)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();

            return customerBoundary.deleteCustomer(id);
        }

        public Customer getCustomer(string id)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();
            
            return customerBoundary.getCustomer(id);
        }

        public IList<Customer> getCustomers(string pagina, string regPagina)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();

            return customerBoundary.getCustomers(Int32.Parse(pagina), Int32.Parse(regPagina));
        }

        public string updateCustomer(Customer customer)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();

            return customerBoundary.updateCustomer(customer);
        }
    }
}
