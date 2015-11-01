using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Forms;
using B2C.Entities;
using B2C.Facades;
using B2C.Handlers;
using System.Xml;
using System.IO;

namespace B2C.Controllers
{
    public class CustomerController : BaseController
    {
        public ActionResult Register()
        {
            this.ini();
            return View();
        }

        public JsonResult Create()
        {
            String password = Request.Params.Get("password");
            String email = Request.Params.Get("email");
            String document_type = Request.Params.Get("document_type");
            String id = Request.Params.Get("id");
            String first_name = Request.Params.Get("first_name");
            String last_name = Request.Params.Get("last_name");
            String phone = Request.Params.Get("phone");
            String franchise = Request.Params.Get("franchise");
            String number = Request.Params.Get("number");
            String type = Request.Params.Get("type");

            XmlDocument xml = HandlerResource.getXmlRegister();
            xml.GetElementsByTagName("Id").Item(0).InnerText = id;
            xml.GetElementsByTagName("creditcard_number").Item(0).InnerText = number;
            xml.GetElementsByTagName("creditcard_type").Item(0).InnerText = franchise;
            xml.GetElementsByTagName("password").Item(0).InnerText = password;
            xml.GetElementsByTagName("email").Item(0).InnerText = email;
            xml.GetElementsByTagName("first_name").Item(0).InnerText = first_name;
            xml.GetElementsByTagName("last_name").Item(0).InnerText = last_name;
            xml.GetElementsByTagName("phone_number").Item(0).InnerText = phone;
            xml.GetElementsByTagName("doc_type").Item(0).InnerText = document_type;
            xml.GetElementsByTagName("type").Item(0).InnerText = type;

            StringWriter sw = new StringWriter();
            XmlTextWriter tx = new XmlTextWriter(sw);
            xml.WriteTo(tx);

            string str = sw.ToString();

            bool response = CustomerFacade.Instance.registerCustomer(str);
            
            return Json(new { success = true, url = Url.Action("Login", "Home") });
        }
    }
}