using Newtonsoft.Json;
using System.Runtime.Serialization;
using System.Web.Mvc;
using System.Xml;

namespace B2C.Contracts
{ 
    public class DataContractLogin
    {
        [JsonProperty("authenticationResourceResult")]
        public bool authenticationResourceResult { get; set;}
    }

    public class DataContractRegister
    {

        public static bool getResponse(string response)
        {
            XmlDocument xml = new XmlDocument();
            xml.LoadXml(response);

            if (xml.GetElementsByTagName("createUserLdapResult").Item(0).InnerText.Equals("OK"))
                return true;

            return false;
        }

    }

}