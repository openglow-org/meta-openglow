# kernel-module-glowforge pin. Bump deliberately after pushing module
# changes; keep only SRCREV and PV here - the ForgeFIRM image manifest
# leaves *-pin.inc out of the layer content hash because the component
# entry already identifies the pinned source.
SRCREV = "f924cd9b885a21edebab792a9067b917fece819e"
PV = "0.0.7"
