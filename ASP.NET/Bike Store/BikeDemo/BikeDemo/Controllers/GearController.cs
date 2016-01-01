using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using BikeDemo;
using BikeDemo.Models;

namespace BikeDemo.Controllers
{
    public class GearController : Controller
    {
        private BikeEntities db = new BikeEntities();


        public ActionResult Index()
        {
            var productCategories = from p in db.ProductCategories
                                    where p.ProductCategoryID >= 2 && p.ProductCategoryID <=4 
                                    select p;

            return View(productCategories.ToList());
        }

        public ActionResult ProductList(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var productCategory = from b in db.Products
                                  where b.ProductCategoryID == id && b.SellEndDate == null
                                  select b;
            if (productCategory == null)
            {
                return HttpNotFound();
            }
            return View(productCategory.ToList());
        }

        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Product product = db.Products.Find(id);
            if (product == null)
            {
                return HttpNotFound();
            }
            return View(product);
        }

        public ActionResult Components()
        {
            return GetByType(2);
        }

        public ActionResult Clothing()
        {

            return GetByType(3);
        }

        public ActionResult Accessories()
        {
            return GetByType(4);
        }

        public ActionResult GetByType(int? id)
        {
            var gear = from a in db.ProductCategories
                       where (from o in db.Products where o.SellEndDate == null select o.ProductCategoryID).Contains(a.ProductCategoryID)
                       && a.ParentProductCategoryID == id
                       select a;
            return View(gear.ToList());
        }










    }


}