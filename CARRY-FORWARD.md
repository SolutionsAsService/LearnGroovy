# Carry-Forward Ledger (facts about the medium, measured in the 2026-10-30 run)

- A `1fr` grid track has an `auto` minimum, so a long `pre` line widens a single-column phone layout (A3: 659 px at a 375 px viewport); `minmax(0, 1fr)` holds it to 375. (M8)
- Headless Chrome `--headless=new --window-size=390,…` lays out wider than 390 px and crops; at 500 px the capture is faithful. The same page measures 375 px wide in a real 375 px viewport. (R1 overrule)
- An outline with `outline-offset` is judged against the surface outside the element; colour it by that surface (mustard on ink ≈ 8:1, mustard on cream ≈ 1.8:1). (M11, M13)
- Script `element.focus()` does not set `:focus-visible` in Chromium; read ring colours after real Tab key presses. (M11)
- In a `<pre>`, block-level line spans joined with `\n` double the line spacing; join them with nothing. (pre-panel fix)
- Bash heredocs with backticks and quotes in `bash -c` failed again (lesson 26); write long log text with the editor tool and append it with a script.
