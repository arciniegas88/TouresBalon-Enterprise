using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Handlers;
using Newtonsoft.Json;
using B2C.Contracts;
using System.Text;
using B2C.Utils;

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
            builder.Append("typeDocument=");
            builder.Append(customer.Document_type);
            builder.Append("&");
            builder.Append("numberDocument=");
            builder.Append(customer.UserID);

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

        public string proccessOrder(List<ProductCart> products)
        {
            String xml = HandlerXML.buildMessage(products);

            HandlerRequest request = new HandlerRequest();
            string order_id = request.doMessage(xml, HandlerResource.getServiceAgentLocation("queueProcessingOrder"), HandlerResource.getServiceAgentLocation("queueProcessingOrderResponse"));
            return order_id;
        }

        public void cancelOrder(String cancel)
        {
            HandlerRequest request = new HandlerRequest();
            request.doMessage(cancel, HandlerResource.getServiceAgentLocation("queueCancelingOrder"), "");
        }
    }
}