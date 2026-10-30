// Title: Null safety and truth
// Summary: The safe-navigation operator ?., the Elvis operator ?: and Groovy truth: what counts as true.

def fan = [name: 'Sam', address: null]

println fan.address?.city            // null, not a NullPointerException
println fan.address?.city ?: 'unknown city'

def nickname = ''
println nickname ?: 'no nickname'    // empty string is false

// Groovy truth
[null, 0, '', [], [:], 'x', 1, [0]].each {
    println "${it.inspect().padRight(6)} -> ${it as boolean}"
}

// Safe index on a possibly-null list
List tracks = null
println tracks?.getAt(0)
