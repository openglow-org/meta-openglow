inherit setuptools3

SUMMARY = "Python modules for accessing and controlling Glowforge brand CNC laser hardware."

# gfhardware/src/bayer.c (libdc1394's Bayer decoder) is LGPL-2.1-or-later and
# is compiled into the gfhardware._cam extension alongside the MIT sources.
LICENSE = "MIT & LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "     file://LICENSE;md5=62f8bb455fcc4bf177ecab380f71cd5d     file://LICENSE.LGPL-2.1;md5=2a4f4fd2128ea2f65047ee63fbca9f68     file://gfhardware/src/bayer.c;beginline=1;endline=23;md5=c9ff59d801d2fd49e79e261521f425a2 "

SRC_URI = "git://github.com/ScottW514/python3-gfhardware.git;protocol=https;branch=master"
# Pinned; bump deliberately (AUTOREV is not reproducible).
SRCREV = "a0a174d8e9a6b4b6e3abe63acc51018199df4202"

S = "${WORKDIR}/git"

DEPENDS += "libv4l libjpeg-turbo"

# gfhardware.cam configures the imx-media capture pipeline at runtime by
# shelling out to media-ctl (links/pad formats) and v4l2-ctl (sensor controls).
RDEPENDS:${PN} += "media-ctl v4l-utils"
