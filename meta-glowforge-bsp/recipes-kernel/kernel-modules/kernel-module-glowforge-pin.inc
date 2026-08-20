# kernel-module-glowforge pin. Bump deliberately after pushing module
# changes; keep only SRCREV and PV here - the ForgeFIRM image manifest
# leaves *-pin.inc out of the layer content hash because the component
# entry already identifies the pinned source.
SRCREV = "3a9f045ef9e6bacefb386e64cb5ab23414adb328"
PV = "0.0.1"
