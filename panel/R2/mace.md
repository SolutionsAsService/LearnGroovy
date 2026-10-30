Seat: Mace
Verdict: OBJECT
Observed: R1 code-bar/footer fix landed (styles.css:35, mustard on ink ~8:1; buttons 34-48px, nav ~39px; all >=24px, link A3 is inline text, exempt). But M9 over-reached. The ring is drawn 3px OUTSIDE the element (outline-offset:3px, line 34), so contrast is judged against what lies outside. (1) `.output:focus-visible, .cmd:focus-visible` (line 35) are dark blocks on the cream page; mustard #E3A82B on cream #F4E9D3 is ~1.8:1, FAIL (was rust 5.6:1, a regression). (2) On the cover's .now-playing card (bg --paper), `.cover :focus-visible` makes the Java <pre tabindex=0> and the Track A3 link (.np-more a) mustard on paper, ~1.9:1, FAIL. Only .np-groovy pre is fixed back to rust (line 181, ~6:1, passes).
Anchor: Mace 4, Perceptible Information (focus position must be perceivable on every surface).
Meaning: the ring must contrast with what is outside the element, not inside.
Artist question: did you intend mustard on cream/paper, or only on brown/ink grounds?
Neutral question: what is the colour directly outside each focusable box?
Opinion: three of five dark-block cases now have the weakest ring in the site.
Requested change: delete `.output:focus-visible, .cmd:focus-visible` from line 35, and replace line 181 with `.cover .now-playing :focus-visible { outline-color: var(--rust); }` (covers Java pre, Groovy pre and the A3 link).
