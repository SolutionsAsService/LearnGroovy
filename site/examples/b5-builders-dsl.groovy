// Title: A tiny DSL
// Summary: Closures with a delegate let you write code that reads like configuration: here, a setlist.

class Setlist {
    String band
    List<String> songs = []

    void band(String name) { band = name }
    void play(String song) { songs << song }
    void encore(Closure more) {
        play('--- encore ---')
        more.delegate = this
        more()
    }

    static Setlist build(@DelegatesTo(Setlist) Closure spec) {
        def s = new Setlist()
        spec.delegate = s
        spec.resolveStrategy = Closure.DELEGATE_FIRST
        spec()
        s
    }
}

def show = Setlist.build {
    band 'The Grooves'
    play 'Get Down'
    play 'Far Out'
    encore {
        play 'Right On'
    }
}

println show.band
show.songs.eachWithIndex { song, i -> println "${i + 1}. $song" }
