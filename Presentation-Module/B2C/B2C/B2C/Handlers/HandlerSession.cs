﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;

namespace B2C.Handlers
{
    public class HandlerSession
    {
        public static User getUser()
        {
            User user = null;
            if (HttpContext.Current.Session["UserID"] != null)
            {
                int id = Int32.Parse(HttpContext.Current.Session["UserID"].ToString());
                string username = HttpContext.Current.Session["username"].ToString();

                user = new User(id, username, "");
            }
            else
            {
                user = new User(0, "anonymous", "anonymous");
            }

            return user;
        }

        public static void setUser(User user)
        {
            HttpContext.Current.Session.Add("username", user.Email);
            HttpContext.Current.Session.Add("UserID", user.UserID);
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