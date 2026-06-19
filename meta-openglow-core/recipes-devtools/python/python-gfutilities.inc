SUMMARY = "A small collection of utilties to aid in firmware development for the Glowforge laser cutter."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Checksum for the gfutilities 0.9.1 PyPI sdist (md5 dropped — sha256 is authoritative).
SRC_URI[sha256sum] = "39e2d4c5fa943d148604368f9a5826064700b60b586e967588885a5d54238518"

BBCLASSEXTEND = "native nativesdk"

# gfutilities 0.9.1 install_requires: requests, urllib3, websocket-client.
# (0.9.1 replaced the old lomond websocket lib with websocket-client. gfutilities
# eagerly imports its WSS service at package load, so anything importing it —
# e.g. python3-gfhardware — fails with ModuleNotFoundError: 'websocket' unless
# websocket-client is installed.)
RDEPENDS:${PN} += "\
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-websocket-client \
    "
