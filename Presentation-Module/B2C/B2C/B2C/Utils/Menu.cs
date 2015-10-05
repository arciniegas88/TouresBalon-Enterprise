using System;
using System.Linq;
using System.Web;
using System.Web.Routing;
using System.Web.Mvc;
using System.Collections.Generic;
using B2C.Entities;

namespace B2C.Utils
{
    public class Menu
    {

        private List<ItemMenu> items;
        protected static ItemMenu item;

        public List<ItemMenu> Items
        {
            get
            {
                return items;
            }

            set
            {
                items = value;
            }
        }

        public Menu()
        {
        }

        public void buildMenu(Customer customer, string controller_actual, string action_actual)
        {
            this.items = new List<ItemMenu>();

            this.addMenu(controller_actual, action_actual, "Home", "Home", "Index", "", null, "icon-home");
            this.addMenu(controller_actual, action_actual, "Quienes Somos?", "Home", "Quienes", "", null, "icon-briefcase");
            this.addMenu(controller_actual, action_actual, "Producto", "Product", "Index", "", null, "icon-shopping_basket");

            if (customer.UserID != 0)
            {
                this.addMenu(controller_actual, action_actual, "Tus ordenes", "Order", "Index", "", null, "icon-receipt");
            }

            this.addMenu(controller_actual, action_actual, "Cart", "ShoppingCart", "Show", "", null, "icon-shopping_cart");
            
            if(customer.UserID == 0)
            {
                this.addMenu(controller_actual, action_actual, "Iniciar Sesion", "Home", "Login", "", new { id = "login", title = "Iniciar Sesion", href = "#" }, "icon-account_circle");
            }
            else
            {
                this.addMenu(controller_actual, action_actual, String.Concat("Cerrar Sesion (", customer.Email, ")"), "security", "logout", "", null, "icon-account_circle");
            }
       }

        public void addMenu(string controller_actual, string action_actual, string text, string controller, string action, string url, Object attributes, string icon)
        {
            Menu.item = new ItemMenu();
            item.Text = text;
            item.ControllerName = controller;
            item.ActionName = action;
            item.Url = url;
            item.icon = icon;

            if(attributes == null)
            {
                if(controller_actual.Equals(controller) && action_actual.Equals(action))
                {
                    item.HtmlAttributes = new { @class = "current" };
                }
                else {
                    item.HtmlAttributes = new { };
                }
            }else
            { 
                item.HtmlAttributes = attributes;
            }
            this.items.Add(item);
             
        }
    }
}