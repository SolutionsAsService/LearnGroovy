Seat: Krug
Verdict: OBJECT (mild)
Observed: Track page a3-collections passes most of the trunk test. Site name (Learn Groovy), page name ("Lists and maps"), "SIDE A · TRACK A3" as location, an underlined "Tracklist" as you-are-here, and clear Previous/Next cards. Code and "Expected output" sit side by side and scan well. Problems: (1) the nav label "Run it" does not say where it goes (install/setup?), and the home page calls the same destination "Install Groovy and run the tracks". Same place, two names. (2) Line 8's comment is cut off at the code card edge ("// spread operato"), which looks broken. (3) Home tracklist rows (A1..B6) have no arrow or affordance, though the "Drop the needle" button is clear.
Anchor: Krug, "Don't make me think": every question mark in the visitor's head is a tax. Navigation labels must be self-evident, and the same thing should carry one name everywhere.
Meaning: This is an LP, and each example is a calm track. Learners play one at a time.
Artist question: Does "Run it" mean "run this code" or "set up Groovy"?
Neutral question: What does a first-timer from the Roadmap expect from a nav item next to "Docs"?
Opinion: The 70s theme is scannable and does not hide the content, and I like it. But a learner has to guess what "Run it" does, and the clipped comment reads as a bug.
Requested change: Rename the nav item "Run it" to "Install Groovy" on every page (site/*.html header, plus the footer if it uses the old name), so it matches the home page link text. Open item: let the code card wrap or scroll the comment so line 8 is not clipped.
