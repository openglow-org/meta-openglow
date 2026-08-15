inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
# Pinned; bump deliberately, like the other project repos.
SRCREV = "20bea6e950405e5a7c5b5f1561e91939c4d98802"

# 0.9.4: the service stack fails toward stopped-and-safe (guarded loop,
# reconnect-surviving WS client, action-thread lifecycle, header
# validation before the ring loads). Bumped so the git-hash-derived
# package version stays monotonic (a lower short hash would otherwise
# trip the version-going-backwards QA against the previous pin).
PV = "0.9.6+git"

S = "${WORKDIR}/git"
