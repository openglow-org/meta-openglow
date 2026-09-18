# python3-gfutilities pin. Bump deliberately, like the other project repos;
# keep only SRCREV and PV here - the ForgeFIRM image manifest leaves
# *-pin.inc out of the layer content hash because the component entry
# already identifies the pinned source.
SRCREV = "0a93ebf30b409dc43bd42240216c4d389904a7f4"

# Bump PV with every SRCREV move so the git-hash-derived package version
# stays monotonic (a lower short hash would otherwise trip the
# version-going-backwards QA against the previous pin).
PV = "0.9.19+git"
