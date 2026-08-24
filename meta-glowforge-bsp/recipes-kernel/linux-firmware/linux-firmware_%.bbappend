# The WL1805 on this board boots wl18xx-fw-4.bin (PG 2.2 silicon), which is the
# one firmware the current factory image ships next to the wlconf-generated
# wl18xx-conf.bin. The other three variants leave the rootfs, and so does the
# wlcommon package: its wl127x/wl1271 NVS files only make wlcore warn (the MAC
# comes from the chip fuse, and the firmware loader has no user helper to wait
# on), and its TIInit_*.bts scripts are for a Bluetooth core the WL1805 lacks.
do_install:append:glowforge() {
    rm -f ${D}${nonarch_base_libdir}/firmware/ti-connectivity/wl18xx-fw.bin \
          ${D}${nonarch_base_libdir}/firmware/ti-connectivity/wl18xx-fw-2.bin \
          ${D}${nonarch_base_libdir}/firmware/ti-connectivity/wl18xx-fw-3.bin
}

RDEPENDS:${PN}-wl18xx:remove:glowforge = "${PN}-wlcommon"
