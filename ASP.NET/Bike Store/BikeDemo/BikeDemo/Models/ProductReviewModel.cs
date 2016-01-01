using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace BikeDemo.Models
{
    public class ProductReviewModel
    {
        public string email { get; set; }
        public string comment { get; set; }
        public int rating { get; set; }
        public int productID { get; set; }
    }
}