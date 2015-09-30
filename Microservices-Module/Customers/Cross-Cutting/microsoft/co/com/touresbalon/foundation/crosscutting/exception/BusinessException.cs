using System;

namespace Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception
{
    public class BusinessException : Exception
    {
        public BusinessException(string message) : base(message) { }

        public BusinessException(string message, Exception innerException) { }
    }
}
