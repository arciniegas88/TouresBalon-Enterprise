using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace B2C.Controllers
{
    public class ErrorController : BaseController
    {
        // GET: Error
        public ActionResult Error400()
        {
            this.ini();
            return View();
        }

        public ActionResult Error500()
        {
            this.ini();
            return View();
        }
    }
}