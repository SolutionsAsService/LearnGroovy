Seat: Bringhurst
Verdict: OBJECT
Observed: On a3-collections.png, line 8 of the code reads "// spread operato" and is cut off at the panel's right edge (x~768). The code column is about 690px wide against a 1120px wrap, with the output box taking the rest. Code is .95rem/1.6 (24.3px lines) beside Work Sans at 17px/1.6 (27.2px). Home title: Shrikhand with four stacked text-shadows at .035em steps, letter-spacing -.03em, line-height .82. Text measure is sound: .lede max-width 40em, "Why Groovy" paragraphs about 65-70 characters.
Anchor: Typography exists to honor the content (Bringhurst, "Typography is the craft of endowing human language with a durable visual form"). A clipped comment is lost content, and code is the content a learner studies. Matching the face to the text: the display face is confined to the cover and headings, with calm text and mono elsewhere, which is correct.
Meaning: A record sleeve, loud on the cover and quiet on the track pages. The title shadow reads as an LP-cover lettering gag. At display size it is legitimate, and it is not used on text.
Artist question: Was the comment alignment meant to be part of the lesson, or did it just land at column 70 by habit?
Neutral question: What happens to line 8 when a learner doesn't scroll sideways on a 1280 screen?
Opinion: The two baselines (24.3px code, 27.2px prose) do not share a rhythm. That is tolerable because the code sits in its own panel. The truncated comment is not tolerable.
Requested change: Give the track grid columns of minmax(0,1.6fr) and minmax(0,1fr), or shorten the padding before "// spread operator" in the source file to two spaces, so no code line clips at 1280px. Verify that line 8 shows its full comment without horizontal scroll.
