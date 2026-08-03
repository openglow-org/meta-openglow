inherit setuptools3

SUMMARY = "Python modules for accessing and controlling Glowforge brand CNC laser hardware."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62f8bb455fcc4bf177ecab380f71cd5d"

SRC_URI = "git://github.com/ScottW514/python3-gfhardware.git;protocol=https;branch=master"
# Pinned; bump deliberately (AUTOREV is not reproducible).
SRCREV = "b08421b2e0d4631d9d96515069c77dc78edf24f1"

S = "${WORKDIR}/git"

DEPENDS += "libv4l libjpeg-turbo"

# gfhardware.cam configures the imx-media capture pipeline at runtime by
# shelling out to media-ctl (links/pad formats) and v4l2-ctl (sensor controls).
RDEPENDS:${PN} += "media-ctl v4l-utils"
