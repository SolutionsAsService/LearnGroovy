// Title: Classes and traits
// Summary: Classes with automatic properties, named-argument constructors, @Canonical, and traits for mixing in behaviour.

import groovy.transform.Canonical

@Canonical
class Record {
    String artist
    String title
    int year
}

trait Playable {
    String play() { "Now playing: ${title} by ${artist}" }
}

trait Collectible {
    boolean isVintage() { year < 1980 }
}

class Vinyl extends Record implements Playable, Collectible {
    int rpm = 33
}

def lp = new Vinyl(artist: 'Stevie Wonder', title: 'Innervisions', year: 1973)
println lp.play()
println lp.vintage            // property access calls isVintage()
println lp.rpm

def a = new Record('Queen', 'Jazz', 1978)
def b = new Record('Queen', 'Jazz', 1978)
println a                     // toString from @Canonical
println a == b                // equals from @Canonical
