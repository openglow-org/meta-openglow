# ForgeFIRM: carry the Glowforge factory-board kernel support onto linux-fslc 6.12.
#
# This is the forward-port landing zone for Scarthgap migration #2. The factory
# board ran the NXP vendor kernel (linux-imx 4.14.98) with seven out-of-tree
# changes (PWM prescaler, EPIT API, SDMA-expose, OV5648, SPI delay, LIS2HH12,
# bus-freq-disable). linux-fslc 6.12 is mainline-tracking, so each is re-derived
# against 6.12 here rather than applied as the old 4.14 patch. See kas/README.md
# backlog #2 for the per-item plan and status.
#
# Scoped to MACHINE=glowforge so other boards building linux-fslc are unaffected.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Config fragment + the device tree (overlaid into arch/arm/boot/dts/nxp/imx via
# file://git/) + the Makefile hook that registers glowforge.dtb, the EPIT/SDMA
# motion-path exposes, and the spi-imx PIC inter-word delay (0004, re-derived
# from the factory 4.14 "Add delay to SPI"). Remaining driver patches for later
# milestones (camera, PWM-audio prescaler) get appended here as they are ported.
SRC_URI:append:glowforge = " \
    file://glowforge.cfg \
    file://git/ \
    file://0001-arm-dts-imx-register-glowforge-dtb.patch \
    file://0002-mach-imx-add-glowforge-epit-api.patch \
    file://0003-imx-sdma-expose-glowforge-api.patch \
    file://0004-spi-imx-glowforge-pic-periodreg-delay.patch \
"
# (KERNEL_DEVICETREE = nxp/imx/glowforge.dtb is set in conf/machine/glowforge.conf.)
