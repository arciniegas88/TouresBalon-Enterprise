using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Entities;

namespace B2C.Handlers
{
    public class HandlerSession
    {
        public static User getUsuario()
        {
            User user = null;
            if( HttpContext.Current.Session["UserID"] != null )
            {
                int id = Int32.Parse( HttpContext.Current.Session["UserID"].ToString() );
                string username = HttpContext.Current.Session["username"].ToString();

                user = new User(id, username, "");
            }
            else
            {
                user = new User(0, "anonymous", "anonymous");
            }

            return user;
        }
    }
}