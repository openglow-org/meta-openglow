# ForgeFIRM: the Glowforge factory bootloader, pinned to upstream U-Boot v2020.01.
#
# Scarthgap's poky ships U-Boot 2024.01, but the factory board predates the
# driver-model/devicetree conversion and uses the legacy IMX_CONFIG mkimage flow
# (see configs/glowforge_defconfig). We therefore pin back to the v2020.01
# release and reuse poky's U-Boot build/install/deploy machinery.
#
# Glowforge board support is overlaid on the upstream tree (board/, the
# glowforge_defconfig, include/configs/glowforge.h) plus a small arch-Kconfig
# registration patch, all via u-boot-glowforge-common_${PV}.inc.
#
# Self-contained recipe: Scarthgap's poky has no u-boot 2020.01 base recipe to
# extend with a .bbappend.
#
# A reference build of the factory bootloader: it deploys u-boot-glowforge.imx
# through the legacy IMX_CONFIG mkimage flow, and no image installs it or
# writes it to any medium (the SD image is a rootfs alone, booted by the
# factory U-Boot in the eMMC boot area; fw_printenv/fw_setenv come from
# libubootenv, and ffboot ships the fw_env.config the image uses).
#
# The board file is the factory source as received. Its v13+ door2 input is
# GPIO1_IO01, while the device tree reads the lid's second switch on
# GPIO1_IO06; the bootloader's doors-closed test is therefore not the
# kernel's, which matters only to the recovery-entry gesture of this build.
#
# Security posture of the v2020.01 pin (deliberate, reviewed):
# - Fielded machines run the FACTORY bootloader; ForgeFIRM installs and
#   updates write only the rootfs slots and the U-Boot environment, never
#   the bootloader.
# - The pin is forced by the hardware-era board code (pre-driver-model,
#   legacy IMX_CONFIG flow); forward-porting the board support is the
#   only way off it.
# - Every new upstream U-Boot CVE must be checked for applicability to
#   v2020.01 and, when applicable, backported here; the SRC_URI:remove
#   below drops a patch because it does not APPLY to this tree, not
#   because the tree is exempt from review.

require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

# Pin back to the v2020.01 release (overrides the 2024.01 SRCREV in u-boot-common.inc).
SRCREV = "303f8fed261020c1cb7da32dad63b610bf6873dd"

# u-boot-common.inc's md5 is for the 2024.01 Licenses/README; pin the v2020.01 one.
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

# The CVE patch carried by u-boot-common.inc targets modern U-Boot and does not
# apply to 2020.01.
SRC_URI:remove = "file://CVE-2025-24857.patch"

DEPENDS += "bc-native dtc-native python3-setuptools-native u-boot-mkimage-native"

# Glowforge board overlay + arch-Kconfig registration.
require u-boot-glowforge-common_${PV}.inc
