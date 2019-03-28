# OWASP Top10 / AppSec - pitches
#### Available pitches:

- [pitch-intro](https://gitpitch.com/baloise/ws-itsec_owasp/pitch-intro#/)
- [pitch-lite](https://gitpitch.com/baloise/ws-itsec_owasp/pitch-lite#/)


#### Permanent branch(es)
 - `pitch`: This branch shall contain all available slides (collection). For a new presentation, fork this branch and modify to your liking.

#### Presentation branch(es)
 - `pitch-intro` is a presentation branch that shows basic (mostly old but easily understandable) vulnerabilities / attacks in Web Applications.
 - `pitch-lite` is a presentation branch that shows basic and some more advanced vulnerabilities / attacks and also explains common mitigations in Web Applications.

### HowTo
- [fork / modify a pitch](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#fork-and-modify-a-pitch)
  - [howto GitPitch](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#howto-gitpitch)
  - [custom font](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#use-a-custom-font-example)
  - [edit images](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#edit-existing-images)
- [offline versions](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#offline-versions-html--pdf)
- [contribute](https://github.com/baloise/ws-itsec_owasp/blob/pitch/HowTo.md#contribution)
  
### Known issues
- code-blocks do not scale well (see [workaround](https://github.com/baloise/ws-itsec_owasp/issues/9))
- Inline images do overflow (on the bottom) if format / ratio is ..let's call it unusual. Meaning if your image is much higher than wide, GitPitch seems to auto-fit accordingly to the width.
  - To resolve this you can set it as background (i.e with parameter `&size=contain`, [see here](https://gitpitch.com/docs/image-features/scaling/))
  - If you need to set a title, text, etc this is going to partially cover your image. Thus (as inline image); you could manually enlarge thw width of image with transparency -it's a hassle.
- Opacity is no longer available in the Free Version (You can however, edit your pictures with a graphic program to add opacity but again -it's a hassle)
- Not there? -please do report