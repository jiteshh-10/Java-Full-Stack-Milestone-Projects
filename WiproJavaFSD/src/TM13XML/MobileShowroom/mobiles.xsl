<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>Mobile Phone Sales Summary</title>
                <style>
                    body { font-family: Arial, sans-serif; }
                    table { width: 80%; margin: 20px auto; border-collapse: collapse; border: 1px solid #000; }
                    th, td { border: 1px solid #000; padding: 8px; text-align: left; }
                    th { background-color: #007bff; color: white; }
                    h2 { text-align: center; }
                </style>
            </head>
            <body>
                <h2>Mobile Phone Sales Summary</h2>
                <table>
                    <thead>
                        <tr>
                            <th>ModelID</th>
                            <th>Brand</th>
                            <th>Price</th>
                            <th>Color</th>
                            <th>SIM Size</th>
                            <th>Memory</th>
                            <th>Camera</th>
                            <th>Touch Screen</th>
                            <th>Number Sold</th>
                            <th>Store Name</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="MobileSales/Mobile">
                            <tr>
                                <td><xsl:value-of select="ModelID"/></td>
                                <td><xsl:value-of select="Brand"/></td>
                                <td><xsl:value-of select="Price"/></td>
                                <td><xsl:value-of select="Color"/></td>
                                <td><xsl:value-of select="SIMSize"/></td>
                                <td><xsl:value-of select="Memory"/></td>
                                <td><xsl:value-of select="Camera"/></td>
                                <td><xsl:value-of select="TouchScreen"/></td>

                                <xsl:choose>
                                    <xsl:when test="NoSold > 10">
                                        <td style="background-color:red; color:white;">
                                            <xsl:value-of select="NoSold"/>
                                        </td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td>
                                            <xsl:value-of select="NoSold"/>
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>

                                <xsl:choose>
                                    <xsl:when test="NoSold > 10">
                                        <td style="background-color:red; color:white;">
                                            <xsl:value-of select="storeName"/>
                                        </td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td>
                                            <xsl:value-of select="storeName"/>
                                        </td>
                                    </xsl:otherwise>
                                </xsl:choose>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>