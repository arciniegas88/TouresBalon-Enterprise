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

namespace B2C.Handlers
{
    public class HandlerRequest
    {

        public String doRequest(String url, String method)
        {
            // Create a request for the URL. 
            WebRequest request = WebRequest.Create(url);

            request.ContentType = "application/json; charset=utf-8";

            // If required by the server, set the credentials.
            request.Credentials = CredentialCache.DefaultCredentials;
            // Get the response.
            WebResponse response = request.GetResponse();
            // Display the status.
            Console.WriteLine(((HttpWebResponse)response).StatusDescription);
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