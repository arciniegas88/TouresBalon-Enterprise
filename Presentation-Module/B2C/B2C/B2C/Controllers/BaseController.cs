using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Utils;
using B2C.Entities;
using B2C.Handlers;

namespace B2C.Controllers
{
    public class BaseController : Controller
    {

        private User user;

        public void ini()
        {

            /*** Se obtiene el usuario sea anonimo o logueado ***/
            this.user = HandlerSession.getUser();
            ViewBag.userID = this.user.UserID;
            ViewBag.email = this.user.Email;

            /*** Se construye el menu que se le va mostrar al usuario ***/
            Menu menu = new Menu(this.ControllerContext.RouteData.Values["controller"].ToString(),
                           this.ControllerContext.RouteData.Values["action"].ToString());
            menu.buildMenu(this.user.UserID, this.user.Username);
            ViewData.Add("menu", menu);

            
        }

    }
}