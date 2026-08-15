DESCRIPTION = "Configuration utility for TI wireless drivers"
HOMEPAGE = "https://github.com/TI-OpenLink/ti-utils"

# The vendored tarball is TI's WiLink8 utilities release R8.7 SP3
# (18xx-ti-utils-R8.7_SP3; its README names github.com/TI-OpenLink/ti-utils
# as the project repository), sha256
# 5189a76aeeefb34e7efc5ef8199e259ec394a6276d0f1b36ce0c0adf6884ad8e.
# It carries three license regimes:
#   - wlconf/ (this recipe's whole build and install set: the wlconf tool,
#     its struct/dictionary data, default.conf and the wl18xx-conf binary
#     generated from it): GPL-2.0-only, notice in wlconf/README.
#   - the calibrator and other utilities at the tarball root: BSD-3-Clause
#     (COPYING). Not built, not installed.
#   - hw/firmware/: TI wl12xx firmware images under the TI TSPA license
#     (hw/firmware/LICENCE, binary-only, no reverse engineering). Not
#     installed; nothing from that directory reaches the image.
# LICENSE lists everything the unpacked source contains so the license
# manifest and the source archive are honest; the packaged output is GPL-2.0-only.
LICENSE = "GPL-2.0-only & BSD-3-Clause & TI-TSPA"
LICENSE:${PN} = "GPL-2.0-only"
LIC_FILES_CHKSUM = " 	file://README;beginline=1;endline=21;md5=adc05a1903d3f107f85c90328e3a9438 	file://../COPYING;md5=4725015cb0be7be389cf06deeae3683d 	file://../hw/firmware/LICENCE;md5=ba590e1d103f891d0151609046aef9e8 "

SRC_URI = "file://18xx-ti-utils-R8.7_SP3.tar.gz"

S = "${WORKDIR}/18xx-ti-utils-R8.7_SP3/wlconf"

EXTRA_OEMAKE = "CC="${CC}""

do_install() {
	install -d ${D}${sbindir}
	install -d ${D}${sbindir}/wlconf/
	install -d ${D}${sbindir}/wlconf/official_inis
	install -d ${D}/lib/firmware/ti-connectivity

	install -m 0755 wlconf ${D}${sbindir}/wlconf/
	install -m 0644 dictionary.txt ${D}${sbindir}/wlconf/
	install -m 0644 struct.bin ${D}${sbindir}/wlconf/
	install -m 0644 default.conf ${D}${sbindir}/wlconf/
	install -m 0644 wl18xx-conf-default.bin ${D}${sbindir}/wlconf/
	install -m 0644 wl18xx-conf-default.bin ${D}/lib/firmware/ti-connectivity/wl18xx-conf.bin
	install -m 0644 README ${D}${sbindir}/wlconf/
	install -m 0644 example.conf ${D}${sbindir}/wlconf/
	install -m 0644 example.ini ${D}${sbindir}/wlconf/
	install -m 0755 configure-device.sh ${D}${sbindir}/wlconf/
	install -m 0644 ${S}/official_inis/* \
			${D}${sbindir}/wlconf/official_inis/
}

FILES:${PN} += " \
	${sbindir}/wlconf \
	${sbindir}/wlconf/official_inis \
	/lib/firmware/ti-connectivity/wl18xx-conf.bin \
"

FILES:${PN}-dbg += "${sbindir}/wlconf/.debug"
COMPATIBLE_MACHINE = "glowforge"
