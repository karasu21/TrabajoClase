<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
 <xsl:template match="/">
   <html>
 
<head>
<title>Ejemplo XSLT</title>
<style>
table { text-align: center;
          border: 1px solid black;
          margin-left:auto; 
          margin-right:auto;
          width: auto;
          height: auto;
}
td { border: 1px solid black;
     }
.azul {
background-color: #99ccff;}
}

</style>
</head>
<body>
  <table>
    <thead class="azul">
      <tr>
        <td >
          ISBN
        </td>
        <td>
          Titulo
          </td>
         <td>
          Autor
        </td>
         <td>
          Precio
        </td>
      </tr>
    </thead>
<xsl:for-each select="libreria/libro">
  <xsl:sort select="precio" data-type="number" order="ascending" />
<xsl:if test="starts-with(titulo,'P')">
<tr>
<td>
<xsl:value-of select="isbn"/>
</td>
<td>
<xsl:value-of select="titulo"/>
</td>
<td>
<xsl:value-of select="autor"/>
</td>
<td>
<xsl:value-of select="precio"/>
</td>
</tr>
</xsl:if>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>