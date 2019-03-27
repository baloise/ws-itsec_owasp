# OWASP Top10 / AppSec - pitches
#### Available pitches:

- [pitch-intro](https://gitpitch.com/baloise/ws-itsec_owasp/pitch-intro#/)
- [pitch-lite](https://gitpitch.com/baloise/ws-itsec_owasp/pitch-lite#/)


#### Permanent branch(es)
 - `pitch`: This branch shall contain all available slides (collection). For a new presentation, fork this branch and modify to your liking.

#### Presentation's branch(es)
 - `pitch-intro` is a presentation branch that shows basic (mostly old but easily understandable) vulnerabilities / attacks in Web Applications.
 - `pitch-lite` is a presentation branch that shows basics and partially more advanced vulnerabilities / attacks and also explains common mitigations in Web Applications.

### HowTo
- Create / modify your own pitch
- Get offline versions (HTML & PDF)
- Contribute
  
### Known issues
- code-blocks do not scale well (see [workaround](https://github.com/baloise/ws-itsec_owasp/issues/9))
- Inline images do overflow (on the bottom) if format / ratio is ..let's call it unusual. Meaning if your image is much higher than wide, GitPitch seems to auto-fit accordingly to the width.
  - To resolve this you can set it as background (i.e with parameter `&size=contain`, [see here](https://gitpitch.com/docs/image-features/scaling/))
  - If you need to set a title, test, etc this is going to partially cover your image. Thus you could manually enlarge the image with transparency but again, -it's a hassle.
- Opacity is no longer available in the Free Version (You can however, edit your pictures with a graphic program to add opacity -it's a hassle)
- Not there? -please do report