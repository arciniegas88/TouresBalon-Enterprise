using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.entity
{

    [DataContract]
    public class Customer
    {
        
        [DataMember]
        public virtual string Id { get; set; }
        [DataMember]
        public virtual string first_name { get; set; }
        [DataMember]
        public virtual string last_name { get; set; }
        [DataMember]
        public virtual string phone_number { get; set; }
        [DataMember]
        public virtual string email { get; set; }
        [DataMember]
        public virtual string password { get; set; }
        [DataMember]
        public virtual string creditcard_type { get; set; }
        [DataMember]
        public virtual string creditcard_number { get; set; }
        [DataMember]
        public virtual string status { get; set; }
        [DataMember]
        public virtual string message { get; set; }
    }
}