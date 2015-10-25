using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text;
using System.Web;
using System.Web.Helpers;
using System.Web.Mvc;
using Newtonsoft.Json;
using B2C.Contracts;
using Apache.NMS;
using Apache.NMS.ActiveMQ;

namespace B2C.Handlers
{
    public class HandlerRequest
    {
        public static string XML = "application/xml";
        public static string JSON = "application/json";

        public static string POST = "POST";
        public static string GET = "GET";


        private static IConnectionFactory factory = null;
        private static IConnection connection;
        private static ISession session;
        private static IDestination destination;

        private static void createConnection()
        {
            if (HandlerRequest.factory == null)
            {
                HandlerRequest.factory  = new ConnectionFactory(HandlerResource.getServiceAgentLocation("proccessOrder"));
                HandlerRequest.connection = HandlerRequest.factory.CreateConnection("admin", "admin");
                HandlerRequest.connection.Start();
                HandlerRequest.session = HandlerRequest.connection.CreateSession();
            }
        }

        private IDestination getDestination(String queue)
        {
            return HandlerRequest.session.GetQueue(queue);
        }

        public void doMessage(String message, String queue)
        {
            HandlerRequest.createConnection();
            using (IMessageProducer producer = HandlerRequest.session.CreateProducer(this.getDestination(queue)))
            {
                var message_sent = producer.CreateTextMessage(message);
                producer.Send(message_sent);
            }
        }

        public String doRequest(String url, String method, String accept = "", String body = "")
        {
            if (accept.Equals(""))
                accept = HandlerRequest.JSON;

            // Create a request for the URL. 
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            request.Accept = accept;
            request.Method = method;
            

            if( accept.Equals(HandlerRequest.XML))
            {
                request.ContentType = HandlerRequest.XML;
               
                string test = "<authenticationResource><email>test@gmail.com</email><password>123456</password></authenticationResource>";
                byte[] bytes = Encoding.UTF8.GetBytes(test.ToString());
                request.ContentLength = bytes.Length;

                using (Stream putStream = request.GetRequestStream())
                {
                    putStream.Write(bytes, 0, bytes.Length);
                }
            }

            // If required by the server, set the credentials.
            //request.Credentials = CredentialCache.DefaultCredentials;
            // Get the response.
            WebResponse response = request.GetResponse();
           
            // Get the stream containing content returned by the server.
            Stream dataStream = response.GetResponseStream();
            // Open the stream using a StreamReader for easy access.
            StreamReader reader = new StreamReader(dataStream);
            // Read the content.
            string responseFromServer = reader.ReadToEnd();
            // Display the content.
            Console.WriteLine(responseFromServer);
            
            // Clean up the streams and the response.
            reader.Close();
            response.Close();

            return responseFromServer;
        }

    }
}