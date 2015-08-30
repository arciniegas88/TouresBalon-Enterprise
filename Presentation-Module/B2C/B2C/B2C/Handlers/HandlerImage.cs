using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Handlers
{
    public class HandlerImage
    {

        public static string convertStreamToImage(byte[] bytes)
        {
            string imageBase64 = Convert.ToBase64String(bytes);
            string imageSrc = string.Format("data:image/jpeg;base64,{0}", imageBase64);
            return imageSrc;
        }
    }
}