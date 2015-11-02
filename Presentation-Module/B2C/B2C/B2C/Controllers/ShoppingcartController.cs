using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Handlers;
using B2C.Facades;

namespace B2C.Controllers
{
    public class ShoppingcartController : BaseController
    {
        public JsonResult Add()
        {
            if( Request.HttpMethod == "POST")
            {
                int id = Int32.Parse(Request.Params.Get("id"));
                String name = Request.Params.Get("name");
                int account = Int32.Parse(Request.Params.Get("account"));
                double cost = Double.Parse(Request.Params.Get("cost"));
                Object r = HandlerSession.addProduct(id, name, account, cost);

                return Json(r);
            }
            else
            {
                return Json(new { success = false });
            }
            
        }

        public JsonResult Delete()
        {
            if (Request.HttpMethod == "POST")
            {
                int id = Int32.Parse(Request.Params.Get("id"));
                int pos = Int32.Parse(Request.Params.Get("pos"));
                Object r = HandlerSession.deleteProduct(id, pos);

                return Json(r);
            }
            else
            {
                return Json(new { success = false });
            }
        }

        public ActionResult Show()
        {
            this.ini();

            ViewData.Add("products", HandlerSession.getProducts());
            return View();
        }


        public ActionResult Proccess()
        {
            this.ini();

            //(Request.Params.Get("form.Franchise"), Request.Params.Get("form.Number")
            OrderFacade.Instance.proccessOrder();

            HandlerSession.clearShoppingCar();

            return View();
        }
    }
}