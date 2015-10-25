using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using B2C.Forms;
using B2C.Facades;
using B2C.Entities;
using B2C.Handlers;
using B2C.Utils;

namespace B2C.Controllers
{
    public class SecurityController : BaseController
    {

        public JsonResult Login()
        {
            if (Request.HttpMethod == "POST")
            {
                String password = Request.Params.Get("password");
                String email = Request.Params.Get("email");

                Customer customer = new Customer(email, password);
                bool response = SecurityFacade.Instance.getLoginUser(customer);
                if (response)
                {
                    return Json(new { success = true, url = Url.Action("Index", "Home") });
                }
                else
                {
                    return Json(new { success = false, message =  Message.ACCESS_DENIED });
                }
            }
            return Json(new { success = false, message = Message.METHOD_DENIED });

        }

        public ActionResult Register()
        {
            return View();
        }

        public ActionResult Logout()
        {
            HandlerSession.destroy();
            return RedirectToAction("Index", "Home");
        }

        private ActionResult RedirectToLocal(string returnUrl)
        {
            if (Url.IsLocalUrl(returnUrl))
            {
                return Redirect(returnUrl);
            }
            return RedirectToAction("Index", "Home");
        }
    }
}