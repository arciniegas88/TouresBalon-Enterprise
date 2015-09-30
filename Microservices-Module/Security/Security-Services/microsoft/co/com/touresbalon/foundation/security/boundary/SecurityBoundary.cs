using Security_Services.microsoft.co.com.touresbalon.foundation.security.dto;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.boundary
{
    public class SecurityBoundary
    {
        public bool authenticateBoundary(string userName,string password) {
            bool isAuthetication=false;

            if (GetUser(userName, password).Count>0) {
                isAuthetication = true;
            }

            return isAuthetication;
        }


        public List<User> GetUser(string userName,string password)
        {
            List<User> listUser = new List<User>();

            foreach (User user in GetUserData()) {
                if ((user.userName == userName) & (user.password == password)){
                    listUser.Add(user);
                }

            }
            return listUser;
        }

        public List<User> GetUserData()
        {
            List<User> listUser = new List<User>
            {
               new User { userName="stonerjrc@gmail.com",password="123456"},
               new User { userName="alejinqm@gmail.com",password="123456"},
               new User { userName="arciniegas88@gmail.com",password="123456"},
               new User { userName="jprodriguezor@gmail.com",password="123456"},
               new User { userName="harcalejo@gmail.com",password="123456"}               
            };
            return listUser;
        }



    }
}