using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using System;
using System.Collections.Generic;
using System.ServiceModel.Web;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity;
using System.Net;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CustomerService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select CustomerService.svc or CustomerService.svc.cs at the Solution Explorer and start debugging.
    public class CustomerService : ICustomerService
    {
        public string createCustomer(Customer customer)
        {
            try
            {
                CustomerBoundary customerBoundary = new CustomerBoundary();

                return customerBoundary.createCustomer(customer);
            }catch(BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse { message = e.Message, status = GeneralResponse.STATUS_ERROR,
                        code = "400"}, HttpStatusCode.BadRequest);
            }
        }

        public string deleteCustomer(string id)
        {
            CustomerBoundary customerBoundary = new CustomerBoundary();

            return customerBoundary.deleteCustomer(id);
        }

        public Customer getCustomer(string id)
        {
            try
            {
                CustomerBoundary customerBoundary = new CustomerBoundary();
                return customerBoundary.getCustomer(id);

            }
            catch (BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = HttpStatusCode.BadRequest.ToString()
                    }, HttpStatusCode.BadRequest);
            }
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
