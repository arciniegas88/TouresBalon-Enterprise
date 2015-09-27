using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Text;

namespace B2C.Controllers
{
    using B2C.Facades;
    using B2C.Handlers;
    using B2C.Entities;

    public class OrderController : BaseController
    {

        public ActionResult Index()
        {
            this.ini();

            Customer customer = HandlerSession.getCustomer();

            ViewData.Add("Orders", OrderFacade.Instance.getOrdersCustomer(customer));

            return View();
        }

        public PartialViewResult Get(int id)
        {
            List<ItemOrder> items = OrderFacade.Instance.getItemsOrder(id);
            ViewData.Add("items", items);
            return PartialView("~/Views/Order/Item.cshtml", new { items = items });
        }

        public JsonResult Cancel(int id)
        {
            return Json(OrderFacade.Instance.cancelOrder(id));
        }

    }
}