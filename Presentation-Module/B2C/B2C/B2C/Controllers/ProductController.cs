using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Facades;
namespace B2C.Controllers
{
    public class ProductController : BaseController
    {
        // GET: Producto
        public ActionResult Index()
        {
            this.ini();
            ViewData.Add("products", OrderFacade.Instance.getProducts());
            return View();
        }

        public ActionResult Detail(int id)
        {
            this.ini();

            ViewData.Add("product", OrderFacade.Instance.getProduct(id));
            ViewData.Add("products", OrderFacade.Instance.getTopFive(id));

            return View();
        }
    }
}