DESCRIPTION = "Glowforge Kernel Module"
# Source headers grant "version 2 ... or (at your option) any later version".
LICENSE = "GPL-2.0-or-later"

SRC_URI = "git://github.com/openglow-org/kernel-module-glowforge.git;protocol=https;branch=master"
# SRCREV and PV live in the pin file (ForgeFIRM image manifest: *-pin.inc is
# left out of the layer content hash, the component entry identifies the
# source).
require kernel-module-glowforge-pin.inc
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

# cnc.c #includes src/sdma.asm.h, which the Makefile assembles from asm/sdma.asm
# via tools/sdma_asm.pl (Perl) during do_compile, so perl must be on PATH.
DEPENDS += "perl-native"

# Warnings are errors for this module in this build. The kernel makes a core
# set fatal on its own (implicit declarations, return types, incompatible
# pointer types) but leaves the rest as warnings unless CONFIG_WERROR is set,
# and a bitbake compile log is not somewhere warnings get noticed. Enforced
# here rather than in the module's Makefile so an out-of-tree build against a
# different kernel or compiler is not held to this project's toolchain.
EXTRA_OEMAKE += "KCFLAGS=-Werror"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/extras/
	install -m 0644 *.ko ${D}/lib/modules/${KERNEL_VERSION}/extras/
}
COMPATIBLE_MACHINE = "glowforge"
