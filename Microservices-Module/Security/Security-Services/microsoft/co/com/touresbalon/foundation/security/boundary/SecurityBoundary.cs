using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Security_Services.microsoft.co.com.touresbalon.foundation.security.dto;
using System;
using System.Configuration;
using System.DirectoryServices.Protocols;
using System.Net;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.boundary
{
    public class SecurityBoundary
    {
        private readonly static string HOST = ConfigurationManager.AppSettings["ldapIp"];
        private readonly static int PORT = Int32.Parse(ConfigurationManager.AppSettings["ldapPort"]);
        private readonly static string DN = ConfigurationManager.AppSettings["ldapDn"];
        private readonly static string ADMIN = ConfigurationManager.AppSettings["ldapAdmin"];
        private readonly static string ADMIN_PASS = ConfigurationManager.AppSettings["ldapAdminPass"];
        private readonly static string DN_CREATE = ConfigurationManager.AppSettings["ldapDnCreate"];

        private LdapDirectoryIdentifier ldapId;
        private NetworkCredential network;

        public User authenticateBoundary(string email, string password)
        {
            ldapId = new LdapDirectoryIdentifier(HOST, PORT);
            network = new NetworkCredential(DN.Replace("{0}", email), password);

            using (LdapConnection connection = new LdapConnection(ldapId, network, AuthType.Basic))
            {
                try
                {
                    connection.SessionOptions.SecureSocketLayer = false;
                    connection.SessionOptions.ProtocolVersion = 3;
                    connection.Bind();

                    connection.Dispose();
                    
                    return queryLdap(email);
                }
                catch (LdapException ex)
                {
                    throw new BusinessException(ex.Message);
                }
                catch (Exception e)
                {
                    throw new PlatformException(e.Message);
                }
            }
        }

        private User queryLdap(string email)
        {
            string ldapFilter = "(objectClass=person)";
            string ldapTarget = DN.Replace("{0}", email);
            User user = new User();

            network = new NetworkCredential(ADMIN, ADMIN_PASS);
            ldapId = new LdapDirectoryIdentifier(HOST, PORT);
           
            using (LdapConnection connection = new LdapConnection(ldapId, network, AuthType.Basic))
            {
                try
                {
                    connection.SessionOptions.SecureSocketLayer = false;
                    connection.SessionOptions.ProtocolVersion = 3;
                    connection.Bind();

                    SearchRequest searchRequest = new SearchRequest(ldapTarget, ldapFilter, SearchScope.Subtree, "*");
                    SearchResponse searchResponse = (SearchResponse)connection.SendRequest(searchRequest);
                    SearchResultEntry entry = searchResponse.Entries[0];

                    user.email = email;
                    user.userId = entry.Attributes["employeeNumber"][0].ToString();
                    user.userName = entry.Attributes["cn"][0].ToString();
                    user.lastName = entry.Attributes["sn"][0].ToString();
                    user.userGroup = entry.Attributes["departmentNumber"][0].ToString();

                    connection.Dispose();

                    return user;
                }
                catch (LdapException ex)
                {
                    throw new BusinessException(ex.Message);
                }
                catch (Exception e)
                {
                    throw new PlatformException(e.Message);
                }
            }
        }

        public string createUserLdap(User user)
        {
            ldapId = new LdapDirectoryIdentifier(HOST, PORT);
            network = new NetworkCredential(ADMIN, ADMIN_PASS);

            using (LdapConnection connection = new LdapConnection(ldapId, network, AuthType.Basic))
            {
                try
                {
                    string[] objectClass = new string[] { "top", "inetOrgPerson", "organizationalPerson", "person" };

                    connection.SessionOptions.SecureSocketLayer = false;
                    connection.SessionOptions.ProtocolVersion = 3;

                    String dn = DN_CREATE.Replace("{0}", user.email);

                    DirectoryAttributeCollection collection = new DirectoryAttributeCollection() {
                        new DirectoryAttribute("objectclass", objectClass),
                        new DirectoryAttribute("uid",user.email),
                        new DirectoryAttribute("sn", user.lastName),
                        new DirectoryAttribute("cn", user.userName),
                        new DirectoryAttribute("employeeNumber", user.userId),
                        new DirectoryAttribute("departmentNumber", user.userGroup),
                        new DirectoryAttribute("userPassword", user.password)
                    };

                    AddRequest addMe = new AddRequest(dn, "inetOrgPerson");
                    addMe.Attributes.AddRange(collection);

                    connection.Bind();
                    connection.SendRequest(addMe);

                    return "OK";

                }
                catch (LdapException ex)
                {
                    throw new BusinessException("Ldap error: " + ex.Message);
                }
                catch (Exception e)
                {
                    throw new PlatformException("Ldap error: " + e.Message);
                }
            }
        }
    }
}