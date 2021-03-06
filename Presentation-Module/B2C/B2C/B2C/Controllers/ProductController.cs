﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using B2C.Facades;
namespace B2C.Controllers
{

    public class ProductController : BaseController
    {
        
        protected static SelectList FILTER_OPTIONS = new SelectList(
                  new List<Object>
        {
        new { value = 0 , text = "Seleccione filtro de busqueda"  },
        new { value = "code" , text = "Codigo" },
        new { value = "name" , text = "Nombre"},
        new { value = "description" , text = "Descripcion"}
        }, "Value", "Text");


        // GET: Producto
        public ActionResult Index(string search = "", string search_by="", int page = 1)
        {
            this.ini();
            
            int totalProducts = ProductFacade.Instance.getTotalProducts(search, search_by, page, ProductController.BY_PAGE);
            int totalPage = (int) Math.Ceiling( (double) totalProducts / (double) ProductController.BY_PAGE );


            ViewData.Add("actual_page", page);
            ViewData.Add("total_pages", totalPage);
            ViewData.Add("search", search);
            ViewData.Add("search_by", search_by);

            ViewData.Add("products", ProductFacade.Instance.getProducts(search, search_by, page, ProductController.BY_PAGE));
            ViewData.Add("filter_options", ProductController.FILTER_OPTIONS);
            return View();
        }

        public ActionResult Detail(int id)
        {
            this.ini();

            ViewData.Add("product", ProductFacade.Instance.getProduct(id));
            ViewData.Add("products", ProductFacade.Instance.getTopFive(id));

            return View();
        }

        public PartialViewResult GetPage()
        {
            int page = 1;
            if (Request.Params.Get("page") != null && !Request.Params.Get("page").Equals("page") )
                 page = Int32.Parse(Request.Params.Get("page"));
            String search = Request.Params.Get("search");
            String search_by = Request.Params.Get("search_by");
            List < B2C.Entities.Product > items = ProductFacade.Instance.getProducts(search, search_by, page, ProductController.BY_PAGE);
            ViewData.Add("items", items);
            return PartialView("~/Views/Product/Products.cshtml", new { items = items });
        }
    }
}