# ForgeFIRM: the Glowforge factory board on linux-fslc 6.12 (mainline).
#
# The factory board runs an NXP vendor kernel (linux-imx 4.14.98) with a set of
# out-of-tree changes. Each one the board needs is re-derived against mainline
# 6.12 as a patch below, never applied as the old 4.14 patch; the ones mainline
# already covers (the OV5648 sensor, the LIS2HH12 accelerometer) bind to in-tree
# drivers, and the bus-frequency scaling disable has no mainline counterpart to
# disable. The config fragment names the board's kernel; the device tree and
# its patches are described in place.
#
# Scoped to MACHINE=glowforge so other boards building linux-fslc are unaffected.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# Config fragment + the device tree (overlaid into arch/arm/boot/dts/nxp/imx via
# file://git/) + the Makefile hook that registers glowforge.dtb, the EPIT/SDMA
# motion-path exposes, the spi-imx PIC inter-word delay (0004, re-derived from
# the factory 4.14 "Add delay to SPI"), the SDMA live-feed hardening (0008),
# the laser-PWM extra prescaler (0009, factory 1001: the ~40 kHz laser
# carrier; not audio-scoped), the capture-queue cache-hint opt-in (0010,
# lets forgectrl request CPU-cached capture buffers), and the three OV8856
# changes the 8 MP "HD" camera modules need (0011 get_mbus_config, the same
# gap 0006 closes for ov5648, 0012 the 24 MHz xvclk the board's sensor
# oscillator runs at, and 0013 the 2-lane RAW8 modes that put full resolution
# inside this SoC's 1 Gbps/lane CSI-2 receiver), and the spi-imx quiet
# fallback to PIO when a controller describes no DMA channels (0014; the PIC's
# ecspi2 has none on purpose), and wlcore asking for its optional NVS file
# without a loader warning (0015; the rootfs ships none, the MAC is fused).
# The factory audio buzzer driver is not part of ForgeFIRM.
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
    file://0011-media-ov8856-implement-get_mbus_config.patch \
    file://0012-media-ov8856-24mhz-xvclk.patch \
    file://0013-media-ov8856-2-lane-raw8-modes.patch \
    file://0014-spi-imx-no-dma-described-is-not-an-error.patch \
    file://0015-wlcore-nvs-is-optional-request-it-without-a-warning.patch \
"

# Debug kernel (item: debug-kernel checks). The lock-correctness fragment
# is added only when FORGEFIRM_KERNEL_DEBUG = "1" (the kas debug variant),
# so a release or a normal dev build carries none of its runtime cost. A
# one-time drill image boots this to run the module load/unload and
# forced-defer drills, then the real image is flashed.
SRC_URI:append:glowforge = "${@' file://glowforge-debug.cfg' if d.getVar('FORGEFIRM_KERNEL_DEBUG') == '1' else ''}"

# (KERNEL_DEVICETREE = nxp/imx/glowforge.dtb is set in conf/machine/glowforge.conf.)
