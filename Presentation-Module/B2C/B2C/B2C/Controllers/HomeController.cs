using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Utils;
using B2C.Entities;
using B2C.Facades;

namespace B2C.Controllers
{
    public class HomeController : BaseController
    {
        public ActionResult Index()
        {
            ViewBag.Message = "Home.";

            //Inicializamos el controller
            this.ini();

            ViewData.Add("campaigns", ProductFacade.Instance.getCampaigns());

            return View();
        }

        public ActionResult Quienes()
        {
            ViewBag.Message = "Quienes Somos?";

            this.ini();

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}