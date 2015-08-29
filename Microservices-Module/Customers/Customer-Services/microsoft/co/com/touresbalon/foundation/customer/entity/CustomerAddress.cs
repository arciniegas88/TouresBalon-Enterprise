using System.Runtime.Serialization;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity
{
    [DataContract]
    public class CustomerAddress
    {
        [DataMember]
        public virtual long customer_id { get; set; }
        [DataMember]
        public virtual long address_id { get; set; }
    }
}