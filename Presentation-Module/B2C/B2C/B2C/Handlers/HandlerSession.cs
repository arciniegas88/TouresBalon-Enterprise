using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;
using System.Web.Helpers;
using System.Web.Mvc;
using B2C.Utils;

namespace B2C.Handlers
{
    public class HandlerSession
    {
        public static Customer getCustomer()
        {
            Customer user = null;
            if (HttpContext.Current.Session["UserID"] != null)
            {
                int id = Int32.Parse(HttpContext.Current.Session["UserID"].ToString());
                string username = HttpContext.Current.Session["username"].ToString();

                user = new Customer(id, username);
            }
            else
            {
                user = new Customer(0, "anonymous");
            }

            return user;
        }

        public static void setUser(Customer user)
        {
            HttpContext.Current.Session.Add("username", user.Email);
            HttpContext.Current.Session.Add("UserID", user.UserID);
        }

        public static Object addProduct(int id, string name, int account)
        {
            int count = HandlerSession.getTotalOrder();
            count += 1;

            HandlerSession.setTotalOrder(count);

            HttpContext.Current.Session.Add(String.Concat("producto", count), new ProductCart(id, name, count, account));

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

        public static void destroy()
        {
            if (HttpContext.Current.Session["UserID"] != null)
            {
                HttpContext.Current.Session.Remove("UserID");
                HttpContext.Current.Session.Remove("username");
            }
        }
    }
}