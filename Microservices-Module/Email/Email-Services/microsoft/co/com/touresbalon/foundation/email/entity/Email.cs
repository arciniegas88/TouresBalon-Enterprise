using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.entity
{
    [DataContract]
    public class Email
    {
        [DataMember]
        public virtual string Id { get; set; }
        [DataMember]
        public virtual string first_name { get; set; }
        [DataMember]
        public virtual string last_name { get; set; }
        [DataMember]
        public virtual string email { get; set; }
        [DataMember]
        public virtual string subject { get; set; }
        [DataMember]
        public virtual string body { get; set; }
        [DataMember]
        public virtual string footer { get; set; }
        [DataMember]
        public virtual string messageSend { get; set; }

    }
}