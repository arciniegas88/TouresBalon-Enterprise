using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Xml.Serialization;

namespace B2C.Entities
{
    [XmlRootAttribute("authenticationResourceResult", Namespace = "http://www.w3.org/2001/XMLSchema-instance",
IsNullable = false)]
    public class User
    {
        public string email;
        public string userName;
        public string lastName;
        public string password;
        public string userGroup;
        public string userId;

    }
}