// Title: Lists and maps
// Summary: Literal lists and maps, then the GDK methods that make them sing: collect, findAll, inject, groupBy, sort.

def albums = [
    [title: 'Rumours',         year: 1977, sides: 2],
    [title: 'Abbey Road',      year: 1969, sides: 2],
    [title: 'Songs in the Key of Life', year: 1976, sides: 4],
    [title: 'Pet Sounds',      year: 1966, sides: 2],
]

println albums*.title    // spread operator: the title of every album
println albums.findAll { it.year >= 1970 }*.title
println albums.collect { it.title.size() }
println albums.inject(0) { total, a -> total + a.sides }
println albums.sort { it.year }.first().title
println albums.groupBy { it.year < 1970 ? '60s' : '70s' }
              .collectEntries { k, v -> [k, v.size()] }

def counts = [:].withDefault { 0 }
'hello groovy world'.each { if (it != ' ') counts[it]++ }
println counts.max { it.value }
