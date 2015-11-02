<%@ page import="org.apache.axiom.om.OMElement" %>
<%@ page import="javax.xml.namespace.QName" %>
<p>
        <%
        String custDocumentNumber = "";
        String custDocumentType = "";
        String customerType = "";
        String custom ="";

        OMElement requestElement = (OMElement) request.getAttribute("taskInput");
        String ns = "http://touresbalon.com.co/salesorder/schema/utility/1.0.0";

        if (requestElement != null) {
            OMElement orderElement = requestElement.getFirstChildWithName(new QName(ns, "order"));

            if (orderElement != null) {
                OMElement p1 = orderElement.getFirstChildWithName(new QName(ns, "custDocumentNumber"));
                if (p1 != null) {
                    custDocumentNumber = p1.getText();
                }

                OMElement p2 = orderElement.getFirstChildWithName(new QName(ns, "custDocumentType"));
                if(p2 != null){
                    custDocumentType = p2.getText();
                }

                OMElement p3 = orderElement.getFirstChildWithName(new QName(ns, "customerType"));
                if(p3 != null){
                    customerType = p3.getText();
                }

                OMElement p4 = orderElement.getFirstChildWithName(new QName(ns, "custom"));
                if(p4 != null){
                    custom = p4.getText();
                }


            }
        }
    %>

<table border="0">
    <tr>
        <td>Customer doc number</td>
        <td><%=custDocumentNumber%>
        </td>
    </tr>
    <tr>
        <td>Customer doc type</td>
        <td><%=custDocumentType%>
        </td>
    </tr>
    <tr>
        <td>Customer Type</td>
        <td><%=customerType%>
        </td>
    </tr>
    <tr>
        <td>Details</td>
        <td><%=custom%>
        </td>
    </tr>
</table>

</p>
