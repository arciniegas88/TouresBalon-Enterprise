using NHibernate;
using NHibernate.Cfg;
using System.Reflection;

namespace Customer_Services.microsoft.co.com.touresbalon.foundation.customer.entity.manager
{
    public class SessionManager
    {
        private static ISessionFactory sessionFactory;

        private static ISessionFactory getSessionFactory
        {
            get
            {
                if(sessionFactory == null)
                {
                    var configuration = new Configuration();
                    configuration.Configure();
                    configuration.AddAssembly(Assembly.GetCallingAssembly());
                    sessionFactory = configuration.BuildSessionFactory();
                }
                return sessionFactory;
            }
        }

        public static ISession openSession()
        {
            return getSessionFactory.OpenSession();
        }
    }
}