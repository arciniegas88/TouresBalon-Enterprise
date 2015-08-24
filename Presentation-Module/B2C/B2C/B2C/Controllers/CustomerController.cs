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
        [HttpPost]
        public ActionResult Register(RegisterForm form, String returnUrl)
        {
            if (ModelState.IsValid)
            {
                Customer user = new Customer(form);
                user = CustomerFacade.Instance.registerCustomer(user);
                HandlerSession.setUser(user);
                return Redirect(returnUrl);
            }
            else
            {
                TempData.Add("errors", this.getErrorsModel());
                TempData.Add("registerForm", form);
                return Redirect(returnUrl);
            }
        }
    }
}