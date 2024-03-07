@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')

import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON

// Example JSON string (pretend this is the response from a web service)
def jsonString = '''
{
  "employees": [
    {"firstName": "John", "lastName": "Doe"},
    {"firstName": "Anna", "lastName": "Smith"},
    {"firstName": "Peter", "lastName": "Jones"}
  ]
}
'''

// Parse the JSON string
def parsedJson = new groovy.json.JsonSlurper().parseText(jsonString)

// Process the parsed JSON
parsedJson.employees.each { employee ->
    println "${employee.firstName} ${employee.lastName}"
}

// Example of making a RESTful web service call and processing the JSON response
def makeRestCallAndProcessJson() {
    def client = new RESTClient('http://example.com/api/')
    client.get(path: '/employees', contentType: JSON) { resp, reader ->
        reader.employees.each { employee ->
            println "${employee.firstName} ${employee.lastName}"
        }
    }
}

// Uncomment the below line to run the REST call example
// makeRestCallAndProcessJson()
