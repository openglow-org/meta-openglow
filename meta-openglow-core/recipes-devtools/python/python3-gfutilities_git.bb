inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/ScottW514/Glowforge-Utilities.git;protocol=https;branch=master"
# Pinned; bump deliberately, like the other project repos.
SRCREV = "6d309aec110051b69e2e924a7be2fdc5e162b555"

# 0.9.4: the service stack fails toward stopped-and-safe (guarded loop,
# reconnect-surviving WS client, action-thread lifecycle, header
# validation before the ring loads). Bumped so the git-hash-derived
# package version stays monotonic (a lower short hash would otherwise
# trip the version-going-backwards QA against the previous pin).
PV = "0.9.5+git"

S = "${WORKDIR}/git"
