<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="/">
 
<html>
<head>
<title>Ejemplo XSLT</title>
<style>
h1 {text-align: center;}
.negrita{font-weight: bold;}
table { text-align: center;
          border: 1px solid black;
          margin-left:auto; 
          margin-right:auto;
          width: auto;
          height: auto;
}
td { border: 1px solid black;
     }

.amarillo {
background-color: yellow;
}
.azul {
background-color: #99ccff;}
}




</style>
</head>
<body>
<h1>Listado de Notas</h1>
<table>
<thead class="azul">
<tr>
<td colspan="3">
Alumno
</td>
<td colspan="3">
NOTAS
</td>

</tr>
</thead>
<thead class="amarillo">
<tr>
<td>
Nombre
</td>
<td>
Apellidos
</td>
<td>
Matricula
</td>
<td>
Teoria
</td>
<td>
Practica
</td>
<td>
Final
</td>
</tr>
</thead>
<xsl:for-each select="notas/alumno">
 <xsl:sort select="nombre" order="ascending" />
<tr>
<td>
<xsl:value-of select="nombre"/>
</td>
<td>
<xsl:value-of select="apellidos"/>
</td>
<td>
<xsl:value-of select="num-matricula"/>
</td>
<td>
<xsl:value-of select="nota-teoria"/>
</td>
<td>
<xsl:value-of select="nota-practica"/>
</td>
<td>
<span class="negrita"><xsl:value-of select="nota-final"/></span>
</td>
</tr>
</xsl:for-each>
</table>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
