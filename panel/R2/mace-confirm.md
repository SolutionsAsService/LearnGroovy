Seat: Mace
Verdict: OBJECT
Observed: Specificity is correct. `:focus-visible` rust (0,1,0); `.cover/.site-header/.code-bar/.site-footer :focus-visible` mustard (0,2,0); `.cover .now-playing :focus-visible` rust (0,3,0), last, so the card Java pre gets rust on paper (about 5.6:1). `.output` and `.cmd` now fall to rust on cream/paper, which passes. Mustard rings on the brown header, cover, code-bar and footer pass. One gap remains: `.skip` is a direct child of body, so it gets the default rust ring. On focus it sits at top:16px over the brown `.site-header`, and the ring's outside surface is brown #2A1A10. Rust on brown is about 2.6:1, below 3:1.
Anchor: Mace principle 4, Perceptible Information
Requested change: add `.skip:focus-visible { outline-color: var(--cream); }` (cream on brown is above 12:1). Everything else passes.
