using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.entity;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.boundary;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.webservice
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "EmailService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select EmailService.svc or EmailService.svc.cs at the Solution Explorer and start debugging.
    public class EmailService : IEmailService
    {
        public void sendMailToCustomer(Email emailSend)
        {
            BoundaryEmail email = new BoundaryEmail();
            string fromEmail = "touresbalongrupo3@gmail.com";
            string password = "aes2015/*";

            if (emailSend != null)
            {
                email.sendMailCustomer(fromEmail, password, emailSend);
            }
           // return "send email successful";
        }
    }
}
