FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# DHCPv6 client. The distro's ipv6 feature turns on busybox's IPv6 networking
# and ifupdown's inet6 methods, but poky's defconfig leaves udhcpc6 out; the
# fragment adds it (with the DNS option, RFC 3646) and the hook script it runs
# to apply a lease, which ifupdown starts from the wlan0 inet6 stanza.
SRC_URI += " \
    file://udhcpc6.cfg \
    file://default6.script \
"

do_install:append() {
    install -d ${D}${datadir}/udhcpc
    install -m 0755 ${WORKDIR}/default6.script ${D}${datadir}/udhcpc/default6.script
}

FILES:${PN}-udhcpc += "${datadir}/udhcpc/default6.script"
