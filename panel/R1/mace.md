Seat: Mace
Verdict: OBJECT
Observed: styles.css:34 sets a global `:focus-visible { outline: 3px solid var(--rust); outline-offset: 3px }`. Rust #A33E15 on cream is 5.6:1 and passes on the page, the tracklist, the pager and the paper-coloured code pre. Line 35 re-colours the outline to mustard only inside `.cover` and `.site-header`. Dark surfaces outside those two scopes keep the rust ring: `.code-bar` (Copy and Download, bg --ink) and `.site-footer a` (bg --brown). I computed rust against #2A1A10 at about 2.6:1, below the 3:1 non-text minimum. The ring sits 3px outside the button, so it lands on the dark bar. Target sizes pass: .btn 48px, .spin-toggle 40px, .code-actions 34px, .pager and tracklist rows over 44px, nav links about 39px. Separately, index-m.png (390px) shows the lede and the "Stop the record" toggle clipped at the right edge. body has overflow-x:hidden, so this is hidden rather than scrolled. I did not confirm the cause.
Anchor: Perceptible Information (focus position must be perceivable) and Equitable Use.
Meaning: a calm reading grid with a loud cover, where keyboard users should be able to follow along on both.
Artist question: which dark surfaces besides the cover did you expect a keyboard user to land on?
Neutral question: does the toggle sit fully inside the 390px viewport?
Opinion: Copy and Download are the main actions on a track page, and their focus ring is the weakest in the site.
Requested change: extend line 35 to `.cover :focus-visible, .site-header :focus-visible, .code-bar :focus-visible, .site-footer :focus-visible { outline-color: var(--mustard); }`. Mustard on ink is about 8:1. Also confirm the mobile cover clip and fix it with `min-width:0` on the grid children.
