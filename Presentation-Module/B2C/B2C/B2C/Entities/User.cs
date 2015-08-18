using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace B2C.Entities
{
    public class User
    {
        private int userID;
        private string username;
        private string email;

        public User(int _userID, string _username, string _email)
        {
            this.UserID = _userID;
            this.Username = _username;
            this.Email = _email;
        }

        public int UserID
        {
            get
            {
                return userID;
            }

            set
            {
                userID = value;
            }
        }

        public string Email
        {
            get
            {
                return email;
            }

            set
            {
                email = value;
            }
        }

        public string Username
        {
            get
            {
                return username;
            }

            set
            {
                username = value;
            }
        }
    }
}