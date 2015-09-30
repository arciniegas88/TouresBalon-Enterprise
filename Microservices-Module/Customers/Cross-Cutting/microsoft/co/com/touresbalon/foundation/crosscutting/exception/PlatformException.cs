using System;

namespace Cross_Cutting.microsoft.co.com.touresbalon.foundation.crosscutting.exception
{
    public class PlatformException : Exception
    {
        public PlatformException(string message) : base(message) { }

        public PlatformException(string message, Exception innerExceltion) : base (message, innerExceltion) { }
    }
}
