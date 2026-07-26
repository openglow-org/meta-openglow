inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# rework (audit M18) lives on master and has no PyPI release yet. Pin
# deliberately, like the other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
SRCREV = "1daef3587986017db43b258a0136a041afb85bff"

PV = "0.9.1+git"

S = "${WORKDIR}/git"
