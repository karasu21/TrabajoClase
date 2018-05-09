<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <html>
  <head>
  <style>

table { border: 1px solid black;
          width: auto;
          height: auto;
}
td { border: 1px solid black;
    
     }
thead{background-color:#987ca7;
          text-align: center;
          font-weight: bold;
}
  </style>
  </head>
  <body>
  <table>
  <thead>
  <tr>
  <td >
  Titulo
  </td>
  <td>
  Artista
  </td>
  <td>
  Sello
  </td>
  <td>
  Año
  </td>
  <td>
  Canciones
  </td>
  </tr>
  </thead>
  <xsl:for-each select="//cd[artista='Jon Bon Jovi']">
    <tr>
  <td >
  <xsl:value-of select="titulo"/>
  </td>
  <td>
  <xsl:value-of select="artista"/>
  </td>
  <td>
  <xsl:value-of select="sello"/>
  </td>
  <td>
  <xsl:value-of select="anyo"/>
  </td>
 
  <td>
   <xsl:for-each select="./cancion">
  <xsl:value-of select="cancion"/>
    <br></br>
    </xsl:for-each>
  </td>
  </tr>
  </xsl:for-each>
  </table>
  </body>
  </html>
  </xsl:template>

</xsl:stylesheet>
