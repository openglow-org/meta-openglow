inherit setuptools3
require python-gfutilities.inc

# Fetched from git rather than the PyPI 0.9.1 sdist: the deadman/failsafe
# handling on master has no PyPI release yet. Pin deliberately, like the
# other project repos.
SRC_URI = "git://github.com/openglow-org/Glowforge-Utilities.git;protocol=https;branch=master"
# SRCREV and PV live in the pin file (ForgeFIRM image manifest: *-pin.inc is
# left out of the layer content hash, the component entry identifies the
# source).
require python3-gfutilities-pin.inc

S = "${WORKDIR}/git"

# The emulator's fixtures: the canned camera frames and the sample config
# the gf-machine-emulator example answers the service with (examples/ in
# the source tree, not part of the Python package). Packaged on their own
# so the dev image carries them for the acceptance tool's service-protocol
# test and the release image does not carry 3 MB of test frames.
PACKAGES =+ "${PN}-emulator"
FILES:${PN}-emulator = "${datadir}/gfutilities/emulator"
RDEPENDS:${PN}-emulator += "${PN}"

do_install:append() {
    install -d ${D}${datadir}/gfutilities/emulator
    install -m 0644 ${S}/examples/_RESOURCES/IMG/*.jpg ${D}${datadir}/gfutilities/emulator/
    install -m 0644 ${S}/examples/gf-machine-emulator.cfg.sample ${D}${datadir}/gfutilities/emulator/
}
