// Title: HTTP and a REST API
// Summary: Call a real public API with nothing but the JDK, and read the JSON it returns. Needs an internet connection.

import groovy.json.JsonSlurper

// GitHub's public API: no key needed for a few requests an hour.
def url = 'https://api.github.com/repos/apache/groovy'
def connection = new URL(url).openConnection()
connection.setRequestProperty('Accept', 'application/vnd.github+json')
connection.setRequestProperty('User-Agent', 'LearnGroovy-example')

if (connection.responseCode == 200) {
    def repo = new JsonSlurper().parse(connection.inputStream)
    println repo.full_name
    println "language: ${repo.language}"
    println "stars: ${repo.stargazers_count}"
} else {
    println "Request failed: HTTP ${connection.responseCode}"
}
