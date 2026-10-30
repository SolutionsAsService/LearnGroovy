# Panel R2 brief (WHOLE round, build of 2026-10-30 after moves M6–M10)

Artifact: the Learn Groovy site, styled as a 1970s LP. Mode Adaptive, criterion MAYA.

Screenshots (fresh for R2): H:/UBM/_redo/LearnGroovy/panel/shots/index.png, a3-collections.png, tracks.png, setup.png (1280 wide); index-m.png, a3-collections-m.png, b6-power-assert-m.png (500 wide; headless Chrome would not lay out narrower, see below). Source: H:/UBM/_redo/LearnGroovy/site/*.html, site/css/styles.css, examples/*.groovy and *.out.txt. Your R1 report: H:/UBM/_redo/LearnGroovy/panel/R1/<seat>.md.

What changed since R1, and how each R1 objection was resolved:
- M6 (merge of Debord and Shklovsky): the cover now carries a legible "Now playing" card: four lines of real Java that collect album titles, above the Groovy one-liner `def titles = albums*.title`, with a link to track A3. Real code is the first readable content; the idiom is made strange by its long twin.
- M7: code lines wrap with a hanging indent under the line number. A3 line 8 no longer clips; measured pre scrollWidth = clientWidth (686 px) at 1280.
- M8: track pages on phones: page width was 659 px at a 375 px viewport (code pushed the grid); now 375 px.
- M9: focus ring is mustard (not rust) on dark surfaces: .code-bar (Copy, Download), footer, output and command blocks.
- M10: nav "Run it" renamed "Install Groovy"; tracklist rows end in an arrow; the tracklist states the line-count rule.
- Cairo's fixes: A3 now prints o=4; B3 prints xml.trim(); B4's star line is a visible placeholder "<today's live count>".
- OVERRULED with measurement: the R1 cover-clipping objection. At a real 375 px viewport (in-app browser), the document is 375 px wide and the lede, buttons and "Stop the record" sit inside x = 16–359. The R1 390 px headless screenshot was laid out wider than it was captured.
- DEFERRED: a per-track "needle drop" that expands each idiom into Java (bounded run; done once on the cover by M6).
