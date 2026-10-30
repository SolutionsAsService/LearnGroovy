// Title: Testing with assert
// Summary: Groovy's power assert prints every value in a failing expression, so a plain assert is a readable test.

def bpm(String song) {
    [ 'Get Down': 112, 'Far Out': 96, 'Right On': 124 ][song]
}

assert bpm('Get Down') == 112
assert bpm('Far Out') < 100
println 'all good so far'

try {
    assert bpm('Right On') + 1 == 124
} catch (AssertionError e) {
    println e.message
}
