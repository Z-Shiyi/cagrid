<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="xml"/>  
    <xsl:template match="/cruisecontrol">
        <DartSubmission version="2.0" createdby="CruiseControl">
            <!-- Extract the build info we added -->
            <xsl:apply-templates select="BuildInfo"/>
            <!-- Extract any properties -->
            <xsl:apply-templates select="info/property"/>
            <!-- Extract updates -->
            <xsl:apply-templates select="modifications"/>
            <!-- Extract Build -->
            <xsl:apply-templates select="build"/>
            <!-- Extract Tests -->
            <xsl:apply-templates select="testsuite"/>
        </DartSubmission>
    </xsl:template>
    <!-- Selects everything under the BuildInfo tag we added in, and injects all its children -->
    <xsl:template match="BuildInfo">
        <xsl:copy-of select="*"/>
    </xsl:template>
    <!-- Extract the build date -->
    <xsl:template match="property[@name='builddate']">
        <DateTimeStamp>
            <xsl:value-of select="@value"/>
        </DateTimeStamp>
    </xsl:template>
    <!-- create the build log -->
    <xsl:template match="build">
        <xsl:for-each select="target">
            <Test>
                <xsl:choose>
                    <xsl:when test="../../build[@error]">
                        <Name>.Build.<xsl:value-of select="@name"/>.Error</Name>
                        <Status>failed</Status>
                        <Measurement name="ErrorCount" type="numeric/integer">1</Measurement>
                    </xsl:when>
                    <xsl:otherwise>
                        <Name>.Build.<xsl:value-of select="@name"/></Name>
                        <Status>passed</Status>
                    </xsl:otherwise>
                </xsl:choose>
                <Measurement name="StageName" type="text/string">
                    <xsl:value-of select="@name"/>
                </Measurement>
                <!-- TODO: parse the sentenance like time to necessary format  -->
                <Measurement name="ElapsedTime" type="numeric/float">
                    <xsl:call-template name="duration-string-to-seconds">
                        <xsl:with-param name="durationString" select="@time"/>
                    </xsl:call-template>
                </Measurement>
                <Measurement name="Log" type="text/text">
                    <xsl:for-each select=".//message">
                        <xsl:apply-templates select="."/>
                    </xsl:for-each>
                </Measurement>
            </Test>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="message">
        <xsl:text>
</xsl:text>
        <xsl:value-of select="."/>
    </xsl:template>
    <xsl:template match="modifications">
        <Test>
            <Name>.Update.Update</Name>
            <Status>passed</Status>
        </Test>
        <xsl:for-each select="modification">
            <Test>
                <Name>.Update.Update.Update<xsl:value-of select="position()"/></Name>
                <Status>passed</Status>
                <Measurement name="File" type="text/string">
                    <xsl:value-of select="@type"/>
                </Measurement>
                <Measurement name="File" type="text/string">
                    <xsl:value-of select="file/filename"/>
                </Measurement>
                <Measurement name="Directory" type="text/string">
                    <xsl:value-of select="file/project"/>
                </Measurement>
                <Measurement name="CheckinDate" type="text/string">
                    <xsl:value-of select="date"/>
                </Measurement>
                <Measurement name="Author" type="text/string">
                    <xsl:value-of select="user"/>
                </Measurement>
                <Measurement name="Revision" type="text/string">
                    <xsl:value-of select="revision"/>
                </Measurement>
                <Measurement name="PriorRevision" type="text/string">
                    <!-- CruiseControl with CVS doesn't provide prior revision, so lets hack a guess to be previous minor rev (Won't always be right, but better than nothing) -->
                    <xsl:value-of
                        select="concat(substring-before(revision,'.'),concat('.',substring-after(revision,'.')
                        - 1))"/>
                </Measurement>
                <Measurement name="Log" type="text/string">
                    <xsl:value-of select="comment"/>
                </Measurement>
            </Test>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="testsuite">
        <xsl:variable name="out">
            <xsl:value-of select="system-out"/>
        </xsl:variable>
        <xsl:variable name="err">
            <xsl:value-of select="system-err"/>
        </xsl:variable>
        <xsl:for-each select="testcase">
            <Test>
                <Name>.Test.<xsl:value-of select="@classname"/>.<xsl:value-of select="@name"/></Name>
                <Status>
                    <xsl:if test="failure|error">failed</xsl:if>
                    <xsl:if test="not(failure|error)">passed</xsl:if>
                </Status>
                <Measurement name="Execution Time" type="numeric/float">
                    <xsl:value-of select="@time"/>
                </Measurement>
                <Measurement name="Output" type="text/text">
                    <xsl:if test="not ($out='')"> SYSTEM OUT><xsl:value-of select="$out"/>
                    </xsl:if>
                    <xsl:if test="not ($err='')"> SYSTEM ERR><xsl:value-of select="$err"/>
                    </xsl:if>
                    <xsl:if test="failure|error">
                        <xsl:value-of select="failure|error"/>
                    </xsl:if>
                </Measurement>
            </Test>
        </xsl:for-each>
    </xsl:template>
    <!-- Ugly code to convert english like durations to numeric values -->
    <xsl:template name="duration-string-to-seconds">
        <xsl:param name="durationString"/>
        <xsl:choose>
            <xsl:when test="contains($durationString,'minutes')">
                <xsl:variable name="num"
                    select="normalize-space(substring-before($durationString,'minutes'))"/>
                <xsl:variable name="remaining"
                    select="normalize-space(substring-after($durationString,'minutes'))"/>
                <xsl:variable name="minsInSecs">
                    <xsl:value-of select="60 * $num"/>
                </xsl:variable>
                <xsl:variable name="recursion">
                    <xsl:call-template name="duration-string-to-seconds">
                        <xsl:with-param name="durationString" select="$remaining"/>
                    </xsl:call-template>
                </xsl:variable>
                <xsl:value-of select="$minsInSecs + $recursion"/>
            </xsl:when>
            <xsl:when test="contains($durationString,'minute')">
                <xsl:variable name="num"
                    select="normalize-space(substring-before($durationString,'minute'))"/>
                <xsl:variable name="remaining"
                    select="normalize-space(substring-after($durationString,'minute'))"/>
                <xsl:variable name="minsInSecs">
                    <xsl:value-of select="60 * $num"/>
                </xsl:variable>
                <xsl:variable name="recursion">
                    <xsl:call-template name="duration-string-to-seconds">
                        <xsl:with-param name="durationString" select="$remaining"/>
                    </xsl:call-template>
                </xsl:variable>
                <xsl:value-of select="$minsInSecs + $recursion"/>
            </xsl:when>
            <xsl:otherwise>
                <xsl:value-of select="normalize-space(substring-before($durationString,'second'))"/>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>
</xsl:stylesheet>
