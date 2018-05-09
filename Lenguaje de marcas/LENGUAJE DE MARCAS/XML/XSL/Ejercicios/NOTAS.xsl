<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
<html>
<head>
<title>Ejemplo XSLT</title>
<style>
body {text-align: center;}
.negrita{font-weight: bold;}
</style>
</head>
<body>
<h1>Listado de Notas</h1>
<hr></hr>
<xsl:apply-templates select="//alumno"/>
<hr></hr>
</body>
</html>
</xsl:template>



<xsl:template match="alumno">
<div><span class="negrita">Nombre y Apellidos: </span><xsl:value-of select="./nombre"/>, <xsl:value-of select="./apellidos"/></div>
<br></br>
<div><span class="negrita">Notas:  </span><xsl:value-of select="./nota-teoria"/> - - - <xsl:value-of select="./nota-practica"/> - - - <span class="negrita"><xsl:value-of select="./nota-final"/></span></div>
<br></br>
</xsl:template>
</xsl:stylesheet>
