<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:tns="http://tempuri.org/"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:ns0="http://touresbalon.com.co/email/service/utility/1.0.0"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                exclude-result-prefixes="xsd xsi oracle-xsl-mapper xsl ns0 tns oraxsl xp20 xref mhdr oraext dvm socket"
                xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                xmlns:ns1="http://schemas.datacontract.org/2004/07/Email_Services.microsoft.co.com.touresbalon.foundation.email.entity">

    <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
    <xsl:template match="/">
        <tns:sendMailToCustomer>
            <tns:email>
                <ns1:Id>
                    <xsl:value-of select="/ns0:SendEmail/ns0:Id"/>
                </ns1:Id>
                <ns1:body>
                    <xsl:value-of select="/ns0:SendEmail/ns0:body"/>
                </ns1:body>
                <ns1:email>
                    <xsl:value-of select="/ns0:SendEmail/ns0:email"/>
                </ns1:email>
                <ns1:first_name>
                    <xsl:value-of select="/ns0:SendEmail/ns0:first_name"/>
                </ns1:first_name>
                <ns1:footer>
                    <xsl:value-of select="/ns0:SendEmail/ns0:footer"/>
                </ns1:footer>
                <ns1:last_name>
                    <xsl:value-of select="/ns0:SendEmail/ns0:last_name"/>
                </ns1:last_name>
                <ns1:messageSend>
                    <xsl:value-of select="/ns0:SendEmail/ns0:messageSend"/>
                </ns1:messageSend>
                <ns1:subject>
                    <xsl:value-of select="/ns0:SendEmail/ns0:subject"/>
                </ns1:subject>
            </tns:email>
        </tns:sendMailToCustomer>
    </xsl:template>
</xsl:stylesheet>
