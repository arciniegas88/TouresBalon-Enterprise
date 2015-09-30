using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.dto
{
    [DataContract]
    public class User
    {
        [DataMember]
        public string userName { set; get; }
        [DataMember]
        public string password { set; get; }
    }
}