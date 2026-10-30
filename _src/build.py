"""Build the LearnGroovy site from examples/*.groovy.

Each example starts with two header lines:

    // Title: Closures
    // Summary: One sentence on what it shows.

and has a sibling <name>.out.txt holding its expected output. File names
start with the side and track (a1-, b4-), which sets their order.

Pages are _src/pages/*.html wrapped in _src/layout.html, plus one page per
example from _src/track.html. The home page's record carries the real code
of every example on its spiral groove.

Run:  python _src/build.py   (writes into site/)
"""
import html
import math
import pathlib
import re
import shutil

SRC = pathlib.Path(__file__).resolve().parent
REPO = SRC.parent
SITE = REPO / "site"
EXAMPLES = REPO / "examples"
NAV = ["tracks", "setup"]

KEYWORDS = set("""abstract as assert boolean break byte case catch char class const continue def default do double
else enum extends false final finally float for if implements import in instanceof int interface long native new
null package private protected public return short static super switch this throw throws trait true try var void
while with""".split())
TOKEN = re.compile(r"""
  (?P<comment>//[^\n]*|/\*.*?\*/)
| (?P<string>'''.*?'''|\"\"\".*?\"\"\"|'(?:\\.|[^'\\\n])*'|"(?:\\.|[^"\\\n])*"|~/(?:\\.|[^/\\\n])+/)
| (?P<annotation>@[A-Za-z_]\w*)
| (?P<number>\b\d+(?:\.\d+)?\b)
| (?P<word>[A-Za-z_]\w*)
""", re.S | re.X)


def highlight(code):
    out, pos = [], 0
    for m in TOKEN.finditer(code):
        out.append(html.escape(code[pos:m.start()]))
        kind, text = m.lastgroup, m.group()
        if kind == "word":
            if text in KEYWORDS:
                out.append(f'<span class="k">{text}</span>')
            elif text[0].isupper():
                out.append(f'<span class="t">{text}</span>')
            else:
                out.append(html.escape(text))
        else:
            cls = {"comment": "c", "string": "s", "annotation": "a", "number": "n"}[kind]
            out.append(f'<span class="{cls}">{html.escape(text)}</span>')
        pos = m.end()
    out.append(html.escape(code[pos:]))
    lines = "".join(out).split("\n")
    # Each line is a block span, so no newline between them (a newline would double the spacing in <pre>).
    return "".join(f'<span class="ln">{line or " "}</span>' for line in lines)


def load():
    tracks = []
    for f in sorted(EXAMPLES.glob("*.groovy")):
        text = f.read_text(encoding="utf-8")
        title = re.search(r"^// Title: (.+)$", text, re.M).group(1).strip()
        summary = re.search(r"^// Summary: (.+)$", text, re.M).group(1).strip()
        code = re.sub(r"\A(// (Title|Summary): .*\n)+", "", text).strip("\n")
        out = f.with_suffix(".out.txt")
        side, num = f.stem[0].upper(), int(f.stem[1])
        tracks.append({
            "slug": f.stem, "file": f.name, "title": title, "summary": summary, "code": code,
            "output": out.read_text(encoding="utf-8").rstrip("\n") if out.exists() else "",
            "side": side, "num": num, "lines": code.count("\n") + 1,
        })
    return tracks


def record_svg(tracks):
    """A vinyl record whose groove is an Archimedean spiral carrying every example's code."""
    words = "   ·   ".join(re.sub(r"\s+", " ", t["code"]) for t in tracks)
    cx = cy = 300
    r0, r1, turns = 96, 286, 20
    pts = []
    steps = turns * 72
    for i in range(steps + 1):
        a = i / 72 * 2 * math.pi
        r = r1 - (r1 - r0) * i / steps
        pts.append(f"{cx + r * math.cos(a):.1f},{cy + r * math.sin(a):.1f}")
    path = "M" + " L".join(pts)
    return f"""<svg class="record" viewBox="0 0 600 600" aria-hidden="true">
  <defs><path id="groove" d="{path}"/>
    <radialGradient id="sheen" cx="35%" cy="30%" r="75%"><stop offset="0" stop-color="#3a2a22"/><stop offset=".55" stop-color="#140d0a"/><stop offset="1" stop-color="#0b0706"/></radialGradient></defs>
  <circle cx="300" cy="300" r="298" fill="url(#sheen)"/>
  <text class="groove-text"><textPath href="#groove">{html.escape(words)}</textPath></text>
  <circle cx="300" cy="300" r="92" fill="#E07A1F"/>
  <circle cx="300" cy="300" r="92" fill="none" stroke="#E3A82B" stroke-width="10" stroke-dasharray="4 10"/>
  <path d="M220 300a80 80 0 0 1 160 0" fill="none" stroke="#B5451B" stroke-width="18"/>
  <text x="300" y="286" text-anchor="middle" class="label-title">Learn Groovy</text>
  <text x="300" y="322" text-anchor="middle" class="label-sub">SIDE A · 33⅓ RPM</text>
  <circle cx="300" cy="300" r="7" fill="#140d0a"/>
</svg>"""


