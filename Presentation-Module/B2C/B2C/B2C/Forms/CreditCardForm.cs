using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace B2C.Forms
{
    public class CreditCardForm
    {
        

        [Required]
        [Display(Name = "Franchise")]
        public string Franchise { get; set; }

        [Required]
        [Display(Name = "Number")]
        [DataType(DataType.CreditCard)]
        public string Number { get; set; }

        [Required]
        [Display(Name = "SECRET_CODE")]
        [DataType(DataType.PhoneNumber)]
        public string SECRET_CODE { get; set; }

        [Required]
        [Display(Name = "Year")]
        public string Year { get; set; }

        [Required]
        [Display(Name = "Month")]
        public string Month { get; set; }

        [Required]
        [Display(Name = "Dues")]
        [DataType(DataType.Custom)]
        public string Dues { get; set; }
    }
}