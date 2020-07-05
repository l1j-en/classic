# l1j-en

l1j-en is an English-language server emulator for the South Korean MMORPG,
Lineage 1.  It targets feature-complete support for the final 2009 US client.

See the project documentation on the
[l1j-en project wiki](https://code.l1j.org/l1j/classic/wikis/home) for general
project info, the client connector, FAQ, and the setup guide.

If you need any help, contact our
[mailing list](https://groups.google.com/forum/#!forum/l1j-en) or hop on the
channel #l1j on Freenode IRC.

### Recent History

This history is being pieced together based on memories and what links can still
be verified.

Pre l1j-jp the history of l1j is somewhat difficult to verify.  Several people
claim they are the original creators.  I've never been able to find proof. Plus
so many years, revisions and changes have gone by I'm not sure how relevant that
even is. I've heard mention of a project called LoSe (or something like that)
that is possibly the parent of all l1j projects.  Or maybe it was just one of
the first and none of its original code still exists, or ever existed within l1j.

There are also several different languages/forks of l1j. The code is so
significantly different within some of them that I'm unsure if they're all forks
or l1j is just often used as a name prefix for new/original code bases.

This code base was originally a fork of
[l1j-jp](https://code.google.com/archive/p/l1j-jp/) named
[lindc](https://code.google.com/archive/p/lindc/)
translated to english with stability and security improvements. An important goal
was to leave the code as similar/compatibile with l1j-jp as possible so we could
take advantage of their content updates.  They had a larger team and progressed
further/faster on that than we did.

Around Oct, 2008 the project was renamed to l1j-en to detach it from any
particular server.  Sometime in l1j-en's early life we began pulling in updates
from l1j-jp2 as well.  jp2 was actually located on l1j.org at that time.

In 2014 the project slowly transitioned to git (on github), away from svn and
googlecode. Github has since removed the repo that was located there.

From 2014 to 2018 the code base has entered many periods of dormancy.  Work began
in earnest again to bring up the zelgo server. Several old and new
members of the project have randomly come and gone over that time period.

In 2018 we moved to l1j.org and are working on cleaning things up, optimizing
things and sticking to the original open source principles of the project.
Code compatibility with other l1j projects is no longer considered a priority,
especially where it is/was in the way of improvements.

As of late 2019, the milestone 10 DB build has been published, along with new
build scripts that work with Java 9 and higher (Java <8 support has been
deprecated accordingly).  With the majority of major issues addressed, the
development team considers this project in a stable state and intends to let
bug reports accumulate prior to any future large-scale rounds of code changes.
Occasional fixes may still be addressed in the meantime, however.  The only
larger remaining task is an eventual migration back to hosting on GitHub.

### Contributing

Report issues and suggest features and improvements on the
[l1j.org issue tracker](https://code.l1j.org/l1j/classic/issues). Discussions and questions
should go to the mailing list and IRC channel.

Pull requests are always welcome!  For those migrating to Git from SVN, see the
[DEVGUIDE](DEVGUIDE.md).

Those interested in joining the development effort as a team member should feel
free to let us know, preferably on the IRC channel.  We always need additional
help with programming, Lineage 1 domain knowledge (particularly with newer
game content), and documentation.

### Legal

No one behind this project offers an opinion on the legality of running a private server.
To the best of our knowledge nothing contained on l1j.org is a result of taking anything
directly from the client.  This is a "clean room" implementation of a server compatible
with the client.

We will not accept contributions that go against this.  Create it yourself or we don't
want it. Any commits that potentially violate copyright/trademark law will be rejected.

### License

Distributed under the GNU General Public License, version 2.
