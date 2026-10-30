// Title: Ranges and switch
// Summary: Ranges as first-class values, and a switch that matches types, ranges, lists, regex and closures.

def decade = 1970..1979
println decade.size()
println decade.contains(1975)
println (('a'..'e').join())
println ((1..10).step(3))

def describe(x) {
    switch (x) {
        case null:            return 'nothing'
        case 1960..1969:      return 'sixties'
        case 1970..<1980:     return 'seventies'
        case ~/^[A-Z].*/:     return 'a capitalised word'
        case [7, 11]:         return 'lucky'
        case Number:          return 'some other number'
        case { it instanceof List }: return "a list of ${x.size()}"
        default:              return 'no idea'
    }
}

[1967, 1977, 'Groovy', 7, 3.14, [1, 2], 'lowercase', null].each {
    println "$it -> ${describe(it)}"
}
