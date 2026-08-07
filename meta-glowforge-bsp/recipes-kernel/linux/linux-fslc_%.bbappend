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
# motion-path exposes, the spi-imx PIC inter-word delay (0004, re-derived from
# the factory 4.14 "Add delay to SPI"), the SDMA live-feed hardening (0008),
# the laser-PWM extra prescaler (0009, factory 1001 — the ~40 kHz laser
# carrier; not audio-scoped), and the capture-queue cache-hint opt-in (0010,
# lets forgectrl request CPU-cached capture buffers). Still deferred: the
# audio buzzer driver.
SRC_URI:append:glowforge = " \
    file://glowforge.cfg \
    file://git/ \
    file://0001-arm-dts-imx-register-glowforge-dtb.patch \
    file://0002-mach-imx-add-glowforge-epit-api.patch \
    file://0003-imx-sdma-expose-glowforge-api.patch \
    file://0004-spi-imx-glowforge-pic-periodreg-delay.patch \
    file://0005-media-video-mux-forward-get_mbus_config.patch \
    file://0006-media-ov5648-implement-get_mbus_config.patch \
    file://0007-media-imx6-mipi-csi2-link-freq-behind-mux.patch \
    file://0008-imx-sdma-preallocate-glowforge-datamem-bounce.patch \
    file://0009-pwm-imx27-glowforge-extra-prescale.patch \
    file://0010-media-imx-capture-allow-cache-hints.patch \
"
# (KERNEL_DEVICETREE = nxp/imx/glowforge.dtb is set in conf/machine/glowforge.conf.)
