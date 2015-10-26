<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/createCustomer/customer">
        <createUserLdap>
            <user>
                <email><xsl:value-of select="email"/></email>
                <lastName><xsl:value-of select="last_name"/></lastName>
                <password><xsl:value-of select="password"/></password>
                <userGroup>1</userGroup>
                <userId><xsl:value-of select="Id"/></userId>
                <userName><xsl:value-of select="first_name"/></userName>
            </user>
        </createUserLdap>
    </xsl:template>

</xsl:stylesheet>