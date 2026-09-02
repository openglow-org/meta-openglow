FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
do_install_basefilesissue () {
	install -m 644 ${WORKDIR}/issue*  ${D}${sysconfdir}
}

# The prompt rides poky's own profile through profile.d, so the profile's
# terminal-size handling on the serial console stays.
SRC_URI += "file://openglow-prompt.sh"
do_install:append () {
	install -d ${D}${sysconfdir}/profile.d
	install -m 0644 ${WORKDIR}/openglow-prompt.sh ${D}${sysconfdir}/profile.d/openglow-prompt.sh
}
