using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel.DataAnnotations;

namespace BikeDemo.Models
{
    public class ContactModel 
    {
       
        [Required]
        public string fName { get; set; }
        [Required]
        public string lName { get; set; }
        [Required]
       
        public string email { get; set; }
        [Required]
        public string comments { get; set; }
    }
}