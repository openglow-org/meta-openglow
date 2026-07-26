DESCRIPTION = "Glowforge Kernel Module"
# Source headers grant "version 2 ... or (at your option) any later version".
LICENSE = "GPL-2.0-or-later"

PV = "0.0.1"

SRC_URI = "git://github.com/ScottW514/kernel-module-glowforge.git;protocol=https;branch=master"
SRCREV = "a5e250f7735be54659523571208ec9476f9d1957"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

# cnc.c #includes src/sdma.asm.h, which the Makefile assembles from asm/sdma.asm
# via tools/sdma_asm.pl (Perl) during do_compile, so perl must be on PATH.
# (Also present in the externalsrc .bbappend; kept here so dropping the
# bbappend cannot silently lose it.)
DEPENDS += "perl-native"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/extras/
	install -m 0644 *.ko ${D}/lib/modules/${KERNEL_VERSION}/extras/
}
COMPATIBLE_MACHINE = "glowforge"
