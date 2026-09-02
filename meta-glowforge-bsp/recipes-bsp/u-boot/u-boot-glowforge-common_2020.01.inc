FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://Add-Glowforge-to-Arch-Kconfig.patch \
	file://git/ \
"
COMPATIBLE_MACHINE = "glowforge"
