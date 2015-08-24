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

            this.addMenu(controller_actual, action_actual, "Home", "Home", "Index", "", null);
            this.addMenu(controller_actual, action_actual, "Quienes Somos?", "Home", "Quienes", "", null);
            this.addMenu(controller_actual, action_actual, "Producto", "Product", "Index", "", null);
            this.addMenu(controller_actual, action_actual, "Contactenos", "Home", "Contactenos", "", null);
            
            if(customer.UserID == 0)
            {
                this.addMenu(controller_actual, action_actual, "Iniciar Sesion", "", "", "#", new { id = "login", title = "Iniciar Sesion", href = "#" });
            }
            else
            {
                
                this.addMenu(controller_actual, action_actual, String.Concat("Cerrar Sesion (", customer.Email, ")"), "security", "logout", "", null);
            }
       }

        public void addMenu(string controller_actual, string action_actual, string text, string controller, string action, string url, Object attributes)
        {
            Menu.item = new ItemMenu();
            item.Text = text;
            item.ControllerName = controller;
            item.ActionName = action;
            item.Url = url;

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