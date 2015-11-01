using System;
using B2C.Entities;
using B2C.Handlers;
using System.Text;
using B2C.Contracts;


namespace B2C.AgentsService
{
    public class CustomerAgentsService
    {
        public bool registerCustomer(string body )
        {
            HandlerRequest request = new HandlerRequest();
            StringBuilder builder = new StringBuilder(HandlerResource.getServiceAgentLocation("register"));

            String response = request.doRequest(builder.ToString(), HandlerRequest.POST, HandlerRequest.XML, body);
            
            return DataContractRegister.getResponse(response);
        }

        public Customer getCustomer(Customer customer)
        {
            Random rnd = new Random();
            customer.UserID = rnd.Next(1, 500);
            return customer;
        }
    }
}