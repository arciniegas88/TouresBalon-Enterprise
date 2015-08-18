using System;
using System.Linq;
using System.Web;
using System.Web.Routing;
using System.Web.Mvc;
using System.Collections.Generic;

namespace B2C.Utils
{
    public class Menu
    {

        private List<ItemMenu> items;
        private string actual_controller;
        private string actual_action;
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

        public Menu(string controller, string action)
        {
            this.actual_controller = controller;
            this.actual_action = action;
        }

        public void buildMenu(int userID, string username)
        {
            this.items = new List<ItemMenu>();

            this.addMenu("Home", "home", "index", "", null);
            this.addMenu("Quienes Somos?", "home", "quienes", "", null);
            this.addMenu("Producto", "producto", "index", "", null);
            this.addMenu("Contactenos", "home", "contactenos", "", null);
            
            if(userID == 0)
            {
                this.addMenu("Iniciar Sesion", "", "", "#", new { id = "login", title = "Iniciar Sesion", href = "#" });
            }
            else
            {
                
                this.addMenu(String.Concat("Cerrar Sesion (", username, ")"), "autenticar", "logout", "", null);
            }
       }

        public void addMenu(string text, string controller, string action, string url, Object attributes)
        {
            Menu.item = new ItemMenu();
            item.Text = text;
            item.ControllerName = controller;
            item.ActionName = action;
            item.Url = url;

            if(attributes == null)
            {
                if( this.actual_controller.Equals(controller) && this.actual_action.Equals("action"))
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