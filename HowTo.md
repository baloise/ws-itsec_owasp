# Fork and modify a pitch
#### Fork branch as easy as: 
```
git clone https://github.com/baloise/ws-itsec_owasp.git
cd ws-itsec_owasp
git checkout pitch

# Create a new repository on your own Github account
git remote rename origin upstream
git remote add origin <URL TO YOUR GITHUB REPO>
git push origin master
```
If you feel like "update" at a later point, simply run: `git pull upstream master && git push origin master`

#### HowTo GitPitch
You can use your own server with GitPitch / revealJS which brings many advantages. HowTo [see here](https://github.com/gitpitch/gitpitch/wiki/Server-Deploy-Instructions) or do some googling. However, here I am only going to explain how to use the GitPitch service (free-edition).

A pitch mainly consist of three files + resources:
 - PITCHME.md -> Here is the actual pitch written, in markdown. [GitPitch syntax](https://gitpitch.com/docs/getting-started/delimiters/)
 - PITCHME.yaml -> Configuration file. For example change the footnote or specify your own Stylesheet (CSS)
 - PITTCHME.css -> Stylesheet. For example to use a custom font or change the [code-block layout](https://github.com/baloise/ws-itsec_owasp/issues/9).
 - res/ -> Here you put your PNGs, code-snippets and so on. No need to name this `res` or even create a folder for resources, it's just how this project is constructed.

..those get scraped and rendered by GitPitch. Therefore your Repository must be public (Free Version) and you have to provide the correct URL like this:
```
# Generic
https://gitpitch.com/<USER>/<Repository>/<BRANCH>#/

# Example
https://gitpitch.com/baloise/ws-itsec_owasp/pitch-intro#/
```

**That's it.** Now your ready to add, remove, modify to your liking. Just push changes and hit `F5`. This is where [git credential.helper](https://stackoverflow.com/questions/35942754/how-to-save-username-and-password-in-git) comes handy.

#### Use a custom font (example)
`PITCHME.yaml`
```yaml
theme-override : PITCHME.css
```
`PITCHME.css`
```css
@import url('https://fonts.googleapis.com/css?family=Open+Sans:600');

.oSans {
    font-family: 'Open Sans', sans-serif !important;
}
```
`PITCHME.md`
```md
@css[oSans](I am written in a custom font)
```

#### Edit existing images 
- Simply look for the particular image. In your pitch; hover over it or click save as to see the filename or have a look at the path in the `PITCHME.md`.
- Most image are available under `res/filename.xml`
- On [DrawIO](https://draw.io) click `Open Existing Diagram`

I suggest, you safe as XML and as PNG. However in your pitch you can only use PNG <= 1MB. They ditched SVG support (Free Version) and to my knowledge XML are not supported.

# offline versions (HTML & PDF)
Those can easily be obtained by:
- visiting your pitch (i.e `https://gitpitch.com/baloise/ws-itsec_owasp/pitch-lite#/`)
- Hit `M`, a menu pops up where you should be able to click:
  - `Offline Version (.zip)`
  - `Print Version (.pdf)`

#### Important note (PDF only)
If you use overflowing [code-blocks](https://github.com/baloise/ws-itsec_owasp/issues/9) (this project does) you need to comment-out the following lines in your `PITCHME.css` for the time you generate your PDF:
```css
.reveal pre {
    width: 130%;
    margin-inline-start: -15%;
    box-shadow : none;
}
```

#### HTML versions  
1. unzip `WebAppSec_Intro.zip`
2. open `WebAppSec_Intro/index.html` (works best with Chrome)


# Contribution
**Contribution is much appreciated!** Just make a pull request with your slides to the `pitch` branch.