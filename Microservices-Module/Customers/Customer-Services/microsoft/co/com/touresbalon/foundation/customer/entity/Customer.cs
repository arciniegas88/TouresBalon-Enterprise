using System.Collections.Generic;
using System.Runtime.Serialization;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity
{
    [DataContract]
    public class Customer
    {
        [DataMember]
        public virtual string Id { get; set; }
        [DataMember]
        public virtual string first_name { get; set;}
        [DataMember]
        public virtual string last_name { get; set; }
        [DataMember]
        public virtual string phone_number { get; set; }
        [DataMember]
        public virtual string email { get; set; }
        [DataMember]
        public virtual string creditcard_type { get; set; }
        [DataMember]
        public virtual string creditcard_number { get; set; }
        [DataMember]
        public virtual string status { get; set; }
        [DataMember]
        public virtual IList<Address> address { get; set; }
    }
}