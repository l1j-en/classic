l1j-en
======

l1j-en is an English-language server emulator for the South Korean MMORPG,
Lineage 1.

This repo started as a direct copy of the
[l1j-en project on Google Code](http://www.googlecode.com/p/l1j-en) as of their
revision 726.  See the project documentation there for general project info,
the client connector, a setup guide, and FAQ.

We pulled upstream updates from l1j-jp2 but have diverged significantly. As of
March 2014, everial's downstream fork was merged back into master.  As of June
2014, this and the Google Code repo are synced, with this GitHub version
typically getting fixes first.

If you need any help, contact our
[mailing list](https://groups.google.com/forum/#!forum/l1j-en) or hop on #l1j
at freenode and see if anyone's around.

About GitHub
------------

To actually reap the benefits of git, there are some small changes that have to
be made in the development cycle that any of our old team members won't be used
to. I'll try to write a small "Getting started/switching from SVN" guide soon.

For an extremely condensed version:

1. Checkout with: `git clone https://username@github.com/l1j/en.git`

2. Make a change, then commit (commit isn't like an SVN commit.  It only
commits it to your own local "branch".  `git commit -a`

3. Push the change upstream (this is where it acts like an SVN commit and
pushes it to the main repo)  `git push`

One slight change in a dev's normal "process", that I believe will help a ton,
are the branches.  For example, if you're working on a branch named "thebes":

1. `checkout`

2. `git checkout master`

3. `git branch thebes` (create your own local branch to work on a specific
   feature)

4. do your work, when you feel your finished, move to next step

5. `git commit -a` (commit changes to your local "thebes" branch)

6. `git checkout` (switch to the global development branch)

7. `git merge thebes` (merge in any changes from your thebes branch)

8. `git commit -a`

9. `git push`

I know that seems like many more steps than our old SVN system, but it starts
to come naturally very quickly, and the benefits are enormous.  Some of the
commands have the same name as the old SVN commands, but work a little
differently.  That can cause some confusion but again you get used to it very
quickly.

