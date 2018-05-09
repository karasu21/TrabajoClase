<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:template match="//nombre"> 
<html>
<body>
<h2><xsl:value-of select="."/></h2>
</body>
</html>
</xsl:template>
</xsl:stylesheet>
