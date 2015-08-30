﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using B2C.Forms;

namespace B2C.Entities
{
    public class Customer
    {
        private int userID;
        private string first_name;
        private string last_name;
        private string phone_number;
        private string email;
        private string password;

        private string creditcard_type;
        private string creditcard_number;
        private string nvarchar;
        private string status;
        private string document_number;
        private string document_type;

        public Customer(int _userID, string _email)
        {
            this.UserID = _userID;
            this.Email = _email;
        }

        public Customer(LoginForm form)
        {
            this.Email = form.Email;
            this.Password = form.Password;
        }

        public Customer(RegisterForm form)
        {
            this.first_name = form.FirstName;
            this.last_name = form.LastName;
            this.phone_number = form.PhoneNumber;
            this.password = form.Password;
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

        public string First_name
        {
            get
            {
                return first_name;
            }

            set
            {
                first_name = value;
            }
        }

        public string Last_name
        {
            get
            {
                return last_name;
            }

            set
            {
                last_name = value;
            }
        }

        public string Phone_number
        {
            get
            {
                return phone_number;
            }

            set
            {
                phone_number = value;
            }
        }

        public string Email1
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

        public string Password
        {
            get
            {
                return password;
            }

            set
            {
                password = value;
            }
        }

        public string Creditcard_type
        {
            get
            {
                return creditcard_type;
            }

            set
            {
                creditcard_type = value;
            }
        }

        public string Creditcard_number
        {
            get
            {
                return creditcard_number;
            }

            set
            {
                creditcard_number = value;
            }
        }

        public string Nvarchar
        {
            get
            {
                return nvarchar;
            }

            set
            {
                nvarchar = value;
            }
        }

        public string Status
        {
            get
            {
                return status;
            }

            set
            {
                status = value;
            }
        }

        public string Document_number
        {
            get
            {
                return document_number;
            }

            set
            {
                document_number = value;
            }
        }

        public string Document_type
        {
            get
            {
                return document_type;
            }

            set
            {
                document_type = value;
            }
        }
    }
}