﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.entity;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.webservice
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IEmailService" in both code and config file together.
    [ServiceContract]    
    public interface IEmailService
    {
        [OperationContract(IsOneWay = true)]
        void sendMailToCustomer(Email email);
    }
}
