using Newtonsoft.Json;
using System.Runtime.Serialization;
using System.Web.Mvc;

namespace B2C.Contracts
{ 
    public class DataContractLogin
    {
        [JsonProperty("userId")]
        public int userId{ get; set;}

        [JsonProperty("id")]
        public int id { get; set; }

        [JsonProperty("title")]
        public string title{ get; set; }

        public DataContractLogin(int _userId, int _id, string _title)
        {
            this.userId = _userId;
            this.id = _id;
            this.title = _title;
        }
    }
}