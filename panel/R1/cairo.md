Seat: Cairo
Verdict: OBJECT
Observed:
- a3-collections.groovy:20-21 / a3-collections.out.txt:7 (and site/a3-collections.html:63) → printed "l=3"; Groovy prints "o=4". In 'hello groovy world' o occurs 4 times (hell-o, gr-o-o-vy, w-o-rld), l occurs 3, so max by value is o=4. Wrong answer on a page that says it is hand-derived.
- b3-xml.groovy:19 / b3-xml.out.txt:10-11 → likely missing blank line. MarkupBuilder ends its output with a newline after </catalog>, then println adds another, so a blank line should sit between "</catalog>" and "2". (Medium confidence; not machine-checked.)
- b4-http.out.txt:3 (site/b4-http.html:59) → "stars: (the live count, which changes)" is a placeholder, not output. It sits inside the Expected-output block with no marker, though the "written by hand" note is there. Label it, e.g. "stars: 5xxx (varies)".
- Line counts: a1 18, a3 18, a6 30, b6 13 all match (count = lines 4..end, i.e. after the header and the blank separator). All 12 match. "12 tracks" is correct (12 pairs). The method is unstated: "after the two header comment lines" literally gives N+1, because the blank line 3 is skipped silently.
- Checked and correct: a1, a2, a4 (padRight spacing verified per row), a5 (all 8 switch results; step gives a List), a6, b1 (4-space prettyPrint), b2 (blank line from println of text ending in \n; eachLine starts at 1), b5, b6 (power-assert column alignment verified).
Anchor: Cairo, "The Truthful Art": show the method and the source, and a wrong number that looks authoritative is worse than none. Truthfulness before polish.
Meaning: A learner will trust "l=3" and learn a false output; the hand-written disclosure does not excuse a verifiable error.
Artist question: Can the page show the working, e.g. a counts tally line, so the reader can verify?
Neutral question: What produced "l=3"? A miscount or an unverified guess?
Opinion: 1 of 12 outputs is wrong, 1 is probably off by a blank line, 1 is a placeholder. Fix these before shipping.
Requested change:
1. a3-collections.out.txt:7 and a3-collections.html:63: change "l=3" to "o=4".
2. b3-xml.out.txt and b3-xml.html: add an empty line after "</catalog>" (or end the println with print).
3. b4: mark the stars line as a placeholder in the block, or give an example value with "(varies)".
4. State the line-count rule on the site ("code lines after the header and blank line").
