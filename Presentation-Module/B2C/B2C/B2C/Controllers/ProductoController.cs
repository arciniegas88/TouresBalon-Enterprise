using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Agents;

namespace B2C.Controllers
{
    public class ProductoController : BaseController
    {
        // GET: Producto
        public ActionResult Index()
        {
            this.ini();

            ProductService pro_service = new ProductService();
            ViewData.Add("products", pro_service.getProducts());

            return View();
        }

        public ActionResult Detalle(int id)
        {
            this.ini();

            ProductService pro_service = new ProductService();
            ViewData.Add("product", pro_service.getProduct(id));
            ViewData.Add("products", pro_service.getTopFive(id));

            return View();
        }
    }
}