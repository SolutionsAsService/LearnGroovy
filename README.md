# Learn Groovy

Learn the Groovy language from twelve small programs, presented as an LP: **Side A** covers the basics (strings, closures, lists and maps, null safety, ranges and switch, classes and traits) and **Side B** covers real work (JSON, files, XML, HTTP, a tiny DSL, testing with power assert).

The original repository (one JSON/REST script) is kept on the `legacy-2026-10-30` branch.

## Run an example

You need a JDK (17 or newer) and Groovy.

```bash
cd examples
groovy a2-closures.groovy
```

Every example runs offline except `b4-http.groovy`, which calls GitHub's public API.

## Layout

- `examples/`: the programs (`a1-…` to `b6-…`). Each starts with `// Title:` and `// Summary:` lines and has a sibling `.out.txt` with the output it should print. The expected outputs were written by hand and checked by review, not machine-run; if you run one and it differs, please open an issue or a pull request.
- `site/`: the deployable static site (HTML, `css/`, `js/`, `favicon.svg`, and a copy of each example for download).
- `_src/`: the generator. `build.py` reads `examples/`, highlights the code, and writes one page per example plus the home page (whose record carries every example's code on its groove), the tracklist, setup and 404.
- `DESIGN-LOG.md`, `panel/`: the DADA design run that produced the site.

## Build

```bash
python _src/build.py
```

Edit `examples/` and `_src/`, not the generated HTML in `site/`. The build fails if a page links to a local file that doesn't exist.

## Deploy

Ready for Vercel with no build step: the root `vercel.json` serves `site/`, and `site/vercel.json` does the same if the Vercel Root Directory is set to `site`. The root `index.html` redirects to the site.

## Contributing and licence

See [CONTRIBUTING.md](CONTRIBUTING.md). MIT licensed; see [LICENSE](LICENSE).
