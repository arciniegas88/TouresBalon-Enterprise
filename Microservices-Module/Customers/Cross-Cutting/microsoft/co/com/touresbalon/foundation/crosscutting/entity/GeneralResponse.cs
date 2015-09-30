using System.Runtime.Serialization;

namespace Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity
{
    [DataContract]
    public class GeneralResponse
    {
        public static string STATUS_ERROR = "ERROR";
        public static string STATUS_OK = "OK";

        [DataMember]
        public virtual string message { get; set; }
        [DataMember]
        public virtual string status { get; set; }
        [DataMember]
        public virtual string code { get; set; }
    }
}
