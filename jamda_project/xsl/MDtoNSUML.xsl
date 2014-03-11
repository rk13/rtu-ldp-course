<?xml version="1.0"?>
<!-- Fix the output of MagicDraw 5.5 Beta1 for NSUML1.4 -->

<xsl:stylesheet version="1.0"
   xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
   xmlns:UML="omg.org/UML/1.4">

  <xsl:output method="xml" indent="yes"/>
  <xsl:strip-space elements="*"/>

<xsl:variable name="toolId" select="'Jamda MDtoNSUML.xsl'" />

  <xsl:template match="/">
	<xsl:apply-templates select="*" />
    <xsl:message><xsl:value-of select="$toolId"/> complete</xsl:message>
  </xsl:template>

  <xsl:template match="@* | text()">
	<xsl:copy/>
  </xsl:template>


  <xsl:template match="*">
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates select="node()"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="XMI.content">
    <xsl:copy>
      <xsl:copy-of select="@*"/>
      <xsl:apply-templates select="//UML:Comment" mode="outOfLine"/>
      <xsl:apply-templates select="*"/>
    </xsl:copy>
  </xsl:template>

  <xsl:template match="XMI.extensions">
    <!-- remove extensions -->
  </xsl:template>

  <xsl:template match="XMI.extension">
    <!-- remove extensions -->
  </xsl:template>

  <xsl:template match="UML:MultiplicityRange.upper[ . = '*' ]">
    <!-- change * to -1  -->
    <UML:MultiplicityRange.upper>-1</UML:MultiplicityRange.upper>
  </xsl:template>

  <!-- Change contained comments to references to the out-of-line elements
    created by the outOfLine mode template, or exclude if comment empty -->
  <xsl:template match="UML:Comment">
    <xsl:if test="string(.)">
      <UML:Comment xmi.idref="{@xmi.id}"/>
    </xsl:if>
  </xsl:template>


  <!-- Create out-of-line comment elements for non-empty comments -->
  <xsl:template match="UML:Comment" mode="outOfLine">
    <xsl:if test="string(.)">
      <xsl:variable name="ownerId" select="parent::UML:ModelElement.comment/parent::*/@xmi.id"/>
      <UML:Comment xmi.id="{@xmi.id}" annotatedElement="{$ownerId}">
        <xsl:copy-of select="*"/>
      </UML:Comment>
    </xsl:if>
  </xsl:template>


</xsl:stylesheet>
