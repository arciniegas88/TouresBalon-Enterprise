using System.Runtime.Serialization;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity
{
    [DataContract]
    public class Address
    {
        [DataMember]
        public virtual long Id { get; set; }
        [DataMember]
        public virtual string street { get; set; }
        [DataMember]
        public virtual string state { get; set; }
        [DataMember]
        public virtual string zip { get; set; }
        [DataMember]
        public virtual string country { get; set; }
        [DataMember]
        public virtual string address_type { get; set; }
        [DataMember]
        public virtual string city { get; set; }
    }
}