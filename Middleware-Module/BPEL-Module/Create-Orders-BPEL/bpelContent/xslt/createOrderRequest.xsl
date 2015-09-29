<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xp20="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.Xpath20"
                xmlns:oraxsl="http://www.oracle.com/XSL/Transform/java"
                xmlns:mhdr="http://www.oracle.com/XSL/Transform/java/oracle.tip.mediator.service.common.functions.MediatorExtnFunction"
                xmlns:oraext="http://www.oracle.com/XSL/Transform/java/oracle.tip.pc.services.functions.ExtFunc"
                xmlns:tns="http://touresbalon.com.co/salesorder/service/task/1.0.0"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xmlns:oracle-xsl-mapper="http://www.oracle.com/xsl/mapper/schemas"
                xmlns:dvm="http://www.oracle.com/XSL/Transform/java/oracle.tip.dvm.LookupValue"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xref="http://www.oracle.com/XSL/Transform/java/oracle.tip.xref.xpath.XRefXPathFunctions"
                xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:ns0="http://touresbalon.com.co/model/canonical/1.0.0"
                xmlns:socket="http://www.oracle.com/XSL/Transform/java/oracle.tip.adapter.socket.ProtocolTranslator"
                exclude-result-prefixes="xsi oracle-xsl-mapper xsl xsd ns0 tns xp20 oraxsl mhdr oraext dvm xref socket"
                xmlns:ns1="http://schemas.xmlsoap.org/soap/http" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
                xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <oracle-xsl-mapper:schema>
    <!--SPECIFICATION OF MAP SOURCES AND TARGETS, DO NOT MODIFY.-->
    <oracle-xsl-mapper:mapSources>
      <oracle-xsl-mapper:source type="WSDL">
        <oracle-xsl-mapper:schema location="../WSDLs/canonical_schema.xsd"/>
        <oracle-xsl-mapper:rootElement name="CreateSalesOrderRequest"
                                       namespace="http://touresbalon.com.co/model/canonical/1.0.0"/>
      </oracle-xsl-mapper:source>
    </oracle-xsl-mapper:mapSources>
    <oracle-xsl-mapper:mapTargets>
      <oracle-xsl-mapper:target type="WSDL">
        <oracle-xsl-mapper:schema location="../WSDLs/SalesOrderWS.wsdl"/>
        <oracle-xsl-mapper:rootElement name="createSalesOrder"
                                       namespace="http://touresbalon.com.co/salesorder/service/task/1.0.0"/>
      </oracle-xsl-mapper:target>
    </oracle-xsl-mapper:mapTargets>
    <!--GENERATED BY ORACLE XSL MAPPER 12.1.3.0.0(XSLT Build 140529.0700.0211) AT [TUE SEP 29 09:36:27 COT 2015].-->
  </oracle-xsl-mapper:schema>
  <!--User Editing allowed BELOW this line - DO NOT DELETE THIS LINE-->
  <xsl:template match="/">
    <tns:createSalesOrder>
      <order>
        <comments>
          <xsl:value-of select="/ns0:CreateSalesOrderRequest/order/comments"/>
        </comments>
        <custDocumentNumber>
          <xsl:value-of select="/ns0:CreateSalesOrderRequest/order/custDocumentNumber"/>
        </custDocumentNumber>
        <custDocumentType>
          <xsl:value-of select="/ns0:CreateSalesOrderRequest/order/custDocumentType"/>
        </custDocumentType>
      </order>
      <xsl:for-each select="/ns0:CreateSalesOrderRequest/order/items">
        <items>
          <price>
            <xsl:value-of select="price"/>
          </price>
          <productId>
            <xsl:value-of select="productId"/>
          </productId>
          <productName>
            <xsl:value-of select="productName"/>
          </productName>
          <status>ENTERED</status>
        </items>
      </xsl:for-each>
    </tns:createSalesOrder>
  </xsl:template>
</xsl:stylesheet>