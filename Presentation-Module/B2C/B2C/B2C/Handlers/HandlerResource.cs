using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Xml;

namespace B2C.Handlers
{
    public class HandlerResource
    {
        
        private static Dictionary<String, String> serviceAgentLocation;
        private static XmlDocument xmlProcessingOrder = null;
        private static XmlDocument xmlItem = null;

        public static XmlDocument getXmlProcessingOrder()
        {
            if(HandlerResource.xmlProcessingOrder == null)
            {
                HandlerResource.xmlProcessingOrder = HandlerXML.loadXml("~/Resources/protected/xml/ProccessingOrder.xml");
            }

            return HandlerResource.xmlProcessingOrder;
        }

        public static XmlDocument getXmlItem()
        {
            if (HandlerResource.xmlItem == null)
            {
                HandlerResource.xmlItem = HandlerXML.loadXml("~/Resources/protected/xml/Item.xml");
            }

            return HandlerResource.xmlItem;
        }

        public static void iniServiceAgentLocation()
        {
            HandlerResource.serviceAgentLocation = HandlerXML.loadXml("serviceAgents", "serviceAgent");
        }

        public static string getServiceAgentLocation(String nameService)
        {
            String value = "";

            if (HandlerResource.serviceAgentLocation.TryGetValue(nameService, out value))
            {
                return value;
            }
            else
            {
                return "";
            }
        }

        private static List<SelectListItem> franchises = null;
        public static IEnumerable<SelectListItem> getFranchises()
        {
            if (HandlerResource.franchises == null)
            {
                HandlerResource.franchises = new List<SelectListItem>();
                HandlerResource.franchises.Add(new SelectListItem { Text = "Seleccione Franquicia", Value = "" });
                HandlerResource.franchises.Add(new SelectListItem { Text = "VISA", Value = "VISA" });
                HandlerResource.franchises.Add(new SelectListItem { Text = "MASTER CARD", Value = "MASTER CARD" });
                HandlerResource.franchises.Add(new SelectListItem { Text = "AMEX", Value = "AMEX" });
            }
            return HandlerResource.franchises;
        }

        private static List<SelectListItem> years = null;
        public static IEnumerable<SelectListItem> getYears()
        {
            if (HandlerResource.years == null)
            {
                HandlerResource.years = new List<SelectListItem>();

                int i = 0;
                for ( i = 2015; i < 2035; i++)
                {
                    HandlerResource.years.Add(new SelectListItem { Text = i.ToString(), Value = i.ToString() });
                }
            }
            return HandlerResource.years;
        }

        private static List<SelectListItem> months = null;
        public static IEnumerable<SelectListItem> getMonths()
        {
            if (HandlerResource.months == null)
            {
                HandlerResource.months = new List<SelectListItem>();

                HandlerResource.months.Add(new SelectListItem { Text = "Ene", Value = "1" });
                HandlerResource.months.Add(new SelectListItem { Text = "Feb", Value = "2" });
                HandlerResource.months.Add(new SelectListItem { Text = "Mar", Value = "3" });
                HandlerResource.months.Add(new SelectListItem { Text = "Abr", Value = "4" });
                HandlerResource.months.Add(new SelectListItem { Text = "May", Value = "5" });
                HandlerResource.months.Add(new SelectListItem { Text = "Jun", Value = "6" });
                HandlerResource.months.Add(new SelectListItem { Text = "Jul", Value = "7" });
                HandlerResource.months.Add(new SelectListItem { Text = "Ago", Value = "8" });
                HandlerResource.months.Add(new SelectListItem { Text = "Sep", Value = "9" });
                HandlerResource.months.Add(new SelectListItem { Text = "Oct", Value = "10" });
                HandlerResource.months.Add(new SelectListItem { Text = "Nov", Value = "11" });
                HandlerResource.months.Add(new SelectListItem { Text = "Dic", Value = "12" });
            }
            return HandlerResource.months;
        }

        private static List<SelectListItem> dues = null;
        public static IEnumerable<SelectListItem> getDues()
        {
            if (HandlerResource.dues == null)
            {
                HandlerResource.dues = new List<SelectListItem>();

                int i = 1;
                for (i = 1; i <= 12; i++)
                {
                    HandlerResource.dues.Add(new SelectListItem { Text = i.ToString(), Value = i.ToString() });
                }
            }
            return HandlerResource.dues;
        }

    }
}