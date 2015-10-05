using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Forms;
using B2C.Entities;
using B2C.Facades;
using B2C.Handlers;

namespace B2C.Controllers
{
    public class CustomerController : BaseController
    {
        public ActionResult Register()
        {
            this.ini();
            return View();
        }
    }
}