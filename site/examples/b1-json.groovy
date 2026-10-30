// Title: JSON in and out
// Summary: Parse JSON with JsonSlurper, walk it like objects, and write it back out with JsonOutput.

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

def text = """
{
  "band": "The Grooves",
  "members": [
    {"name": "Ana",   "plays": "bass"},
    {"name": "Bilal", "plays": "drums"},
    {"name": "Chen",  "plays": "keys"}
  ]
}
"""

def json = new JsonSlurper().parseText(text)
println json.band
json.members.each { println "${it.name} plays ${it.plays}" }
println json.members.find { it.plays == 'drums' }.name

def setlist = [band: json.band, songs: ['Get Down', 'Far Out'], encore: true]
println JsonOutput.toJson(setlist)
println JsonOutput.prettyPrint(JsonOutput.toJson([ok: true]))
