using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net;
using System.Net.Mail;
using System.IO;
using System.Web;

using System.Net.Mime;
using Email_Services.microsoft.co.com.touresbalon.foundation.email.entity;

namespace Email_Services.microsoft.co.com.touresbalon.foundation.email.boundary
{
    public class BoundaryEmail
    {

        MailMessage m = new MailMessage();
        SmtpClient smtp = new SmtpClient();


        public bool sendMail(string from, string password, Customer customer)
        {
            try
            {
                m.From = new MailAddress(from);
                m.To.Add(new MailAddress(customer.email));
                //m.Body = message;
                m.Subject = "Estado de la orden";
                smtp.Host = "smtp.gmail.com";
                smtp.Port = 587;
                smtp.Credentials = new NetworkCredential(from, password);
                smtp.EnableSsl = true;
                string text = "Aprobacion plantilla desde .net y sugerencias";

                AlternateView plainView =
                    AlternateView.CreateAlternateViewFromString(text,
                                            Encoding.UTF8,
                                            MediaTypeNames.Text.Plain);


                string html = templateBody(customer);

                AlternateView htmlView =
                    AlternateView.CreateAlternateViewFromString(html,
                                            Encoding.UTF8,
                                            MediaTypeNames.Text.Html);

                LinkedResource img = new LinkedResource(@"C:\touresBalon.jpg",
                                        MediaTypeNames.Image.Jpeg);
                img.ContentId = "imagen";

                // Lo incrustamos en la vista HTML...

                htmlView.LinkedResources.Add(img);

                // Por último, vinculamos ambas vistas al mensaje...

                m.AlternateViews.Add(plainView);
                m.AlternateViews.Add(htmlView);


                //m.Body = PopulateBody("nestor","esto que es");
                Console.WriteLine("esto es el body" + m.Body);
                m.IsBodyHtml = true;

                smtp.Send(m);


                return true;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
                return false;
            }

        }



        private string templateBody(Customer customer)
        {
            string body = string.Empty;
            StringBuilder sb = new StringBuilder();
            
            sb.Append("<html>");
            sb.Append("<head>");
            sb.Append("<title></title>");
            sb.Append("</head>");
            sb.Append("<body>");
            sb.Append("<img src='cid:imagen' /><br/><br/>");                                    
            sb.Append("<div style=\"border-top:3px solid #22BCE5\"> &nbsp;</div>");
            sb.Append("<span style=\"font-family:Arial;font-size:10pt\">");
            sb.Append("Hola <b>"+customer.first_name+" "+customer.last_name+"</b>,<br/><br/>");
            sb.Append("Su orden ha sido aprobada<br/><br/>");
            sb.Append(customer.message);
            sb.Append("<br/><br/>");
            sb.Append("Saludos cordiales <br/>");
            sb.Append("Universidad Javeriana");
            sb.Append("</span>");
            sb.Append("</body>");
            sb.Append("</html>");

            body = sb.ToString();
              
            return body;
        }


    }
}
