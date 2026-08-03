inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
SRCREV = "19278d241ece680a7102e9f1c9ebcaf85b4dfdb8"

PV = "0.9.1+git"

S = "${WORKDIR}/git"
