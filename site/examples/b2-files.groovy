// Title: Files
// Summary: Write, read, append and walk files with the GDK's File methods, in a temporary folder so nothing on your disk changes.

def dir = File.createTempDir()
def notes = new File(dir, 'notes.txt')

notes.text = 'side A\n'
notes << 'side B\n'                       // append
notes.withWriterAppend { it.println 'bonus track' }

println notes.text
println notes.readLines().size()
notes.eachLine { line, n -> println "$n: $line" }

new File(dir, 'cover.txt').text = 'art'
dir.listFiles().findAll { it.name.endsWith('.txt') }*.name.sort().each { println it }

println dir.deleteDir()
