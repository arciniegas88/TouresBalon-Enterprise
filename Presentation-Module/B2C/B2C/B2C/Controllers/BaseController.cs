using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Utils;
using B2C.Entities;
using B2C.Handlers;
using B2C.Forms;

namespace B2C.Controllers
{
    public class BaseController : Controller
    {
        protected static int BY_PAGE = 8;

        public void ini()
        {
            Customer customer;

            /*** Se obtiene el usuario sea anonimo o logueado ***/
            customer = HandlerSession.getCustomer();
            ViewBag.userID =customer.UserID;
            ViewBag.email = customer.Email;

            /*** Se construye el menu que se le va mostrar al usuario ***/
            Menu menu = new Menu();
            menu.buildMenu(customer, this.ControllerContext.RouteData.Values["controller"].ToString(),
                           this.ControllerContext.RouteData.Values["action"].ToString());
            ViewData.Add("menu", menu);


            //Validamos si en el TempData se envio un error de login
            if (TempData["loginForm"] != null)
            {
                ViewData.Add("loginForm", TempData["loginForm"] as LoginForm);
            }
            else
            {
                ViewData.Add("loginForm", new LoginForm());
            }

            //Validamos si en el TempData se envio un error de registro
            if (TempData["registerForm"] != null)
            {
                ViewData.Add("registerForm", TempData["registerForm"] as RegisterForm);
            }
            else
            {
                ViewData.Add("registerForm", new RegisterForm());
            }
        }

        public List<String> getErrorsModel()
        {
            List<String> errors = new List<string>();
            foreach (ModelState modelState in ViewData.ModelState.Values)
            {
                foreach (ModelError error in modelState.Errors)
                {
                    errors.Add(error.ErrorMessage);
                }
            }
            return errors;
        }

    }
}