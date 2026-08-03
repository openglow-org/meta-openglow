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
# Status: builds clean under Scarthgap (GCC 13), no source fixes needed, and
# deploys u-boot-glowforge.imx via the legacy IMX_CONFIG mkimage flow.
# Remaining (image-level): in Scarthgap, fw_printenv/fw_setenv come from
# libubootenv rather than u-boot-fw-utils — revisit
# PREFERRED_PROVIDER_u-boot-fw-utils in glowforge.inc when the rootfs needs them.

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
