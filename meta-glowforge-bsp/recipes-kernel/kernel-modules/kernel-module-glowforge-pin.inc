# kernel-module-glowforge pin. Bump deliberately after pushing module
# changes; keep only SRCREV and PV here - the ForgeFIRM image manifest
# leaves *-pin.inc out of the layer content hash because the component
# entry already identifies the pinned source.
SRCREV = "d89121385c48cc0f78fe51b1e0e033a4a724aebc"
PV = "0.0.10"
