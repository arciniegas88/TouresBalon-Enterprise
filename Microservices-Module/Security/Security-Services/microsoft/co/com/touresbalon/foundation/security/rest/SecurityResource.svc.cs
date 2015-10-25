using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.entity;
using Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception;
using Security_Services.microsoft.co.com.touresbalon.foundation.security.boundary;
using Security_Services.microsoft.co.com.touresbalon.foundation.security.dto;
using System.Net;
using System.ServiceModel.Web;

namespace Security_Services.microsoft.co.com.touresbalon.foundation.security.rest
{
    public class SecurityResource : ISecurityResource
    {
        private SecurityBoundary securityBoundary;

        public User authenticationResource(string email, string password)
        {
            securityBoundary = new SecurityBoundary();
            try
            {
                return securityBoundary.authenticateBoundary(email, password);
            }
            catch (BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "400"
                    }, HttpStatusCode.BadRequest);
            }
            catch (PlatformException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "500"
                    }, HttpStatusCode.BadRequest);
            }
        }

        public string createUserLdap(User user)
        {
            securityBoundary = new SecurityBoundary();
            try
            {
                return securityBoundary.createUserLdap(user);
            }
            catch (BusinessException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "400"
                    }, HttpStatusCode.BadRequest);
            }
            catch (PlatformException e)
            {
                throw new WebFaultException<GeneralResponse>
                    (new GeneralResponse
                    {
                        message = e.Message,
                        status = GeneralResponse.STATUS_ERROR,
                        code = "500"
                    }, HttpStatusCode.BadRequest);
            }
        }
    }
}
