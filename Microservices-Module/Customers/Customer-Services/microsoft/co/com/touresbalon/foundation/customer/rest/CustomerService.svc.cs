using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity;
using Customer_Services.microsoft.co.com.touresbalon.foundation.customer.boundary;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using System;
using System.Collections.Generic;
using System.ServiceModel.Web;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity;
using System.Net;
using System.ServiceModel;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "CustomerService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select CustomerService.svc or CustomerService.svc.cs at the Solution Explorer and start debugging.
    [ServiceBehavior(ConcurrencyMode=ConcurrencyMode.Multiple)]
    public class CustomerService : ICustomerService
    {
        private CustomerBoundary customerBoundary;

        public string createCustomer(Customer customer)
        {
            try
            {
               customerBoundary = new CustomerBoundary();

                return customerBoundary.createCustomer(customer);
            }catch(BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse { message = e.Message, status = GeneralResponse.STATUS_ERROR,
                        code = "400"}, HttpStatusCode.BadRequest);
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

        public string deleteCustomer(string id)
        {
            try
            {
                customerBoundary = new CustomerBoundary();

                return customerBoundary.deleteCustomer(id);
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

        public Customer getCustomer(string id)
        {
            try
            {
                customerBoundary = new CustomerBoundary();
                return customerBoundary.getCustomer(id);
            }
            catch (BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "400"
                    }, HttpStatusCode.BadRequest);
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

        public Customer getCustomerByEmail(string email)
        {
            try
            {
                customerBoundary = new CustomerBoundary();
                return customerBoundary.getCustomerByEmail(email);
            }
            catch (BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "400"
                    }, HttpStatusCode.BadRequest);
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
            
            throw new NotImplementedException();
        }

        public IList<Customer> getCustomers(string pagina, string regPagina)
        {
            try
            { 
                customerBoundary = new CustomerBoundary();

                return customerBoundary.getCustomers(Int32.Parse(pagina), Int32.Parse(regPagina));
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

        public string updateCustomer(Customer customer)
        {
            try
            { 
                customerBoundary = new CustomerBoundary();

                return customerBoundary.updateCustomer(customer);
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
    }
}
