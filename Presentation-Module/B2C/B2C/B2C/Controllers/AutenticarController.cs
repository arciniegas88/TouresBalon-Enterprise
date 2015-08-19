using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
using B2C.Forms;
using B2C.Facades;
using B2C.Entities;
using B2C.Handlers;

namespace B2C.Controllers
{
    public class AutenticarController : Controller
    {
        
        [HttpPost]
        [AllowAnonymous]
        [ValidateAntiForgeryToken]
        public async Task<ActionResult> Login(LoginForm form, string returnUrl)
        {
            if (!ModelState.IsValid)
            {
                return View(form);
            }
            else
            {
                User user = SecurityFacade.Instance.getLoginUser(form.Email, form.Password);
                if( user != null && user.UserID != 0)
                {
                    HandlerSession.setUser(user);
                }
            }

            return RedirectToLocal(returnUrl);

            //return RedirectToAction("SendCode", new { ReturnUrl = returnUrl, RememberMe = model.RememberMe });
            /*
            // This doesn't count login failures towards account lockout
            // To enable password failures to trigger account lockout, change to shouldLockout: true
            var result = await SignInManager.PasswordSignInAsync(model.Email, model.Password, model.RememberMe, shouldLockout: false);
            switch (result)
            {
                case SignInStatus.Success:
                    return RedirectToLocal(returnUrl);
                case SignInStatus.LockedOut:
                    return View("Lockout");
                case SignInStatus.RequiresVerification:
                    return RedirectToAction("SendCode", new { ReturnUrl = returnUrl, RememberMe = model.RememberMe });
                case SignInStatus.Failure:
                default:
                    ModelState.AddModelError("", "Invalid login attempt.");
                    return View(model);
            }*/
        }

        public ActionResult Register()
        {
            return View();
        }

        public ActionResult Logout()
        {
            HandlerSession.destroy();
            return RedirectToAction("Index", "Home");
        }

        private ActionResult RedirectToLocal(string returnUrl)
        {
            if (Url.IsLocalUrl(returnUrl))
            {
                return Redirect(returnUrl);
            }
            return RedirectToAction("Index", "Home");
        }
    }
}