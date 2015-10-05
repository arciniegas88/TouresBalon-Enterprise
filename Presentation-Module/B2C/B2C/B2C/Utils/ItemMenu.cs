using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Routing;

namespace B2C.Utils
{


    public class ItemMenu
    {

        public string Text { get; set; }
        public string Url { get; set; }
        public string ActionName { get; set; }
        public string ControllerName { get; set; }

        public Object HtmlAttributes;

        public string icon;

        public List<ItemMenu> submenu { get; set; }
        
    }
}