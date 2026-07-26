inherit setuptools3

SUMMARY = "Python modules for accessing and controlling Glowforge brand CNC laser hardware."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=934c9462b6bc6ddaa471e69ec7aa7b2b"

SRC_URI = "git://github.com/ScottW514/python3-gfhardware.git;protocol=https;branch=master"
# Pinned to the imx-media camera port (mainline capture pipeline). Bump
# deliberately; AUTOREV is not reproducible and once built the pre-port code,
# which targets the removed factory NXP V4L2 stack.
SRCREV = "9bf31fdebe86c14f05806b1f822d49e09bc7a8e8"

S = "${WORKDIR}/git"

DEPENDS += "libv4l libjpeg-turbo"

# gfhardware.cam configures the imx-media capture pipeline at runtime by
# shelling out to media-ctl (links/pad formats) and v4l2-ctl (sensor controls).
RDEPENDS:${PN} += "media-ctl v4l-utils"
