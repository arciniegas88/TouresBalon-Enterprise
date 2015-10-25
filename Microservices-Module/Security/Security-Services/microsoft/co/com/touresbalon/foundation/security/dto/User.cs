using System.Runtime.Serialization;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.dto
{
    [DataContract(Namespace="")]
    public class User
    {
        [DataMember]
        public string email { set; get; }
        [DataMember]
        public string userId { set; get; }
        [DataMember]
        public string userName { set; get; }
        [DataMember]
        public string lastName { set; get; }
        [DataMember]
        public string userGroup { set; get; }
        [DataMember]
        public string password { set; get; }
    }
}