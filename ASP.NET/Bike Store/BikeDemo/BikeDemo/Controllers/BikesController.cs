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
    public class BikesController : Controller
    {
        private BikeEntities db = new BikeEntities();

        // GET: Bikes
        public ActionResult Index()
        {
            var productCategories = from p in db.ProductCategories
                                    where p.ParentProductCategoryID == 1
                                    select p;
            
            return View(productCategories.ToList());
        }

        // GET: Bikes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var productCategory = from b in db.Products
                                  where b.ProductModelID == id
                                  select b;
            if (productCategory == null)
            {
                return HttpNotFound();
            }

            var rev = from r in db.ProductReviews
                      where r.productID == id
                      select r;

            List<ProductReview> reviews = new List<ProductReview>();

            foreach (var review in rev)            
                reviews.Add(review);

            ViewBag.review = reviews;

            return View(productCategory.ToList());
        }

        // GET: Bikes/Create
        public ActionResult Create()
        {
            ViewBag.ParentProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name");
            return View();
        }

        // POST: Bikes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ProductCategoryID,ParentProductCategoryID,Name,rowguid,ModifiedDate")] ProductCategory productCategory)
        {
            if (ModelState.IsValid)
            {
                db.ProductCategories.Add(productCategory);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            ViewBag.ParentProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", productCategory.ParentProductCategoryID);
            return View(productCategory);
        }

        // GET: Bikes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProductCategory productCategory = db.ProductCategories.Find(id);
            if (productCategory == null)
            {
                return HttpNotFound();
            }
            ViewBag.ParentProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", productCategory.ParentProductCategoryID);
            return View(productCategory);
        }

        // POST: Bikes/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ProductCategoryID,ParentProductCategoryID,Name,rowguid,ModifiedDate")] ProductCategory productCategory)
        {
            if (ModelState.IsValid)
            {
                db.Entry(productCategory).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ParentProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", productCategory.ParentProductCategoryID);
            return View(productCategory);
        }

        // GET: Bikes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            ProductCategory productCategory = db.ProductCategories.Find(id);
            if (productCategory == null)
            {
                return HttpNotFound();
            }
            return View(productCategory);
        }

        // POST: Bikes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            ProductCategory productCategory = db.ProductCategories.Find(id);
            db.ProductCategories.Remove(productCategory);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        public ActionResult Road()
        {

            return GetByType(6);
        }

        public ActionResult Touring()
        {

            return GetByType(7);

        }

        public ActionResult Mountain()
        {

            return GetByType(5);
        }
       
        public ActionResult GetByType(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }

            var roadQuery = (from p in db.vProductAndDescriptions
                             where p.ProductCategoryID == id && p.SellEndDate == null && p.Culture == "en"
                             select new { p.ProductModel, p.Description, p.ProductModelID }).Distinct();
            List<BikeListModel> list = new List<BikeListModel>();
            foreach (var d in roadQuery)
                list.Add(new BikeListModel(d.ProductModel, d.Description, d.ProductModelID));

            return View(list);
        }


    }

}
