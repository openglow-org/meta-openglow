# python3-gfutilities pin. Bump deliberately, like the other project repos;
# keep only SRCREV and PV here - the ForgeFIRM image manifest leaves
# *-pin.inc out of the layer content hash because the component entry
# already identifies the pinned source.
SRCREV = "89dafb4517cbd17c5347af1da8ec801282122a08"

# Bump PV with every SRCREV move so the git-hash-derived package version
# stays monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.12+git"
