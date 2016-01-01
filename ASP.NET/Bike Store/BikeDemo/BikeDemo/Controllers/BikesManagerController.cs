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
    public class BikesManagerController : Controller
    {
        private BikeEntities db = new BikeEntities();

        // GET: BikesManager
        public ActionResult Index()
        {
         //   var products = db.Products.Include(p => p.ProductCategory).Include(p => p.ProductModel);

            var products = from b in db.Products
                           where b.ProductCategoryID > 4 && b.ProductCategoryID < 8
                           select b;

            return View(products.ToList());
        }

        // GET: BikesManager/Details/5
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

        // GET: BikesManager/Create
        public ActionResult Create()
        {
            var query = from p in db.ProductCategories
                                    where p.ParentProductCategoryID == 1
                                    select p;

            var prodCatList = new SelectList(query, "ProductCategoryID", "Name");
            ViewBag.ProductCategoryID = prodCatList;
          // ViewBag.ProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name");

          
            var roadQuery = (from p in db.vProductAndDescriptions
                             where (p.ProductCategoryID == 5 || p.ProductCategoryID == 6
                             || p.ProductCategoryID == 7) && p.SellEndDate == null && p.Culture == "en"
                             select new { p.ProductModel, p.Description, p.ProductModelID }).Distinct();
            List<BikeListModel> list = new List<BikeListModel>();
            foreach (var d in roadQuery)
                list.Add(new BikeListModel(d.ProductModel, d.Description, d.ProductModelID));

            var prodModelList = new SelectList(list, "ProductModelID", "ProductModel");
            ViewBag.ProductModelID = prodModelList;
           // ViewBag.ProductModelID = new SelectList(db.ProductModels, "ProductModelID", "Name");


            return View();
        }

        // POST: BikesManager/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ProductID,Name,ProductNumber,Color,StandardCost,ListPrice,Size,Weight,ProductCategoryID,ProductModelID,SellStartDate,SellEndDate,DiscontinuedDate,ThumbNailPhoto,ThumbnailPhotoFileName,rowguid,ModifiedDate")] Product product)
        {
            bool productNameExists = db.Products.Any(productname => productname.Name.Equals(product.Name));
            bool productNumberExists = db.Products.Any(productnumber => productnumber.ProductNumber.Equals(product.ProductNumber));

            if (ModelState.IsValid)
            {
                if (product.ListPrice >= product.StandardCost)
                {
                    if (!productNameExists)
                    {
                        if (!productNumberExists)
                        { 
                            product.ModifiedDate = System.DateTime.Now;
                            product.rowguid = Guid.NewGuid();
                            db.Products.Add(product);
                            db.SaveChanges();
                            return RedirectToAction("Index");
                        }
                    }
                }
             
            }

            var query = from p in db.ProductCategories
                        where p.ParentProductCategoryID == 1
                        select p;

            var prodCatList = new SelectList(query, "ProductCategoryID", "Name", product.ProductCategoryID);
           
           


            var roadQuery = (from p in db.vProductAndDescriptions
                             where (p.ProductCategoryID == 5 || p.ProductCategoryID == 6
                             || p.ProductCategoryID == 7) && p.SellEndDate == null && p.Culture == "en"
                             select new { p.ProductModel, p.Description, p.ProductModelID }).Distinct();
            List<BikeListModel> list = new List<BikeListModel>();
            foreach (var d in roadQuery)
                list.Add(new BikeListModel(d.ProductModel, d.Description, d.ProductModelID));

            var prodModelList = new SelectList(list, "ProductModelID", "ProductModel", product.ProductModelID);

            if (productNameExists)
                ViewBag.NonUniqueName = "Product name already exists. Must be unique";

            if (productNumberExists)
                ViewBag.NonUniqueNumber = "Product number already exists. Must be unique";
          
            if(product.ListPrice <= product.StandardCost)
                ViewBag.ListPriceError = "List price must be greater than the standard cost";

            ViewBag.ProductModelID = prodModelList;
            ViewBag.ProductCategoryID = prodCatList;

           // ViewBag.ProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", product.ProductCategoryID);
           // ViewBag.ProductModelID = new SelectList(db.ProductModels, "ProductModelID", "Name", product.ProductModelID);
            return View(product);
        }


        // GET: BikesManager/Edit/5
        public ActionResult Edit(int? id)
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
            ViewBag.ProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", product.ProductCategoryID);
            ViewBag.ProductModelID = new SelectList(db.ProductModels, "ProductModelID", "Name", product.ProductModelID);
            return View(product);
        }

        // POST: BikesManager/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ProductID,Name,ProductNumber,Color,StandardCost,ListPrice,Size,Weight,ProductCategoryID,ProductModelID,SellStartDate,SellEndDate,DiscontinuedDate,ThumbNailPhoto,ThumbnailPhotoFileName,rowguid,ModifiedDate")] Product product)
        {
            if (ModelState.IsValid)
            {
                db.Entry(product).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.ProductCategoryID = new SelectList(db.ProductCategories, "ProductCategoryID", "Name", product.ProductCategoryID);
            ViewBag.ProductModelID = new SelectList(db.ProductModels, "ProductModelID", "Name", product.ProductModelID);
            return View(product);
        }

        // GET: BikesManager/Delete/5
        public ActionResult Delete(int? id)
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

        // POST: BikesManager/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Product product = db.Products.Find(id);
            db.Products.Remove(product);
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
    }
}
