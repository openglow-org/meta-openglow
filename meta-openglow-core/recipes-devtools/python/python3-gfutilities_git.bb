inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
# SRCREV and PV live in the pin file (ForgeFIRM image manifest: *-pin.inc is
# left out of the layer content hash, the component entry identifies the
# source).
require python3-gfutilities-pin.inc

S = "${WORKDIR}/git"
