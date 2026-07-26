inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# rework (audit M18) lives on master and has no PyPI release yet. Pin
# deliberately, like the other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
SRCREV = "2d24239b6ef04760859360dfe441b296432ff8fe"

PV = "0.9.1+git"

S = "${WORKDIR}/git"
