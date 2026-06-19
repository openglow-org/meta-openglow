PREFERRED_PROVIDER_u-boot ??= "u-boot"
PREFERRED_PROVIDER_virtual/bootloader ??= "u-boot"
# Scarthgap dropped u-boot-fw-utils; libubootenv provides fw_printenv/fw_setenv.
PREFERRED_PROVIDER_u-boot-fw-utils ??= "libubootenv"

PREFERRED_PROVIDER_virtual/xserver = ""
