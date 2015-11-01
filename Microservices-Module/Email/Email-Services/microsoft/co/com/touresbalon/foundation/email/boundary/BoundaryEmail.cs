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

        public void sendMailCustomer(string from, string password, Email email)
        {
            try
            {
                email = setEmailMessage(email);                
                m.From = new MailAddress(from);
                m.To.Add(new MailAddress(email.email));
                m.Subject = email.subject;
                smtp.Host = "smtp.gmail.com";
                smtp.Port = 587;
                smtp.Credentials = new NetworkCredential(from, password);
                smtp.EnableSsl = true;

                string text = email.messageSend;
                AlternateView plainView = AlternateView.CreateAlternateViewFromString(text, Encoding.UTF8, MediaTypeNames.Text.Plain);
                string html = readTemplate(email);

                AlternateView htmlView =
                    AlternateView.CreateAlternateViewFromString(html,
                                            Encoding.UTF8,
                                            MediaTypeNames.Text.Html);

                //LinkedResource img = new LinkedResource(@"~/App_Data/img/touresBalon.jpg", MediaTypeNames.Image.Jpeg);
                //LinkedResource img = new LinkedResource("~/microsoft/co/com/touresbalon/foundation/email/img/touresBalon.jpg", MediaTypeNames.Image.Jpeg);
                LinkedResource img = new LinkedResource(@"C:\touresBalon.jpg", MediaTypeNames.Image.Jpeg);
                img.ContentId = "imagen";

                htmlView.LinkedResources.Add(img);
                m.AlternateViews.Add(plainView);
                m.AlternateViews.Add(htmlView);
                m.IsBodyHtml = true;
                smtp.Send(m);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

        }


        private Email setEmailMessage(Email email) {
            int caseSwitch = Int32.Parse(email.Id);
            switch (caseSwitch)
            {
                case 1:
                    email.subject = "Aprovisionamiento Manual";
                    email.messageSend = "Su orden esta en aprovisionamiento manual";
                    email.body = "Su orden esta en aprovisionamiento manual";
                    email.footer = "Querido usuario gracias por utilizar Nuestro sistema";
                    break;
                case 2:
                    email.subject = "Orden No procesada";
                    email.messageSend = "Error en tarjeta de credito";
                    email.body = "la información de la tarjeta de credito no pudo ser validada";
                    email.footer = "Querido usuario gracias por utilizar Nuestro sistema";
                    break;
                case 3:
                    email.subject = "Orden No procesada";
                    email.messageSend = "Error producto seleccionado no existe ";
                    email.body = "El producto seleccionado tiene inconvenientes, favor revisar los parametros de la orden";
                    email.footer = "Querido usuario gracias por utilizar Nuestro sistema";
                    break;
                case 4:
                    email.subject = "Orden Procesada Correctamente";
                    email.body = "Su orden ha sido aprobada";
                    email.messageSend = "Su orden ha sido procesada gracias por utilizar el servicio TouresBalon";
                    email.footer = "Querido usuario gracias por utilizar Nuestro sistema";
                    break;
                default:
                    email.subject = "Error procesando la orden";
                    email.messageSend = "Error procesando la orden, comuniquese con el administrador del sistema";
                    email.body = "Hay problemas con con el procesamiento de su orden";
                    email.footer = "Querido usuario gracias por utilizar Nuestro sistema";
                    break;
            }


            return email;
        }

              
        
        public string readTemplate(Email email) {
            string line = "";
            StringBuilder sb = new StringBuilder();
            try
            {
                StreamReader file = new StreamReader("C:\\prueba.html");
                while ((line = file.ReadLine()) != null)
                {
                    if (line.Contains("#name"))
                    {
                        line = line.Replace("#name", email.first_name+" "+ email.last_name);                        
                    }
                    if (line.Contains("#bodyMessagge"))
                    {
                        line = line.Replace("#bodyMessagge", email.body);
                    }
                    if (line.Contains("#footerMessage"))
                    {
                        line = line.Replace("#footerMessage", email.footer);
                    }
                    sb.Append(line); 
                }
                file.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("error:" + e.Message);
            }
            return sb.ToString();

        }
        

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

                htmlView.LinkedResources.Add(img);

                m.AlternateViews.Add(plainView);
                m.AlternateViews.Add(htmlView);

                
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
