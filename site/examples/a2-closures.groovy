// Title: Closures
// Summary: Blocks of code you can store, pass around and call: the it parameter, currying, and composition.

def shout = { String s -> s.toUpperCase() + '!' }
println shout('far out')

// One parameter? Call it "it".
def twice = { it * 2 }
println twice(21)

// Closures as arguments
[1, 2, 3].each { println "track $it" }

// Currying fixes the first argument
def multiply = { a, b -> a * b }
def triple = multiply.curry(3)
println triple(5)

// Composition with >> (left to right)
def addOne = { it + 1 }
def pipeline = addOne >> twice >> { "result: $it" }
println pipeline(4)
