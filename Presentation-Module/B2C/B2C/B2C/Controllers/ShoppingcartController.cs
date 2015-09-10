using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Handlers;

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
                Object r = HandlerSession.addProduct(id, name);

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
    }
}