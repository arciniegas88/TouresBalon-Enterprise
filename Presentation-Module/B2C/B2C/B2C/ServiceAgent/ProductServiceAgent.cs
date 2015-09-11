using B2C.Contracts;
using B2C.Handlers;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Web;

namespace B2C.ServiceAgent
{
    public class ProductServiceAgent
    {


        public DataContractProduct getProduct(int id)
        {
            //SERVICE URI
            String url = "http://localhost:9494/esb/services/web-api/products/" + id;

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(url, "GET");

            try
            {
                DataContractProduct contract = JsonConvert.DeserializeObject<DataContractProduct>((response)) as DataContractProduct;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }
        }

        public List<DataContractProduct> getProducts(string search, string search_by, int page, int byPage)
        {
            //SERVICE URI
            StringBuilder builder = new StringBuilder();
            builder.Append("http://localhost:9494/esb/services/web-api/products?");

            builder.Append("pageIndex=");
            builder.Append((page - 1) * byPage);
            builder.Append("&pageSize=");
            builder.Append(byPage);

            if (!search_by.Equals(""))
            {
                builder.Append("&");
                builder.Append(search_by);
                builder.Append("=");
                builder.Append(search);
            }

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(builder.ToString(), "GET");

            try
            {
                List<DataContractProduct> contract = JsonConvert.DeserializeObject<List<DataContractProduct>>((response)) as List<DataContractProduct>;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }
        }

        public DataContractCount getTotalProducts(string search, string search_by, int page, int byPage)
        {
            String url = "http://localhost:9494/esb/services/web-api/products/count?";

            StringBuilder builder = new StringBuilder();
            builder.Append(url);

            builder.Append("pageIndex=");
            builder.Append((page - 1) * byPage);
            builder.Append("&pageSize=");
            builder.Append(byPage);

            if (!search_by.Equals(""))
            {
                builder.Append("&");
                builder.Append(search_by);
                builder.Append("=");
                builder.Append(search);
            }

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(builder.ToString(), "GET");

            try
            {
                DataContractCount contract = JsonConvert.DeserializeObject<DataContractCount>((response)) as DataContractCount;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
            }
        }

        public List<DataContractCampaigns> getCampigns()
        {
            //SERVICE URI
            String url = "http://localhost:9494/esb/services/web-api/campaigns";

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(url, "GET");

            try
            {
                List<DataContractCampaigns> contract = JsonConvert.DeserializeObject<List<DataContractCampaigns>>((response)) as List<DataContractCampaigns>;
                return contract;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }
        }

        public List<DataContractTopFive> getTopFive(int product)
        {
            string url = "http://localhost:9495/esb/services/web-api/orders/topItems/" + product;
            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(url, "GET");

            try
            {
                List<DataContractTopFive> contract = JsonConvert.DeserializeObject<List<DataContractTopFive>>((response)) as List<DataContractTopFive>;
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