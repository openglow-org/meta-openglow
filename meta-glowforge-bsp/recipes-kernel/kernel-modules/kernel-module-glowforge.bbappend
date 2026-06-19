# ForgeFIRM: build glowforge.ko from the local sibling checkout while it is being
# forward-ported to 6.12 (Scarthgap migration #2), mirroring how meta-openglow is
# referenced locally. The sibling is rsync'd next to forgefirm/ (TOPDIR/../..),
# so externalsrc builds the in-progress edits instead of the pinned GitHub rev.
#
# Flip back to the SRC_URI/SRCREV fetch in the base recipe once the 6.12 port is
# upstreamed to the kernel-module-glowforge repo.
inherit externalsrc
EXTERNALSRC = "${TOPDIR}/../../kernel-module-glowforge"
EXTERNALSRC_BUILD = "${EXTERNALSRC}"
