using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using System.Web.Helpers;
using System.Web.Mvc;
using B2C.Utils;
using System.Xml;

namespace B2C.Handlers
{
    public class HandlerSession
    {
        public static bool isLogin()
        {
            if (HttpContext.Current.Session["Id"] != null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public static Customer getCustomer()
        {
            Customer user = null;
            if (HttpContext.Current.Session["Id"] != null)
            {
                Customer customer = new Customer(HttpContext.Current.Session["Id"].ToString(),
                                          HttpContext.Current.Session["email"].ToString(),
                                          HttpContext.Current.Session["creditcard_number"].ToString(),
                                          HttpContext.Current.Session["creditcard_type"].ToString(),
                                          HttpContext.Current.Session["first_name"].ToString(),
                                          HttpContext.Current.Session["last_name"].ToString()
                                          );
                return customer;
            }
            else
            {
                user = new Customer(0, "anonymous");
            }

            return user;
        }

        public static Object addProduct(int id, string name, int account, double cost)
        {
            int count = HandlerSession.getTotalOrder();
            count += 1;

            HandlerSession.setTotalOrder(count);

            HttpContext.Current.Session.Add(String.Concat("producto", count), new ProductCart(id, name, count, account, cost));

            return (new { success = true, total = count, message = Message.ADD_SUCCESS });
        }

        public static Object deleteProduct(int id, int pos)
        {
            ProductCart product_temp;
            product_temp = HttpContext.Current.Session[String.Concat("producto", (pos))] as ProductCart;
            product_temp.delete();

            HttpContext.Current.Session.Add(String.Concat("producto", pos), product_temp);

            return (new { success = true, message = Message.DELETE_SUCCESS });

        }
        public static List<ProductCart> getProducts()
        {
            int count = HandlerSession.getTotalOrder();
            int i = 0;
            List<ProductCart> response = new List<ProductCart>();
            ProductCart product_temp;
            for ( i = 0; i < count; i++)
            {
                product_temp = HttpContext.Current.Session[String.Concat("producto", (i + 1))] as ProductCart;
                if( !product_temp.isDelete() )
                    response.Add(product_temp );
            }

            return response;

        }

        private static void setTotalOrder(int count)
        {
            HttpContext.Current.Session.Add("totalOrder", count);
        }

        public static int getTotalOrder()
        {
            if (HttpContext.Current.Session["totalOrder"] != null)
            {
                return Int32.Parse(HttpContext.Current.Session["totalOrder"].ToString() );
            }
            else
            {
                return 0;
            }
        }

        public static void setUser(XmlDocument xml)
        {
            if (xml.GetElementsByTagName("email").Item(0) != null)
                HttpContext.Current.Session.Add("email", xml.GetElementsByTagName("email").Item(0).InnerText);

            if (xml.GetElementsByTagName("creditcard_number").Item(0) != null)
                HttpContext.Current.Session.Add("creditcard_number", xml.GetElementsByTagName("creditcard_number").Item(0).InnerText);

            if (xml.GetElementsByTagName("creditcard_type").Item(0) != null)
                HttpContext.Current.Session.Add("creditcard_type", xml.GetElementsByTagName("creditcard_type").Item(0).InnerText);

            if (xml.GetElementsByTagName("first_name").Item(0) != null)
                HttpContext.Current.Session.Add("first_name", xml.GetElementsByTagName("first_name").Item(0).InnerText);

            if (xml.GetElementsByTagName("last_name").Item(0) != null)
                HttpContext.Current.Session.Add("last_name", xml.GetElementsByTagName("last_name").Item(0).InnerText);

            if (xml.GetElementsByTagName("phone_number").Item(0) != null)
                HttpContext.Current.Session.Add("phone_number", xml.GetElementsByTagName("phone_number").Item(0).InnerText);

            if (xml.GetElementsByTagName("Id").Item(0) != null)
                HttpContext.Current.Session.Add("Id", xml.GetElementsByTagName("Id").Item(0).InnerText);

        }

        public static void destroy()
        {
            if (HttpContext.Current.Session["Id"] != null)
            {
                HttpContext.Current.Session.Remove("Id");
                HttpContext.Current.Session.Remove("email");
                HttpContext.Current.Session.Remove("creditcard_number");
                HttpContext.Current.Session.Remove("creditcard_type");
                HttpContext.Current.Session.Remove("last_name");
                HttpContext.Current.Session.Remove("phone_number");
            }
        }
    }
}