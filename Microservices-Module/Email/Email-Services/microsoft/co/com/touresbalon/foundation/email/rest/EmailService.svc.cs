﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.entity;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.boundary;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.rest
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "EmailService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select EmailService.svc or EmailService.svc.cs at the Solution Explorer and start debugging.

    [ServiceBehavior(ConcurrencyMode = ConcurrencyMode.Multiple)]
    public class EmailService : IEmailService
    {
       

        public string sendMailToCustomer(Customer customer)
        {
            BoundaryEmail email = new BoundaryEmail();
            string fromEmail = "touresbalongrupo3@gmail.com";
            string password = "aes2015/*";

            if (customer != null) {
                email.sendMail(fromEmail, password,customer);
            }


            return "send email successful";
        }
    }
}
