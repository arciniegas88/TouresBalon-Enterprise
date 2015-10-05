using System;
using System.Collections.Generic;
using System.Web;
using B2C.Entities;
using B2C.Handlers;
using System.Text;
using B2C.Contracts;
using Newtonsoft.Json;

namespace B2C.Agents
{
    public class SecurityService
    {

        public DataContractLogin loginUser(Customer customer)
        {
            HandlerRequest request = new HandlerRequest();
            StringBuilder builder = new StringBuilder(HandlerResource.getServiceAgentLocation("login"));
            builder.Append("userName=");
            builder.Append(customer.Email);
            builder.Append(";password=");
            builder.Append(customer.Password);

            String response =  request.doRequest(builder.ToString(), "GET");

            try
            {
                DataContractLogin contract = JsonConvert.DeserializeObject<DataContractLogin>((response)) as DataContractLogin;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }

        }


    }
}