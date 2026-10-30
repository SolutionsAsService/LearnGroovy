// Title: Hello, strings
// Summary: Strings, GStrings with ${} interpolation, multiline strings and a few handy String methods.

def name = 'Groovy'
def version = 4

println "Hello, ${name} ${version}!"
println 'Single quotes are plain strings: ${not interpolated}'

def poem = """\
Roses are red,
${name} is groovy,
semicolons are optional
"""
print poem

println name.toUpperCase()
println name.reverse()
println name * 3
println "groovy".capitalize()
println "a,b,c".tokenize(',')
