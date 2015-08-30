using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using B2C.Handlers;
using Newtonsoft.Json;
using B2C.Contracts;

namespace B2C.Agents
{
    public class OrderService
    {

        public Product getProduct(int id)
        {
            //SERVICE URI
            String url = "http://localhost:9494/esb/services/web-api/products/" + id;

            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(url, "GET");

            try
            {
                DataContractProduct contract = JsonConvert.DeserializeObject<DataContractProduct>((response)) as DataContractProduct;
                Product pr = new Product(contract);
                return pr;
            }
            catch (JsonSerializationException exception)
            {
                throw (exception);
                // return new Campaign();
            }
        }

        public List<DataContractProduct> getProducts()
        {
            //SERVICE URI
            String url = "http://localhost:9494/esb/services/web-api/products/";
            /*
            PARA CONTEO
@QueryParam("code") String code,
@QueryParam("name") String name,
@QueryParam("description") String description,
@QueryParam("pageSize") int pageSize
pageIndex solo para productos. 
*/


            HandlerRequest request = new HandlerRequest();
            String response = request.doRequest(url, "GET");

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

        public List<Product> getTopFive(int product)
        {
            List<Product> products = new List<Product>();

            int i = 0;
            Product p;

            for (i = 0; i < 5; i++)
            {
                p = new Product(i, "Producto " + i, "http://ecx.images-amazon.com/images/I/81Tsd0nZ39L._SL1500_.jpg", "Descripcion del producto " + i);
                products.Add(p);
            }

            return products;
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
    }
}