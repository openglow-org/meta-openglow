inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
# Pinned; bump deliberately, like the other project repos.
SRCREV = "11e4b85a3bfef9deafd57cd2cd645f877a0358e4"

# 0.9.4: the service stack fails toward stopped-and-safe (guarded loop,
# reconnect-surviving WS client, action-thread lifecycle, header
# validation before the ring loads). Bumped so the git-hash-derived
# package version stays monotonic (a lower short hash would otherwise
# trip the version-going-backwards QA against the previous pin).
PV = "0.9.4+git"

S = "${WORKDIR}/git"
