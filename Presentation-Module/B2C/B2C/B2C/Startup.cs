using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(B2C.Startup))]
namespace B2C
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
