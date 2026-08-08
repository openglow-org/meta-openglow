inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=cloud-action-surface"
# TEST-image pin to the cloud-action-surface branch (full cloud action surface,
# session lifecycle, gfcloud daemon support); repoint to master after merge.
SRCREV = "69e6c35df3f0365f034f07909ae2add359827124"

# 0.9.2: the full cloud action surface, session-lifecycle robustness, and
# gfcloud daemon support. Bumped past 0.9.1 so the git-hash-derived package
# version stays monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.2+git"

S = "${WORKDIR}/git"
