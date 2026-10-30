// Title: XML
// Summary: Build XML with MarkupBuilder, then read it back with XmlSlurper and GPath.

import groovy.xml.MarkupBuilder
import groovy.xml.XmlSlurper

def writer = new StringWriter()
new MarkupBuilder(writer).catalog {
    album(year: 1971) {
        title 'Whats Going On'
        artist 'Marvin Gaye'
    }
    album(year: 1973) {
        title 'Innervisions'
        artist 'Stevie Wonder'
    }
}
def xml = writer.toString()
println xml.trim()

def catalog = new XmlSlurper().parseText(xml)
println catalog.album.size()
println catalog.album.find { it.@year.text() == '1973' }.title
println catalog.album*.artist*.text()
