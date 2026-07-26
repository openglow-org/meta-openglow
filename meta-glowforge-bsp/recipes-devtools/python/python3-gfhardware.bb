inherit setuptools3

SUMMARY = "Python modules for accessing and controlling Glowforge brand CNC laser hardware."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62f8bb455fcc4bf177ecab380f71cd5d"

SRC_URI = "git://github.com/ScottW514/python3-gfhardware.git;protocol=https;branch=master"
# Pinned; bump deliberately (AUTOREV is not reproducible and once built stale
# code). Current pin: nvmem machine identity, V4L2 error-path hardening,
# cnc/cooling fixes, and the deadman-armed cloud run loop (audit Phase 5).
SRCREV = "1f91f61552a8b63ed335859b1639de1702822329"

S = "${WORKDIR}/git"

DEPENDS += "libv4l libjpeg-turbo"

# gfhardware.cam configures the imx-media capture pipeline at runtime by
# shelling out to media-ctl (links/pad formats) and v4l2-ctl (sensor controls).
RDEPENDS:${PN} += "media-ctl v4l-utils"
