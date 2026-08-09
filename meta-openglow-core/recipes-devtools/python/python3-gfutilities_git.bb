inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
# Pinned; bump deliberately, like the other project repos.
SRCREV = "1a7522fe374f7079a7b95c19f6f392fc4f4cba61"

# 0.9.3: clean service shutdown (the WS client and action threads cannot
# outlive a stop). Bumped so the git-hash-derived package version stays
# monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.3+git"

S = "${WORKDIR}/git"
