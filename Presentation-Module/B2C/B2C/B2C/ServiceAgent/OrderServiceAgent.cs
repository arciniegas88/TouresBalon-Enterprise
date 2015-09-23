using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Handlers;
using Newtonsoft.Json;
using B2C.Contracts;
using System.Text;

namespace B2C.Agents
{
    public class OrderService
    {
        public List<DataContractItemOrder> getOrder(int order)
        {
            StringBuilder builder = new StringBuilder(HandlerResource.getServiceAgentLocation("getOrder"));
            builder.Append(order);

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(builder.ToString(), "GET");

            try
            {
                List<DataContractItemOrder> contract = JsonConvert.DeserializeObject<List<DataContractItemOrder>>((response)) as List<DataContractItemOrder>;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
            }
        }

        public List<DataContractOrder> getOrdersCustomer(Customer customer)
        {
            StringBuilder builder = new StringBuilder(HandlerResource.getServiceAgentLocation("getOrdersCustomer"));
            builder.Append("typeDocument=CC&");
            builder.Append("numberDocument=777777");

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(builder.ToString(), "GET");

            try
            {
                List<DataContractOrder> contract = JsonConvert.DeserializeObject<List<DataContractOrder>>((response)) as List<DataContractOrder>;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }
        }

        public void proccessOrder()
        {
            HandlerRequest request = new HandlerRequest();
            request.doMessage("<order>SALES ORDER REQUEST</order>");
        }
    }
}