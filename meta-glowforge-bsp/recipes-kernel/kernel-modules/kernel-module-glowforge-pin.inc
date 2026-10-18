# kernel-module-glowforge pin. Bump deliberately after pushing module
# changes; keep only SRCREV and PV here - the ForgeFIRM image manifest
# leaves *-pin.inc out of the layer content hash because the component
# entry already identifies the pinned source.
SRCREV = "dab378da805d8a31ecb6906d51fcfd3cefe3789f"
PV = "0.0.8"
