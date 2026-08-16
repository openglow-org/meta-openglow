# python3-gfutilities pin. Bump deliberately, like the other project repos;
# keep only SRCREV and PV here - the ForgeFIRM image manifest leaves
# *-pin.inc out of the layer content hash because the component entry
# already identifies the pinned source.
SRCREV = "505c4c91d31004bcfcd05396c2bc59ea1df94ffa"

# Bump PV with every SRCREV move so the git-hash-derived package version
# stays monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.7+git"
