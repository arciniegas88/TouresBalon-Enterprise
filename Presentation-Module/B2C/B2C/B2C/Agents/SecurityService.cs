using System;
using System.Collections.Generic;
using System.Web;
using B2C.Entities;

namespace B2C.Agents
{
    public class SecurityService
    {

        public User loginUser(string email, string password)
        {
            return new User(1, email, email);
        }


    }
}