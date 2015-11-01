using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace B2C.Forms
{
    public class RegisterForm
    {

        [Required]
        [Display(Name = "Tipo Documento")]
        public string Document_Type { get; set; }

        [Required]
        [Display(Name = "Documento")]
        public string Id { get; set; }

        [Required]
        [Display(Name = "Nombre")]
        public string FirstName { get; set; }

        [Required]
        [Display(Name = "Apellido")]
        public string LastName { get; set; }

        [Required]
        [Display(Name = "Telefono")]
        public string PhoneNumber { get; set; }

        [Required]
        [Display(Name = "Email")]
        [EmailAddress]
        public string Email { get; set; }


        [Required]
        [Display(Name = "Contraseña")]
        public string Password { get; set; }

        [Required]
        [Display(Name = "Franchise")]
        public string Franchise { get; set; }

        [Required]
        [Display(Name = "Number")]
        [DataType(DataType.CreditCard)]
        public string Number { get; set; }

        [Required]
        [Display(Name = "Tipo")]
        public string Type { get; set; }
    }
}