def tracklist(tracks, side, detailed):
    items = []
    for t in (x for x in tracks if x["side"] == side):
        extra = f'<p>{html.escape(t["summary"])}</p>' if detailed else ""
        items.append(
            f'<li><a href="{t["slug"]}.html"><span class="tno">{t["side"]}{t["num"]}</span>'
            f'<span class="tt">{html.escape(t["title"])}</span><span class="tl">{t["lines"]} lines</span></a>{extra}</li>'
        )
    return f'<ol class="tracklist{" detailed" if detailed else ""}">' + "".join(items) + "</ol>"


def page(layout, title, description, nav, body):
    out = layout.replace("{{title}}", title).replace("{{description}}", description)
    for key in NAV:
        out = out.replace("{{cur:%s}}" % key, ' aria-current="page"' if nav == key else "")
    out = out.replace("{{content}}", body.rstrip())
    assert not re.search(r"\{\{.*?\}\}", out), f"unfilled placeholder in {title}"
    return out


def main():
    layout = (SRC / "layout.html").read_text(encoding="utf-8")
    track_tpl = (SRC / "track.html").read_text(encoding="utf-8")
    tracks = load()
    sides = {"A": "Side A · The basics", "B": "Side B · Real work"}
    blocks = {
        "{{record}}": record_svg(tracks),
        "{{tracks:A}}": tracklist(tracks, "A", False),
        "{{tracks:B}}": tracklist(tracks, "B", False),
        "{{tracks:A:detailed}}": tracklist(tracks, "A", True),
        "{{tracks:B:detailed}}": tracklist(tracks, "B", True),
        "{{count}}": str(len(tracks)),
        "{{first}}": tracks[0]["slug"] + ".html",
    }

    (SITE / "examples").mkdir(parents=True, exist_ok=True)
    built = []
    for src in sorted((SRC / "pages").glob("*.html")):
        head, body = src.read_text(encoding="utf-8").split("\n---\n", 1)
        meta = dict(line.split(": ", 1) for line in head.strip().splitlines())
        for k, v in blocks.items():
            body = body.replace(k, v)
        (SITE / src.name).write_text(page(layout, meta["title"], meta["description"], meta.get("nav"), body), encoding="utf-8", newline="\n")
        built.append(src.name)

    for i, t in enumerate(tracks):
        prev_t = tracks[i - 1] if i else None
        next_t = tracks[i + 1] if i + 1 < len(tracks) else None
        shutil.copyfile(EXAMPLES / t["file"], SITE / "examples" / t["file"])
        body = track_tpl
        fills = {
            "{{side}}": sides[t["side"]], "{{tno}}": f'{t["side"]}{t["num"]}', "{{title}}": html.escape(t["title"]),
            "{{summary}}": html.escape(t["summary"]), "{{file}}": t["file"], "{{code}}": highlight(t["code"]),
            "{{output}}": html.escape(t["output"]), "{{lines}}": str(t["lines"]),
            "{{prev}}": (f'<a class="prev" href="{prev_t["slug"]}.html"><small>Previous · {prev_t["side"]}{prev_t["num"]}</small>{html.escape(prev_t["title"])}</a>' if prev_t else '<a class="prev" href="tracks.html"><small>Back to</small>The tracklist</a>'),
            "{{next}}": (f'<a class="next" href="{next_t["slug"]}.html"><small>Next · {next_t["side"]}{next_t["num"]}</small>{html.escape(next_t["title"])}</a>' if next_t else '<a class="next" href="setup.html"><small>Last track. Now</small>Run them yourself</a>'),
        }
        for k, v in fills.items():
            body = body.replace(k, v)
        title = f'{t["side"]}{t["num"]} · {t["title"]} · Learn Groovy'
        (SITE / f'{t["slug"]}.html').write_text(page(layout, title, t["summary"], "tracks", body), encoding="utf-8", newline="\n")
        built.append(f'{t["slug"]}.html')

    for name in built:
        text = (SITE / name).read_text(encoding="utf-8")
        for ref in re.findall(r'(?:href|src)="(?![a-z]+:)([^"#?]+)', text):
            assert (SITE / ref).exists(), f"{name} links to missing {ref}"
    print("built", len(built), "pages from", len(tracks), "examples")


main()
