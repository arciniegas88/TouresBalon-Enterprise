using Newtonsoft.Json;
using System.Runtime.Serialization;
using System.Web.Mvc;

namespace B2C.Contracts
{ 
    public class DataContractLogin
    {
        [JsonProperty("authenticationResourceResult")]
        public bool authenticationResourceResult { get; set;}
    }
}