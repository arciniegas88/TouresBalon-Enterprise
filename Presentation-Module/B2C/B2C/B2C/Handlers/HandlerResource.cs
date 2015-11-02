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
        private static XmlDocument xmlCancel = null;
        private static XmlDocument xmlLogin = null;
        private static XmlDocument xmlRegister = null;

        public static XmlDocument getXmlProcessingOrder()
        {
            XmlDocument xml = HandlerXML.loadXml("~/Resources/protected/xml/ProccessingOrder.xml");
            return xml;
        }

        public static XmlDocument getXmlItem()
        {
            if (HandlerResource.xmlItem == null)
            {
                HandlerResource.xmlItem = HandlerXML.loadXml("~/Resources/protected/xml/Item.xml");
            }

            return HandlerResource.xmlItem;
        }

        public static XmlDocument getXmlCancel()
        {
            if (HandlerResource.xmlCancel == null)
            {
                HandlerResource.xmlCancel = HandlerXML.loadXml("~/Resources/protected/xml/CancelOrder.xml");
            }

            return HandlerResource.xmlCancel;
        }

        public static XmlDocument getXmlLogin()
        {
            if (HandlerResource.xmlLogin == null)
            {
                HandlerResource.xmlLogin = HandlerXML.loadXml("~/Resources/protected/xml/login.xml");
            }

            return HandlerResource.xmlLogin;
        }

        public static XmlDocument getXmlRegister()
        {
            if (HandlerResource.xmlRegister == null)
            {
                HandlerResource.xmlRegister = HandlerXML.loadXml("~/Resources/protected/xml/register.xml");
            }
            return HandlerResource.xmlRegister;
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

        private static List<SelectListItem> type_client = null;
        public static IEnumerable<SelectListItem> getTypeClient()
        {
            if (HandlerResource.type_client == null)
            {
                HandlerResource.type_client = new List<SelectListItem>();
                HandlerResource.type_client.Add(new SelectListItem { Text = "Seleccione Tipo de cliente", Value = "" });
                HandlerResource.type_client.Add(new SelectListItem { Text = "PLATEADO", Value = "SILVER" });
                HandlerResource.type_client.Add(new SelectListItem { Text = "PLATINO", Value = "PLATINUM" });
                HandlerResource.type_client.Add(new SelectListItem { Text = "DORADO", Value = "GOLD" });
            }
            return HandlerResource.type_client;
        }


        private static List<SelectListItem> document_type = null;
        public static IEnumerable<SelectListItem> getDocumentType()
        {
            if (HandlerResource.document_type == null)
            {
                HandlerResource.document_type = new List<SelectListItem>();
                HandlerResource.document_type.Add(new SelectListItem { Text = "Seleccione Tipo de documento", Value = "" });
                HandlerResource.document_type.Add(new SelectListItem { Text = "Cedula de ciudadania", Value = "CC" });
                HandlerResource.document_type.Add(new SelectListItem { Text = "Cedula de extranjeria", Value = "CE" });
                HandlerResource.document_type.Add(new SelectListItem { Text = "Pasaporte", Value = "PASSPORT" });
                HandlerResource.document_type.Add(new SelectListItem { Text = "Nit", Value = "NIT" });
            }
            return HandlerResource.document_type;
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