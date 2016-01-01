using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CaptchaMvc.HtmlHelpers;
using System.Net.Mail;
using System.Net;


namespace BikeDemo.Controllers
{
    public class HomeController : Controller
    {
        private BikeEntities db = new BikeEntities();
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Success()
        {
            return View();
        }

        public ActionResult Error()
        {
            return View();
        }
        public ActionResult About()
        {
            return View();
        }

        public ActionResult Contact()
        {
            return View();
        }

        // GET: Manager 
        public ActionResult ManagerCreate()
        {
            return View();
        }

        // GET: Manager Recover
        public ActionResult ManagerRecover()
        {
            return View();
        }

        //POST: Manger Recover
        [HttpPost]
        public ActionResult ManagerRecover([Bind(Include = "Email")] string email)
        {
            if (ModelState.IsValid)
            {
                string conf = "";
                var query = from m in db.Managers
                            where m.Email == email
                            select m;

                if (query.Any())
                {
                    foreach (Manager man in query)
                        conf = man.ConfCode.ToString();
                    MailAddress to = new MailAddress(email);
                    string body = "A request to reset your password has been sent. If this was you click the link below.\n If this was not done by you, ignore this email.\n http://localhost:16700/Home/PasswordReset/?conf=" + conf;
                    string subject = "Password Reset - DO NOT REPLY";
                    MailAddress replyToEmail = new MailAddress("compscimilestone@gmail.com");

                    sendEmail(to, body, subject, replyToEmail);

                    TempData["message"] = "Email has been sent to " + email;
                }
                else
                    TempData["message"] = "User does not exist";
            }
            ViewBag.email = email;
            return View();
        }

        public ActionResult PasswordReset()
        {
            return View();
        }

        [HttpPost]
        public ActionResult PasswordReset([Bind(Include = "Password")] string pass)
        {
            if (ModelState.IsValid)
            {
                string conf = Request.QueryString["conf"];

                var query = from m in db.Managers
                            where m.ConfCode.ToString() == conf
                            select m;

                if (query.Any())
                {
                    foreach (Manager man in query)
                        man.Password = pass;

                    try
                    {
                        db.SaveChanges();
                    }
                    catch (Exception)
                    {
                        TempData["error"] = "An error has occured. Please try again later";
                    }
                }
                else
                    TempData["message"] = "User does not exist";
            }
            return View();
        }

        public ActionResult ValidateEmail()
        {
            string conf = Request.QueryString["conf"];

            var query = from r in db.Managers
                      where r.ConfCode.ToString() == conf
                      select r;

            if (query.Any())
            {
                foreach (Manager manager in query)
                    manager.Confirmed = 1;

                try
                {
                    db.SaveChanges();
                }
                catch(Exception)
                {
                    TempData["error"] = "An error has occured. Please try again later.";
                }
            }
            else
                TempData["error"] = "An error has occured. Please try again later.";

            return View();
        }

        // GET: Manager Login
        public ActionResult ManagerLogin()
        {
            return View();
        }

        public ActionResult ManagerLogout()
        {
            Session.Abandon();

            return RedirectToAction("Index");
        }

        //POST: Manager Login
        [HttpPost]
        public ActionResult ManagerLogin([Bind(Include = "Email, Password")] Manager man)
        {
            if (ModelState.IsValid)
            {
                var query = from m in db.Managers
                            where m.Email == man.Email && m.Password == man.Password
                            select m;

                if (query.Any())
                {
                    Session["loggedIn"] = true;
                    Session["email"] = man.Email;

                   return RedirectToAction("Index");
                }
            }
            return View();
        }

        // POST: Manager Create
        [HttpPost]
        public ActionResult ManagerCreate([Bind(Include = "Email, Password")] Manager man)
        {
            if (ModelState.IsValid)
            {
                man.ConfCode = Guid.NewGuid();
                db.Managers.Add(man);
                db.SaveChanges();

                string body = "Please confirm your email by clicking the following link: http://localhost:16700/Home/ValidateEmail/?conf=" + man.ConfCode;
                MailAddress email = new MailAddress(man.Email);
                MailAddress replyToEmail = new MailAddress("compscimilestone@gmail.com");
                string subject = "Validate Email -  DO NOT REPLY";

                sendEmail(email, body, subject, replyToEmail);
            }
            return View();
        }

        public ActionResult Search(string filters)
        {
            string s = filters;
            // Split string on spaces.
            // ... This will separate all the words.
            string[] fwords = s.Split(' ');
            string single = fwords[0];
            
            //var pquery = db.Products
            //    .Where(p => p.Name
             //                .Contains(fwords[0]));



            //var products = from b in pquery select b;

            var products = from c in db.Products
                         where c.Name.IndexOf(single) >= 0
                         select c;

            return View(products.ToList());
        }

       
        [HttpPost]

        public ActionResult Contact(string empty, BikeDemo.Models.ContactModel CM)
        {
            if (this.IsCaptchaValid("Captcha is not valid"))
            {
                try
                {
                    MailAddress email = new MailAddress(CM.email, CM.fName + " " + CM.lName);
                    string body = "First name: " + CM.fName + "\n" + "Last Name: " + CM.lName + "\n" + "Email: " + CM.email
                        + "\n" + "Comment: " + CM.comments;
                    string subject = "Hello There";
                    MailAddress replyToEmail = email;

                    sendEmail(email, body, subject, replyToEmail);

                    return RedirectToAction("Success");
                }
                catch (Exception)
                {
                    return RedirectToAction("Error");
                }

            }

            TempData["ErrorMessage"] = "Error: captcha is not valid.";
            return View();

        }

        public void sendEmail(MailAddress email, string body, string subject, MailAddress replyToEmail)
        {
            MailMessage msg = new MailMessage();
            SmtpClient smtp = new SmtpClient();
            //TODO: Setup Message
            //Add a Reply-to the message having the inputted user's email

            msg.From = new MailAddress("compscimilestone@gmail.com", "Administrator");
            msg.To.Add(email);
            msg.Subject = subject;
            msg.Body = body;
            msg.ReplyToList.Add(replyToEmail);

            smtp.Host = "smtp.gmail.com";
            smtp.Port = 587;
            smtp.EnableSsl = true;
            smtp.DeliveryMethod = SmtpDeliveryMethod.Network;
            smtp.Credentials = new NetworkCredential("compscimilestone@gmail.com", "somepassword");
            smtp.Send(msg);
            msg.Dispose();
        }
    }
}